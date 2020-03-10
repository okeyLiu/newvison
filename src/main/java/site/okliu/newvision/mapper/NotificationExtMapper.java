package site.okliu.newvision.mapper;

import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import site.okliu.newvision.enums.NotificationStatusEnum;
import site.okliu.newvision.model.Notification;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static site.okliu.newvision.mapper.NotificationDynamicSqlSupport.*;

@Repository
public class NotificationExtMapper {

    private NotificationMapper notificationMapper;

    @Autowired
    public NotificationExtMapper(NotificationMapper notificationMapper) {
        this.notificationMapper = notificationMapper;
    }

    /**
     * 返回接收者的未通知消息数量
     *
     * @param userId
     * @return
     */
    public Long countUnread(Long userId) {
        SelectStatementProvider countSelect = select(count())
                .from(notification)
                .where(receiver, isEqualTo(userId))
                .and(status, isEqualTo(NotificationStatusEnum.UNREAD.getStatus()))
                .build().render(RenderingStrategies.MYBATIS3);
        return notificationMapper.count(countSelect);
    }

    /**
     * 返回接收者的通知消息数量
     *
     * @param userId
     * @return
     */
    public Long countByReceiver(Long userId) {
        SelectStatementProvider countSelect = select(count())
                .from(notification)
                .where(receiver, isEqualTo(userId))
                .build().render(RenderingStrategies.MYBATIS3);
        return notificationMapper.count(countSelect);
    }

    /**
     * 返回接收者的所有消息
     *
     * @param userId
     * @param size
     * @param offset
     * @return
     */
    public List<Notification> list(Long userId, Integer size, Integer offset) {
        SelectStatementProvider pageSelect = select(notification.allColumns())
                .from(notification)
                .where(receiver, isEqualTo(userId))
                .orderBy(status, gmtCreate.descending())// 优先未读（0）  已读（1），然后按照时间降序
                .limit(size)
                .offset(offset)
                .build().render(RenderingStrategies.MYBATIS3);
        return notificationMapper.selectMany(pageSelect);
    }
}
