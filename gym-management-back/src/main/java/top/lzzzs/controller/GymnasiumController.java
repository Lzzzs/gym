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
        // 数据过期了 更新is_done 为1
        //  subscribe_time < curTime
        QueryWrapper<GymnasiumSubscribe> gymnasiumSubscribeQueryWrapper = new QueryWrapper<>();
        gymnasiumSubscribeQueryWrapper.lt("subscribe_time", new Date().getTime()).ne("is_done", 1);
        List<GymnasiumSubscribe> list = gymnasiumSubscribeMapper.selectList(gymnasiumSubscribeQueryWrapper);
        for (GymnasiumSubscribe gymnasiumSubscribe : list) {
            UpdateWrapper<GymnasiumSubscribe> gymnasiumSubscribeUpdateWrapper = new UpdateWrapper<>();
            if (gymnasiumSubscribe.getIng() == 1) {
                // ing为1说明，curnum加过1，那么这条数据过期了，curnum应该减一
                changeCurNum(gymnasiumSubscribe.getGymnasiumId(), 0);
                gymnasiumSubscribeUpdateWrapper.set("ing", 0);
            }
            gymnasiumSubscribeUpdateWrapper.eq("id", gymnasiumSubscribe.getId()).set("is_done", 1);
            gymnasiumSubscribeMapper.update(null, gymnasiumSubscribeUpdateWrapper);
        }

        // subscribe_time_start < curTime < subscribe_time
        QueryWrapper<GymnasiumSubscribe> gymnasiumSubscribeQueryWrapper1 = new QueryWrapper<>();
        gymnasiumSubscribeQueryWrapper1.lt("subscribe_time_start", new Date().getTime()).gt("subscribe_time", new Date().getTime()).ne("is_done", 1);
        List<GymnasiumSubscribe> midList = gymnasiumSubscribeMapper.selectList(gymnasiumSubscribeQueryWrapper1);
        ArrayList<Integer> gymids = new ArrayList();
        for (GymnasiumSubscribe gymnasiumSubscribe : midList) {
            Integer ing = gymnasiumSubscribe.getIng();
            if (ing == 0) {
                UpdateWrapper<GymnasiumSubscribe> gymnasiumSubscribeUpdateWrapper = new UpdateWrapper<>();
                gymnasiumSubscribeUpdateWrapper.eq("id", gymnasiumSubscribe.getId()).set("ing", 1);
                gymnasiumSubscribeMapper.update(null, gymnasiumSubscribeUpdateWrapper);
                gymids.add(gymnasiumSubscribe.getGymnasiumId());
            }
        }
        for (Integer id : gymids) {
            changeCurNum(id, 1);
        }

        // 获取健身房分页数据
        QueryWrapper<Gymnasium> queryWrapper = new QueryWrapper<>();
        Page<Gymnasium> gymnasiumPage = new Page<>(page, limit);
        Page<Gymnasium> gymnasiumModel = gymnasiumMapper.selectPage(gymnasiumPage, queryWrapper);
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("total", gymnasiumModel.getTotal());
        resMap.put("records", gymnasiumModel.getRecords());

        return R.success(resMap);
    }

    void changeCurNum(Integer id, Integer type) {
        UpdateWrapper<Gymnasium> gymnasiumUpdateWrapper = new UpdateWrapper<>();
        Gymnasium gym = gymnasiumService.getById(id);
        if (type == 1) {
            gymnasiumUpdateWrapper.set("curnum", gym.getCurnum() + 1).eq("id", id);
        } else {
            gymnasiumUpdateWrapper.set("curnum", gym.getCurnum() - 1).eq("id", id);
        }
        gymnasiumService.update(null, gymnasiumUpdateWrapper);
    }
}
