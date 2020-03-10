package site.okliu.newvision.cache;

import lombok.Data;
import org.springframework.stereotype.Component;
import site.okliu.newvision.dto.HotTagDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

@Component
@Data
public class HotTagCache {

    private List<HotTagDTO> hots = new ArrayList<>();

    public void updateHotTags(Map<String, HotTagDTO> tags) {
        int max = 5;
        PriorityQueue<HotTagDTO> priorityQueue = new PriorityQueue<>(max);
        tags.forEach((name, hotTagDTO) -> {
            if (priorityQueue.size() < max) {
                priorityQueue.offer(hotTagDTO);
            } else {
                HotTagDTO minHot = priorityQueue.peek();// 查看队首元素
                if (hotTagDTO.compareTo(minHot) > 0) {// 比较：如果当前大于队首
                    priorityQueue.poll(); // 移除队首
                    priorityQueue.offer(hotTagDTO);// 添加到队列（队首）
                }
            }
        });
        List<HotTagDTO> sortedTags = new ArrayList<>();
        HotTagDTO poll = priorityQueue.poll();
        while (poll != null) {
            sortedTags.add(0, poll);
            poll = priorityQueue.poll();
        }
        hots = sortedTags;
    }

}
