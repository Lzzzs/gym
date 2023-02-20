package top.lzzzs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lzzzs
 * @since 2023-02-20
 */
@TableName("course_subscribe")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(String subscribeTime) {
        this.subscribeTime = subscribeTime;
    }
    public Integer getIsDone() {
        return isDone;
    }

    public void setIsDone(Integer isDone) {
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return "CourseSubscribe{" +
            "id=" + id +
            ", courseId=" + courseId +
            ", userId=" + userId +
            ", subscribeTime=" + subscribeTime +
            ", isDone=" + isDone +
        "}";
    }
}
