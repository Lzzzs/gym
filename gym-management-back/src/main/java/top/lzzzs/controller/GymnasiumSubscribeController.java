package top.lzzzs.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import top.lzzzs.common.R;
import top.lzzzs.common.Rcode;
import top.lzzzs.entity.Gymnasium;
import top.lzzzs.entity.GymnasiumSubscribe;
import top.lzzzs.service.IGymnasiumService;
import top.lzzzs.service.IGymnasiumSubscribeService;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lzzzs
 * @since 2023-02-16
 */
@RestController
public class GymnasiumSubscribeController {

    @Autowired
    IGymnasiumSubscribeService gymnasiumSubscribeService;

    @Autowired
    IGymnasiumService gymnasiumService;

    @PostMapping("/saveGymnasiumSubscribe")
    public R subscribe(@RequestBody GymnasiumSubscribe gymnasiumSubscribe) {
        return R.success(gymnasiumSubscribeService.save(gymnasiumSubscribe));
    }
}
