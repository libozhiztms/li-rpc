package com.lilibozhi.lirpc.loadbalancer;

/**
 * 负载均衡器键名常量
 */
public interface LoadBalancerKeys {
    /**
     * 轮询
     */
    String ROUND_ROBIN = "roundRobin";

    /**
     * 随机
     */
    String RANDOM = "random";

    /**
     * 一致性哈希负载均衡器
     */
    String CONSISTENT_HASH = "consistentHash";
}
