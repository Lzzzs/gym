package top.lzzzs.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import top.lzzzs.common.R;
import top.lzzzs.common.Rcode;
import top.lzzzs.common.annotation.JwtIgnore;
import top.lzzzs.common.dto.LoginDto;
import top.lzzzs.common.dto.RefreshTokenDto;
import top.lzzzs.common.dto.RegisterDto;
import top.lzzzs.entity.Users;
import top.lzzzs.service.IUsersService;
import top.lzzzs.service.impl.UsersServiceImpl;
import top.lzzzs.utils.DateUtil;
import top.lzzzs.utils.JwtUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lzzzs
 * @since 2023-01-18
 */
@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    IUsersService usersService;

    @PostMapping("/login")
    @JwtIgnore
    public R login(@RequestBody LoginDto loginInfo) {
        String username = loginInfo.getUsername();
        String password = DigestUtils.md5DigestAsHex(loginInfo.getPassword().getBytes());

        String role = loginInfo.getRole();
        QueryWrapper<Users> usersQueryWrapper = new QueryWrapper<>();
        usersQueryWrapper.eq("username", username);
        Users user = usersService.getOne(usersQueryWrapper);

        if (user != null && Objects.equals(user.getPassword(), password) && Integer.parseInt(role) == user.getRole()) {
            Map<String, Object> result = new HashMap<>();
            String token = JwtUtil.createToken(loginInfo, false);
            String refreshToken = JwtUtil.createToken(loginInfo, true);

            result.put("user", user);
            result.put("token", token);
            result.put("refreshToken", refreshToken);

            return R.success(result);
        }

        return R.error(Rcode.USER_NAME_OR_PASSWORD);
    }

    @PostMapping("/register")
    @JwtIgnore
    public R register(@RequestBody RegisterDto registerInfo) {
        QueryWrapper<Users> usersQueryWrapper = new QueryWrapper<>();
        usersQueryWrapper.eq("username", registerInfo.getUsername());
        Users user = usersService.getOne(usersQueryWrapper);
        if (user != null) {
            return R.error(Rcode.USER_EXIST);
        }


        Users users = new Users();
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        users.setId(id);
        users.setUsername(registerInfo.getUsername());
        users.setPassword(DigestUtils.md5DigestAsHex(registerInfo.getPassword().getBytes()));
        users.setCreatedTime(DateUtil.createdTime());
        // 默认只能注册用户，不能注册管理员
        users.setRole(2);

        return R.success(usersService.save(users));
    }


    /**
     * 刷新token
     *
     * @return R
     */
    @PostMapping("/refresh-token")
    public R refreshToken(@RequestBody RefreshTokenDto userInfo) {
        // 检查refreshToken是否过期，过期的话会到全局异常进行处理
        JwtUtil.isExpiration(userInfo.getRefreshToken());

        Map<Object, Object> res = new HashMap<>();

        // create token and refreshToken
        String token = JwtUtil.createToken(userInfo.getLoginInfo(), false);
        String refreshToken = JwtUtil.createToken(userInfo.getLoginInfo(), true);

        res.put("token", token);
        res.put("refreshToken", refreshToken);

        return R.success(res);
    }

}
