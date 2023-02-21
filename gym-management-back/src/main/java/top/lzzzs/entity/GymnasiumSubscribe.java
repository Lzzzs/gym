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
 * @since 2023-02-16
 */
@TableName("gymnasium_subscribe")
@Data
public class GymnasiumSubscribe implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 健身房预约表id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 健身房id
     */
    private Integer gymnasiumId;

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

    /**
     * 预约开始时间
     */
    private String subscribeTimeStart;

    /**
     * 当前订阅是否正在进行中
     */
    private Integer ing;

}
