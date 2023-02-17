package top.lzzzs.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import top.lzzzs.common.R;
import top.lzzzs.entity.Gymnasium;
import top.lzzzs.entity.GymnasiumSubscribe;
import top.lzzzs.mapper.GymnasiumMapper;
import top.lzzzs.mapper.GymnasiumSubscribeMapper;
import top.lzzzs.service.IGymnasiumService;

import java.util.*;

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

    @Autowired
    GymnasiumSubscribeMapper gymnasiumSubscribeMapper;

    @GetMapping("/getGymnasiumInfo")
    public R getGymnasiumInfo(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        QueryWrapper<GymnasiumSubscribe> gymnasiumSubscribeQueryWrapper = new QueryWrapper<>();
        gymnasiumSubscribeQueryWrapper.lt("subscribe_time", new Date().getTime()).ne("is_done", 1);
        List<GymnasiumSubscribe> list = gymnasiumSubscribeMapper.selectList(gymnasiumSubscribeQueryWrapper);

        HashSet<Integer> gymnasiumIdList = new HashSet<>();

        // 更新is_done
        for (GymnasiumSubscribe gymnasiumSubscribe : list) {
            gymnasiumIdList.add(gymnasiumSubscribe.getGymnasiumId());
            UpdateWrapper<GymnasiumSubscribe> gymnasiumSubscribeUpdateWrapper = new UpdateWrapper<>();
            gymnasiumSubscribeUpdateWrapper.eq("id", gymnasiumSubscribe.getId()).set("is_done", 1);
            gymnasiumSubscribeMapper.update(null, gymnasiumSubscribeUpdateWrapper);
        }

        // gymnasium curnum - 1
        for (Integer id : gymnasiumIdList) {
            UpdateWrapper<Gymnasium> gymnasiumUpdateWrapper = new UpdateWrapper<>();
            Gymnasium gym = gymnasiumService.getById(id);
            gymnasiumUpdateWrapper.set("curnum", gym.getCurnum() - 1).eq("id", id);
            gymnasiumService.update(null, gymnasiumUpdateWrapper);
        }


        QueryWrapper<Gymnasium> queryWrapper = new QueryWrapper<>();
        Page<Gymnasium> gymnasiumPage = new Page<>(page, limit);

        Page<Gymnasium> gymnasiumModel = gymnasiumMapper.selectPage(gymnasiumPage, queryWrapper);

        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("total", gymnasiumModel.getTotal());
        resMap.put("records", gymnasiumModel.getRecords());

        return R.success(resMap);
    }
}
