package com.liyz.dubbo.service.auth.remote;

import com.liyz.dubbo.service.auth.bo.AuthUserBO;

/**
 * Desc:JWT parse service
 *
 * @author lyz
 * @version 1.0.0
 * @date 2023/3/9 13:33
 */
public interface RemoteJwtParseService {

    /**
     * 解析token
     *
     * @param token jwt token
     * @param clientId 应用名称
     * @return 用户信息
     */
    AuthUserBO parseToken(final String token, final String clientId);

    /**
     * 生成token
     *
     * @param authUser 用户信息
     * @return jwt token
     */
    String generateToken(final AuthUserBO authUser);

    /**
     * 获取失效时间
     *
     * @param token jwt token
     * @return 失效时间
     */
    Long getExpiration(final String token);
}
