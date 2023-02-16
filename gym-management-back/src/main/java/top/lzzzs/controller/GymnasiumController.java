package top.lzzzs.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import top.lzzzs.common.R;
import top.lzzzs.entity.Gymnasium;
import top.lzzzs.mapper.GymnasiumMapper;
import top.lzzzs.service.IGymnasiumService;

import java.util.HashMap;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lzzzs
 * @since 2023-02-15
 */
@RestController
public class GymnasiumController {

    @Autowired
    IGymnasiumService gymnasiumService;

    @Autowired
    GymnasiumMapper gymnasiumMapper;

    @GetMapping("/getGymnasiumInfo")
    public R getGymnasiumInfo(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        QueryWrapper<Gymnasium> queryWrapper = new QueryWrapper<>();
        Page<Gymnasium> gymnasiumPage = new Page<>(page, limit);

        Page<Gymnasium> gymnasiumModel = gymnasiumMapper.selectPage(gymnasiumPage, queryWrapper);

        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("total", gymnasiumModel.getTotal());
        resMap.put("records", gymnasiumModel.getRecords());

        return R.success(resMap);
    }
}
