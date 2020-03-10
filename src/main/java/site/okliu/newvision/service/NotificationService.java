package site.okliu.newvision.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.okliu.newvision.dto.NotificationDTO;
import site.okliu.newvision.dto.PaginationDTO;
import site.okliu.newvision.enums.NotificationStatusEnum;
import site.okliu.newvision.enums.NotificationTypeEnum;
import site.okliu.newvision.exception.CustomizeErrorCode;
import site.okliu.newvision.exception.CustomizeException;
import site.okliu.newvision.mapper.NotificationExtMapper;
import site.okliu.newvision.mapper.NotificationMapper;
import site.okliu.newvision.model.Notification;
import site.okliu.newvision.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class NotificationService {

    private NotificationMapper notificationMapper;
    private NotificationExtMapper notificationExtMapper;

    @Autowired
    public NotificationService(NotificationMapper notificationMapper, NotificationExtMapper notificationExtMapper) {
        this.notificationMapper = notificationMapper;
        this.notificationExtMapper = notificationExtMapper;
    }

    public PaginationDTO<NotificationDTO> list(Long userId, Integer page, Integer size) {
        PaginationDTO<NotificationDTO> paginationDTO = new PaginationDTO();
        Long count = notificationExtMapper.countByReceiver(userId);
        paginationDTO.setPaginationDTO(count, page, size);
        if (page < 1) {
            page = 1;
        }
        if (page > paginationDTO.getTotalPages()) {
            page = paginationDTO.getTotalPages();
        }
        Integer offset = size * (page - 1);
        List<Notification> notifications = notificationExtMapper.list(userId, size, offset);
        if (notifications.isEmpty()) {
            return paginationDTO;
        }
        List<NotificationDTO> notificationDTOS = new ArrayList<>();
        for (Notification notification : notifications) {
            NotificationDTO notificationDTO = new NotificationDTO();
            BeanUtils.copyProperties(notification, notificationDTO);
            notificationDTO.setTypeName(NotificationTypeEnum.nameOfType(notification.getType()));
            notificationDTOS.add(notificationDTO);
        }
        paginationDTO.setData(notificationDTOS);
        return paginationDTO;
    }

    public Long unreadCount(Long userId) {
        return notificationExtMapper.countUnread(userId);
    }

    public NotificationDTO read(Long id, User user) {
        Optional<Notification> notificationOptional = notificationMapper.selectByPrimaryKey(id);
        if (!notificationOptional.isPresent()) {
            throw new CustomizeException(CustomizeErrorCode.NOTIFICATION_NOT_FOUND);
        }
        Notification notification = notificationOptional.get();
        if (!Objects.equals(notification.getReceiver(), user.getId())) {
            throw new CustomizeException(CustomizeErrorCode.READ_NOTIFICATION_FAIL);
        }
        notification.setStatus(NotificationStatusEnum.READ.getStatus());
        notificationMapper.updateByPrimaryKey(notification);
        NotificationDTO notificationDTO = new NotificationDTO();
        BeanUtils.copyProperties(notification, notificationDTO);
        notificationDTO.setTypeName(NotificationTypeEnum.nameOfType(notification.getType()));
        return notificationDTO;
    }

    public void insert(Notification notification) {
        notificationMapper.insert(notification);
    }
}
