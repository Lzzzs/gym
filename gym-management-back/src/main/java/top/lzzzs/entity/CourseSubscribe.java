package top.lzzzs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author lzzzs
 * @since 2023-02-20
 */
@TableName("course_subscribe")
@Data
public class CourseSubscribe implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程预约表id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 预约的课程id
     */
    private Integer courseId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 预约截止时间
     */
    private String subscribeTime;

    /**
     * 是否完成，0还未完成，1已完成
     */
    private Integer isDone;

    private Course course;

    private Users user;
}
