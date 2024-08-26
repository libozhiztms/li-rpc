package com.lilibozhi.lirpc.fault.retry;

import com.lilibozhi.lirpc.model.RpcResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * 不重试 - 重试策略
 */
@Slf4j
public class NoRetryStrategy implements RetryStrategy{
    @Override
    public RpcResponse doRetry(Callable<RpcResponse> callable) throws Exception {

        //call() 方法是 Callable 接口定义的用于执行任务并返回结果的方法
        return callable.call();

    }
}
