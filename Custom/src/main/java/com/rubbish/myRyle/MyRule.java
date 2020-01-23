package com.rubbish.myRyle;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MyRule  extends AbstractLoadBalancerRule {
    public MyRule() {
    }

    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    int total = 0;//被调用的次数
    int currentIndex = 0;//当前提供服务的机器号
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }
                //提供服务的机器
                List<Server> upList = lb.getReachableServers();
                //提供的服务的数量
                List<Server> allList = lb.getAllServers();

                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

                if(total < 5){
                    server = (Server)upList.get(currentIndex);
                    total++;
                }else {
                    total = 0;
                    currentIndex ++;
                    if(currentIndex >= upList.size()){
                        currentIndex = 0;
                    }
                }


                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
