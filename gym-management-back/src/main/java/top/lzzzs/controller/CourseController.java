package top.lzzzs.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.lzzzs.common.R;
import top.lzzzs.entity.Course;
import top.lzzzs.entity.Gymnasium;
import top.lzzzs.mapper.CourseMapper;

import java.util.HashMap;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lzzzs
 * @since 2023-02-16
 */
@RestController
public class CourseController {

    @Autowired
    CourseMapper courseMapper;

    @GetMapping("/getCourseInfo")
    public R getCourseInfo(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        Page<Course> coursePage = new Page<>(page, limit);

        Page<Course> courseModel = courseMapper.selectPage(coursePage, queryWrapper);

        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("total", courseModel.getTotal());
        resMap.put("records", courseModel.getRecords());

        return R.success(resMap);
    }

}
