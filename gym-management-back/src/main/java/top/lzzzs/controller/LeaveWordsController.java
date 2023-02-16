package top.lzzzs.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import top.lzzzs.common.R;
import top.lzzzs.entity.LeaveWords;
import top.lzzzs.service.ILeaveWordsService;
import top.lzzzs.service.impl.LeaveWordsServiceImpl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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

    @GetMapping("/getReplyInfo")
    public R getLeaveWord(@RequestParam("userId") String userId) {
        QueryWrapper<LeaveWords> leaveWordsQueryWrapper = new QueryWrapper<>();
        leaveWordsQueryWrapper.eq("user_id", userId);
        List<LeaveWords> list = leaveWordsService.list(leaveWordsQueryWrapper);

        HashMap<String, Object> res = new HashMap<>();
        HashSet<Object> l = new HashSet<>();

        for (LeaveWords leaveWordInfo : list) {
            HashMap<String, Object> tmp = new HashMap<>();
            tmp.put("content", leaveWordInfo.getContent());
            tmp.put("replyContent", leaveWordInfo.getReplyContent());
            tmp.put("replyTime", leaveWordInfo.getReplyTime());
            l.add(tmp);
        }
        res.put("list", l);

        return R.success(res);
    }
}
