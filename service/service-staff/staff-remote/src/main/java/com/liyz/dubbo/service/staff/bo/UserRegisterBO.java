package com.liyz.dubbo.service.staff.bo;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 注释:注册信息
 *
 * @author liyangzhen
 * @version 1.0.0
 * @date 2022/4/27 14:54
 */
@Getter
@Setter
public class UserRegisterBO implements Serializable {
    private static final long serialVersionUID = -7013822916047200977L;

    @NotBlank(groups = {Register.class}, message = "登陆名不能为空")
    private String loginName;

    @NotBlank(groups = {Register.class}, message = "密码不能为空")
    private String loginPwd;

    @NotBlank(groups = {Register.class}, message = "验证码不能为空")
    private String verificationCode;

    @NotBlank(groups = {Register.class}, message = "昵称不能为空")
    private String nickName;

    @NotBlank(groups = {Register.class}, message = "姓名不能为空")
    private String userName;

    @NotNull(groups = {Register.class}, message = "注册设备不能为空")
    private Integer device;

    @NotBlank( message = "注册IP不能为空")
    private String ip;

    /**
     * 图片token
     *
     * 注：这里本不该这么设计，应该是在发短信时，需要一个图片验证码，验证通过才能发短信，然后再携带短信验证码来注册，
     * 这里就简单的测试，用图片验证码代替短信验证码
     */
    private String imageToken;

    public interface Register{}
}
