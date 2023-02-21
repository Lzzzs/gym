package top.lzzzs.service;

import top.lzzzs.entity.CourseSubscribe;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lzzzs
 * @since 2023-02-20
 */
public interface ICourseSubscribeService extends IService<CourseSubscribe> {
    List<CourseSubscribe> getAllCourseSubscribe();
}
