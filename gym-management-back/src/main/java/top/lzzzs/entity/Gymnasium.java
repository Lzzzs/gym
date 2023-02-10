package top.lzzzs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lzzzs
 * @since 2023-02-07
 */
public class Gymnasium implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 健身房id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @JsonIgnore
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCurnum() {
        return curnum;
    }

    public void setCurnum(Integer curnum) {
        this.curnum = curnum;
    }

    public Integer getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(Integer totalnum) {
        this.totalnum = totalnum;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Gymnasium{" +
            "id = " + id +
            ", curnum = " + curnum +
            ", totalnum = " + totalnum +
            ", place = " + place +
        "}";
    }
}
