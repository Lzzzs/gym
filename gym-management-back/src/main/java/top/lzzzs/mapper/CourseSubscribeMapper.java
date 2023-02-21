package top.lzzzs.mapper;

import top.lzzzs.entity.CourseSubscribe;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lzzzs
 * @since 2023-02-20
 */
public interface CourseSubscribeMapper extends BaseMapper<CourseSubscribe> {
    List<CourseSubscribe> getAllCourseSubscribe();
}
