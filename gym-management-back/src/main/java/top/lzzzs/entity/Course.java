package top.lzzzs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lzzzs
 * @since 2023-02-16
 */
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程表id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 课程图片
     */
    private String img;

    /**
     * 课程详情
     */
    private String detailText;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    public String getDetailText() {
        return detailText;
    }

    public void setDetailText(String detailText) {
        this.detailText = detailText;
    }

    @Override
    public String toString() {
        return "Course{" +
            "id=" + id +
            ", img=" + img +
            ", detailText=" + detailText +
        "}";
    }
}
