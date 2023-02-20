package top.lzzzs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import top.lzzzs.entity.CourseSubscribe;
import top.lzzzs.mapper.CourseSubscribeMapper;
import top.lzzzs.service.ICourseSubscribeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lzzzs
 * @since 2023-02-20
 */
@Service
public class CourseSubscribeServiceImpl extends ServiceImpl<CourseSubscribeMapper, CourseSubscribe> implements ICourseSubscribeService {

    @Autowired
    CourseSubscribeMapper courseSubscribeMapper;

    @Override
    public List<CourseSubscribe> getAllCourseSubscribe() {
        return courseSubscribeMapper.getAllCourseSubscribe();
    }
}
