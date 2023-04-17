package top.lzzzs.common.dto;

import lombok.Data;

@Data
public class RegisterDto {
    public RegisterDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private String username;

    private String password;

    private String name;

    private String phone;

    private Integer age;

    private String address;
}
