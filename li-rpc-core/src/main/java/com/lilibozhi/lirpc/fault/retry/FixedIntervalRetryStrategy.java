package com.lilibozhi.lirpc.fault.retry;

import com.github.rholder.retry.*;
import com.lilibozhi.lirpc.model.RpcResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 固定时间间隔 - 重试策略
 */
@Slf4j
public class FixedIntervalRetryStrategy implements RetryStrategy {
    @Override
    public RpcResponse doRetry(Callable<RpcResponse> callable) throws Exception {

        Retryer<RpcResponse> retryer = RetryerBuilder.<RpcResponse>newBuilder()
                .retryIfExceptionOfType(Exception.class) //发生异常重试
                .withWaitStrategy(WaitStrategies.fixedWait(3L, TimeUnit.SECONDS)) //等待
                .withStopStrategy(StopStrategies.stopAfterAttempt(3)) //允许执行3次（首次执行+最多重试2次）
                .withRetryListener(new RetryListener() {
                    //监听器
                    @Override
                    public <V> void onRetry(Attempt<V> attempt) {
                        log.info("发送请求次数：{}次，"+"重试次数：{}次", attempt.getAttemptNumber(),attempt.getAttemptNumber()-1);
                    }
                })
                .build();

        return retryer.call(callable);
    }
}
