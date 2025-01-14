package com.liyz.dubbo.common.remote.exception;

/**
 * Desc:1开头的错误码
 *
 * @author lyz
 * @version 1.0.0
 * @date 2023/3/8 15:47
 */
public enum CommonExceptionCodeEnum implements IExceptionService{

    SUCCESS("0", "成功"),
    FAIL("1", "失败"),
    PARAMS_VALIDATED("10000", "参数校验失败"),
    REMOTE_SERVICE_FAIL("10005", "服务异常"),
    ;

    private final String code;

    private final String message;

    CommonExceptionCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
