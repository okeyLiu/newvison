package site.okliu.newvision.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import site.okliu.newvision.cache.HotTagCache;
import site.okliu.newvision.dto.HotTagDTO;
import site.okliu.newvision.model.Question;
import site.okliu.newvision.service.QuestionService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Component
@Slf4j
public class HotTagTasks {
    private HotTagCache hotTagCache;
    private QuestionService questionService;

    @Autowired
    public HotTagTasks(HotTagCache hotTagCache, QuestionService questionService) {
        this.hotTagCache = hotTagCache;
        this.questionService = questionService;
    }

    @Scheduled(fixedRate = 1000*60*60*3)
    public void updateHotTags() {
        log.info("update hot tags at {}", LocalDateTime.now());
        // 获取所有问题，并计算问题的排序顺序权重
        int offset = 0;
        int limit = 5;
        List<Question> list = new ArrayList<>();
        Map<String, HotTagDTO> priorities = new HashMap<>();
        while (offset == 0 || list.size() == limit) {
            list = questionService.list(offset, limit);
            list.forEach(q -> {
                String[] tags = q.getTag().split(",");
                Stream.of(tags).forEach(tag -> {
                    if (priorities.containsKey(tag)) {
                        HotTagDTO hotTagDTO = priorities.get(tag);
                        // 排序顺序计算规则： 问题数*50 + 评论数*20 + 阅读数/50 + 点赞 * 5
                        hotTagDTO.setPriority(hotTagDTO.getPriority() + 50 + q.getCommentCount() * 20 + q.getViewCount() / 50 + q.getLikeCount() * 5);
                        hotTagDTO.setQuestionCount(hotTagDTO.getQuestionCount() + 1);// 记录问题数
                        hotTagDTO.setCommentCount(hotTagDTO.getCommentCount() + q.getCommentCount());// 记录评论数
                        hotTagDTO.setViewCount(hotTagDTO.getViewCount() + q.getViewCount());// 记录阅读数
                        hotTagDTO.setLikeCount(hotTagDTO.getLikeCount() + q.getLikeCount());// 记录点赞数
                        priorities.put(tag, hotTagDTO);
                    } else {
                        HotTagDTO hotTagDTO = new HotTagDTO();
                        hotTagDTO.setName(tag);
                        hotTagDTO.setPriority(50 + q.getCommentCount() * 20 + q.getViewCount() / 50 + q.getLikeCount() * 5);
                        hotTagDTO.setQuestionCount(1);// 记录问题数
                        hotTagDTO.setCommentCount(q.getCommentCount());// 记录评论数
                        hotTagDTO.setViewCount(q.getViewCount());// 记录阅读数
                        hotTagDTO.setLikeCount(q.getLikeCount());// 记录点赞数
                        priorities.put(tag, hotTagDTO);
                    }
                });
            });
            offset += limit;
        }
        // 更新
        hotTagCache.updateHotTags(priorities);
    }

}
