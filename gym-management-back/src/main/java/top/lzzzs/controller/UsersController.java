package top.lzzzs.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import top.lzzzs.common.R;
import top.lzzzs.common.annotation.JwtIgnore;
import top.lzzzs.common.dto.LoginDto;
import top.lzzzs.entity.Users;
import top.lzzzs.service.IUsersService;
import top.lzzzs.service.impl.UsersServiceImpl;
import top.lzzzs.utils.DateUtil;

import java.util.UUID;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lzzzs
 * @since 2023-01-18
 */
@Controller
@RequestMapping("/user")
public class UsersController {

    @Autowired
    IUsersService usersService;

    @PostMapping("/login")
    @JwtIgnore
    public R login(@RequestBody LoginDto loginInfo) {
        String username = loginInfo.getUsername();
        String password = DigestUtils.md5DigestAsHex(loginInfo.getPassword().getBytes());

        int role = loginInfo.getRole();
        QueryWrapper<Users> usersQueryWrapper = new QueryWrapper<>();
        usersService.getOne(usersQueryWrapper);

        return null;
    }

    @PostMapping("/register")
    @JwtIgnore
    public R register(@RequestBody LoginDto registerInfo) {
        Users users = new Users();

        String id = UUID.randomUUID().toString().replaceAll("-", "");
        users.setId(id);
        users.setUsername(registerInfo.getUsername());
        users.setPassword(DigestUtils.md5DigestAsHex(registerInfo.getPassword().getBytes()));
        users.setCreatedTime(DateUtil.createdTime());
        users.setRole(registerInfo.getRole());

        return R.success(usersService.save(users));
    }

}
