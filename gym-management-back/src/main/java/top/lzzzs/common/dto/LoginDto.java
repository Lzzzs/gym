package top.lzzzs.common.dto;

import lombok.Data;

@Data
public class LoginDto {
    private String username;

    private String password;

    private int role;

}
