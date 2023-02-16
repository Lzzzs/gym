package top.lzzzs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lzzzs
 * @since 2023-02-15
 */
@Data
public class Gymnasium implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 健身房id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 当前人数
     */
    private Integer curnum;

    /**
     * 总人数
     */
    private Integer totalnum;

    /**
     * 健身房地址
     */
    private String place;

    /**
     * 详情文字
     */
    private String detailText;

    /**
     * 详情图片
     */
    private String detailImg;

    /**
     * 健身房图片
     */
    private String img;

    /**
     * 健身房名字
     */
    private String name;

}
