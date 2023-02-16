package top.lzzzs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import top.lzzzs.common.R;
import top.lzzzs.entity.LeaveWords;
import top.lzzzs.service.ILeaveWordsService;
import top.lzzzs.service.impl.LeaveWordsServiceImpl;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lzzzs
 * @since 2023-02-14
 */
@RestController
public class LeaveWordsController {

    @Autowired
    ILeaveWordsService leaveWordsService;

    @PostMapping("/addLeaveWord")
    public R addLeaveWord(@RequestBody LeaveWords leaveWordInfo) {
        return R.success(leaveWordsService.save(leaveWordInfo));
    }
}
