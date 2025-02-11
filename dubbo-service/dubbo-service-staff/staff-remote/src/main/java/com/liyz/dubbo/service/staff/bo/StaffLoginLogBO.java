package com.liyz.dubbo.service.staff.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Desc:
 *
 * @author lyz
 * @version 1.0.0
 * @date 2023/3/10 10:15
 */
@Getter
@Setter
public class StaffLoginLogBO implements Serializable {
    private static final long serialVersionUID = -8978119199629210583L;

    private Long staffId;

    /**
     * 登录方式：1:手机;2:邮箱
     */
    private Integer loginType;

    private Integer device;

    private Date loginTime;

    private String ip;
}
