package com.liyz.dubbo.service.staff.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liyz.dubbo.common.dao.model.BaseDO;
import lombok.*;

import java.io.Serializable;

/**
 * Desc:
 *
 * @author lyz
 * @version 1.0.0
 * @date 2023/3/11 11:38
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("system_role")
public class SystemRoleDO extends BaseDO implements Serializable {
    private static final long serialVersionUID = -1600563077499546530L;

    @TableId(type = IdType.INPUT)
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 父角色ID
     */
    private Integer parentRoleId;

}
