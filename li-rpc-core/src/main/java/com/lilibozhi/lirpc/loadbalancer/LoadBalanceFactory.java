package com.lilibozhi.lirpc.loadbalancer;

import com.lilibozhi.lirpc.spi.SpiLoader;

/**
 * 负载均衡器工厂（工厂模式、用于获取负载均衡器对象）
 */
public class LoadBalanceFactory {

    static {
        SpiLoader.load(LoadBalancer.class);
    }

    /**
     * 默认负载均衡器
     */
    private static final LoadBalancer DEFAULT_LOAD_BALANCER = new RandomLoadBalancer();

    /**
     * 获取实例
     *
     * @param key
     * @return
     */
    public static LoadBalancer getInstance(String key) {
        return SpiLoader.getInstance(LoadBalancer.class, key);
    }

}
