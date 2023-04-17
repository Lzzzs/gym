package top.lzzzs.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import top.lzzzs.common.R;
import top.lzzzs.entity.LeaveWords;
import top.lzzzs.service.ILeaveWordsService;
import top.lzzzs.service.impl.LeaveWordsServiceImpl;
import top.lzzzs.utils.DateUtil;

import java.util.*;

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

    @GetMapping("/getReplyInfoByUserId")
    public R getLeaveWord(@RequestParam("userId") String userId) {
        QueryWrapper<LeaveWords> leaveWordsQueryWrapper = new QueryWrapper<>();
        leaveWordsQueryWrapper.eq("user_id", userId).orderByDesc("reply_time").isNotNull("reply_content");
        List<LeaveWords> list = leaveWordsService.list(leaveWordsQueryWrapper);

        HashMap<String, Object> res = new HashMap<>();
        ArrayList<Object> l = new ArrayList<>();

        for (LeaveWords leaveWordInfo : list) {
            HashMap<String, Object> tmp = new HashMap<>();
            tmp.put("content", leaveWordInfo.getContent());
            tmp.put("replyContent", leaveWordInfo.getReplyContent());
            tmp.put("replyTime", leaveWordInfo.getReplyTime());
            tmp.put("isRead", leaveWordInfo.getIsRead());
            l.add(tmp);
        }
        res.put("list", l);

        return R.success(res);
    }

    @GetMapping("/getAllLeaveWord")
    public R getAllLeaveWord() {
        QueryWrapper<LeaveWords> leaveWordsQueryWrapper = new QueryWrapper<>();
        leaveWordsQueryWrapper.isNull("reply_content");
        List<LeaveWords> list = leaveWordsService.list(leaveWordsQueryWrapper);

        HashMap<String, Object> res = new HashMap<>();
        HashSet<Object> l = new HashSet<>();

        for (LeaveWords leaveWordInfo : list) {
            HashMap<String, Object> tmp = new HashMap<>();
            tmp.put("id", leaveWordInfo.getId());
            tmp.put("name", leaveWordInfo.getName());
            tmp.put("phone", leaveWordInfo.getPhone());
            tmp.put("content", leaveWordInfo.getContent());
            l.add(tmp);
        }
        res.put("list", l);

        return R.success(res);
    }

    @PostMapping("/replyLeaveWord")
    public R replyLeaveWord(@RequestBody LeaveWords leaveWordInfo) {
        UpdateWrapper<LeaveWords> leaveWordsUpdateWrapper = new UpdateWrapper<>();
        leaveWordsUpdateWrapper.eq("id", leaveWordInfo.getId()).set("reply_content", leaveWordInfo.getReplyContent()).set("reply_time", DateUtil.createdTime());
        return R.success(leaveWordsService.update(leaveWordsUpdateWrapper));
    }

    @PostMapping("/changeReadStatus")
    public R changeReadStatus(@RequestBody Map<String, String> map) {
        UpdateWrapper<LeaveWords> leaveWordsUpdateWrapper = new UpdateWrapper<>();
        leaveWordsUpdateWrapper.eq("user_id", map.get("userId")).isNotNull("reply_time").set("is_read", 1);
        return R.success(leaveWordsService.update(leaveWordsUpdateWrapper));
    }
}
