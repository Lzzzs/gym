package top.lzzzs.utils;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import top.lzzzs.common.dto.LoginDto;

import java.util.Date;

@Slf4j
public class JwtUtil {
    public static final String AUTH_HEADER_KEY = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    // 密钥
    private static String secret = "liangzhensheng";
    // 过期时间 单位ms 十分钟 600000
    private static long expiration = 600000;

    // refresh token过期时间 十天
    private static long reExpiration = 864000000;


    /**
     * 解析jwt
     *
     * @param token
     * @return
     */
    public static Claims parseJWT(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 生成jwt
     *
     * @param LoginDto
     * @return
     */
    public static String createToken(LoginDto userLoginInfo, Boolean refresh) {
        long expirationTime = refresh ? reExpiration : expiration;

        JwtBuilder jwtBuilder = Jwts.builder()
                .setSubject(userLoginInfo.getUsername())
                .setIssuedAt(new Date())// 登录时间
                .signWith(SignatureAlgorithm.HS256, secret).setExpiration(new Date(new
                        Date().getTime() + expirationTime));
        System.out.println(jwtBuilder.compact());
        return jwtBuilder.compact();
    }

    /**
     * 获取userid
     *
     * @return
     */
    public static String getUserId(String token) {
        return parseJWT(token).getSubject();
    }

    /**
     * 是否已过期
     *
     * @param token
     * @return
     */
    public static boolean isExpiration(String token) {
        return parseJWT(token).getExpiration().before(new Date());
    }
}