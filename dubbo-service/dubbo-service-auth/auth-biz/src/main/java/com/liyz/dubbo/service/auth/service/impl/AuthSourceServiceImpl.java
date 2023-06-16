package com.liyz.dubbo.service.auth.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liyz.dubbo.service.auth.dao.AuthSourceMapper;
import com.liyz.dubbo.service.auth.model.AuthSourceDO;
import com.liyz.dubbo.service.auth.service.AuthSourceService;
import org.springframework.stereotype.Service;

/**
 * Desc:
 *
 * @author lyz
 * @version 1.0.0
 * @date 2023/6/14 18:00
 */
@Service
public class AuthSourceServiceImpl extends ServiceImpl<AuthSourceMapper, AuthSourceDO> implements AuthSourceService {

    /**
     * 根据资源ID获取资源配置信息
     *
     * @param clientId 资源ID
     * @return 资源配置信息
     */
    @Override
    public AuthSourceDO getByClientId(String clientId) {
        return getOne(Wrappers.lambdaQuery(AuthSourceDO.class)
                .select(AuthSourceDO::getClientId, AuthSourceDO::getClientTag)
                .eq(AuthSourceDO::getClientId, clientId));
    }
}