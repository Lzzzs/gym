package top.lzzzs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import top.lzzzs.common.R;
import top.lzzzs.service.IUsersService;
import top.lzzzs.service.impl.UsersServiceImpl;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lzzzs
 * @since 2023-01-18
 */
@Controller
@RequestMapping("/lzzzs/users")
public class UsersController {

    @Autowired
    IUsersService usersService;

}
