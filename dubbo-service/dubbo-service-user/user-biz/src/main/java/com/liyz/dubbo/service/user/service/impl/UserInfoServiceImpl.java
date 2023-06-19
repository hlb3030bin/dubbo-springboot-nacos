package com.liyz.dubbo.service.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liyz.dubbo.service.user.dao.UserInfoMapper;
import com.liyz.dubbo.service.user.model.UserInfoDO;
import com.liyz.dubbo.service.user.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * Desc:
 *
 * @author lyz
 * @version 1.0.0
 * @date 2023/6/19 9:44
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfoDO> implements UserInfoService {
}
