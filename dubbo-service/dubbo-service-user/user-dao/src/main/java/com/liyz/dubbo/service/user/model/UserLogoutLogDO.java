package com.liyz.dubbo.service.user.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liyz.dubbo.common.dao.model.BaseDO;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * Desc:
 *
 * @author lyz
 * @version 1.0.0
 * @date 2023/3/10 10:03
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_logout_log")
public class UserLogoutLogDO extends BaseDO implements Serializable {
    private static final long serialVersionUID = 3070437801653890936L;

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;

    /**
     * 登录方式：1:手机;2:邮箱
     */
    private Integer logoutType;

    private Integer device;

    private Date logoutTime;

    private String ip;
}
