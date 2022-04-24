package com.liyz.dubbo.common.controller.error;

import com.liyz.dubbo.common.core.result.Result;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 注释:错误重定向controller
 *
 * @author liyangzhen
 * @version 1.0.0
 * @date 2022/4/22 14:10
 */
@Api(value = "错误重定向", tags = "错误重定向")
@ApiResponses(value = {
        @ApiResponse(code = 0, message = "成功"),
        @ApiResponse(code = 1, message = "非0都为失败")
})
@Slf4j
@RestController
@RequestMapping("/liyz")
public class ErrorApiController extends BasicErrorController {

    public ErrorApiController(ErrorAttributes errorAttributes, ErrorProperties errorProperties) {
        super(errorAttributes, errorProperties);
    }

    @ApiOperation(value = "错误重定向", notes = "错误重定向")
    @RequestMapping("/error")
    public Result myError(HttpServletRequest request) {
        HttpStatus status = this.getStatus(request);
        return Result.error(String.valueOf(status.value()), status.getReasonPhrase());
    }
}