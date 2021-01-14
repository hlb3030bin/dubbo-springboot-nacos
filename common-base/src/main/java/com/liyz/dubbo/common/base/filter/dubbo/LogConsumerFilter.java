package com.liyz.dubbo.common.base.filter.dubbo;

import com.liyz.dubbo.common.base.constant.CommonConstant;
import com.liyz.dubbo.common.base.log.LogIdContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

/**
 * 注释:日志调用过滤器
 *
 * @author liyangzhen
 * @version 1.0.0
 * @date 2020/9/28 16:20
 */
@Slf4j
@Activate(group = {CommonConstants.CONSUMER})
public class LogConsumerFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String logId = LogIdContext.getLogId();
        if (StringUtils.isNotBlank(logId)) {
            RpcContext.getContext().setAttachment(CommonConstant.DUBBO_LOG_ID, logId);
        }
        Result result = invoker.invoke(invocation);
        logId = result.getAttachment(CommonConstant.DUBBO_LOG_ID);
        if (StringUtils.isNotBlank(logId)) {
            LogIdContext.setLogId(logId);
        }
        return result;
    }
}