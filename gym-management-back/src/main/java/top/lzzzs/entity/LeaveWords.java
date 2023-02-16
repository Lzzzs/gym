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
 * @since 2023-02-14
 */
@TableName("leave_words")
public class LeaveWords implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 留言表主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 留言用户的id
     */
    private String userId;

    /**
     * 留言用户名字
     */
    private String name;

    /**
     * 留言用户号码
     */
    private String phone;

    /**
     * 留言内容
     */
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "LeaveWords{" +
            "id = " + id +
            ", userId = " + userId +
            ", name = " + name +
            ", phone = " + phone +
            ", content = " + content +
        "}";
    }
}
