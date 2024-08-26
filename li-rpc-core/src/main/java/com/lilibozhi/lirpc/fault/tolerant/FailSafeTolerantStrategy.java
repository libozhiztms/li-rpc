package com.lilibozhi.lirpc.fault.tolerant;

import com.lilibozhi.lirpc.model.RpcResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * 静默处理异常 - 容错策略
 */
@Slf4j
public class FailSafeTolerantStrategy implements TolerantStrategy {
    @Override
    public RpcResponse doTolerant(Map<String, Object> context, Exception e) {
        //记录日志，正常返回一个响应对象，就像没有出现过报错
        log.info("静默处理异常", e);
        return new RpcResponse();
    }
}
