package top.lzzzs.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import top.lzzzs.common.R;
import top.lzzzs.common.Rcode;
import top.lzzzs.entity.Course;
import top.lzzzs.entity.CourseSubscribe;
import top.lzzzs.entity.Gymnasium;
import top.lzzzs.entity.GymnasiumSubscribe;
import top.lzzzs.service.ICourseService;
import top.lzzzs.service.ICourseSubscribeService;
import top.lzzzs.service.IGymnasiumService;
import top.lzzzs.service.IGymnasiumSubscribeService;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lzzzs
 * @since 2023-02-20
 */
@RestController
public class CourseSubscribeController {
    @Autowired
    ICourseSubscribeService courseSubscribeService;


    @PostMapping("/saveCourseSubscribe")
    public R saveCourseSubscribe(@RequestBody CourseSubscribe courseSubscribe) {
        return R.success(courseSubscribeService.save(courseSubscribe));
    }

    @GetMapping("/getAllCourseSubscribe")
    public R getAllCourseSubscribe() {
        return R.success(courseSubscribeService.getAllCourseSubscribe());
    }

    @DeleteMapping("deleteCourseSubscribe/{id}")
    public R deleteCourseSubscribe(@PathVariable("id") String id) {
        UpdateWrapper<CourseSubscribe> subscribeUpdateWrapper = new UpdateWrapper<>();
        subscribeUpdateWrapper.eq("id", id).set("is_done", 1);
        return R.success(courseSubscribeService.update(null, subscribeUpdateWrapper));
    }
}
