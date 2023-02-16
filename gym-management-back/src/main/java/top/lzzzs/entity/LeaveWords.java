package top.lzzzs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

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
@Data
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

    /**
     * 回复内容
     */
    private String replyContent;

    /**
     * 回复时间
     */
    private String replyTime;

}
