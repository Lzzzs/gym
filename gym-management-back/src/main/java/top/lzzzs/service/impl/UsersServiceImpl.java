package top.lzzzs.service.impl;

import top.lzzzs.common.R;
import top.lzzzs.common.dto.LoginDto;
import top.lzzzs.entity.Users;
import top.lzzzs.mapper.UsersMapper;
import top.lzzzs.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lzzzs
 * @since 2023-01-18
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {
}
