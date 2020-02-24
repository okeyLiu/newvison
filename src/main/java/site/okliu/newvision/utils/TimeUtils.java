package site.okliu.newvision.utils;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

public class TimeUtils {

    private TimeUtils() {
    }

    public static final String PATTERN = "yyyy年MM月dd日 HH:mm:ss";

    /**
     * 返回时间关系
     *
     * @param timestamp 时间毫秒值
     * @return
     */
    public static String relationTime(long timestamp) {
        LocalDateTime from = new Date(timestamp).toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime();
        return getRealationString(from);
    }

    /**
     * 返回时间关系
     *
     * @param time
     * @return
     */
    public static String relationTime(String time) {
        // 1 根据字符串解析出时间
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(PATTERN);
        LocalDateTime from = LocalDateTime.from(dateTimeFormatter.parse(time));
        // 2 计算出与当前的时间时长
        return getRealationString(from);
    }

    private static String getRealationString(LocalDateTime from) {
        // 2 计算出与当前的时间时长
        Duration dr = Duration.between(from, LocalDateTime.now());
        // 3 根据时间进行处理
        long seconds = dr.getSeconds();
        if (seconds < 60) {
            return "刚刚";
        } else {
            long minutes = dr.toMinutes();
            if (minutes < 60) {
                return minutes + "分钟前";
            } else {
                long hours = dr.toHours();
                if (hours < 24) {
                    return hours + "小时前";
                } else {
                    long days = dr.toDays();
                    if (days < 7) {
                        return days + "天前";
                    }
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(PATTERN);
                    return dateTimeFormatter.format(from);
                }
            }
        }
    }


    public static long getTimeMillis(LocalDateTime localDateTime) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        String formatTime = localDateTime.toString();
        try {
            Date parse = simpleDateFormat.parse(formatTime);
            return parse.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
