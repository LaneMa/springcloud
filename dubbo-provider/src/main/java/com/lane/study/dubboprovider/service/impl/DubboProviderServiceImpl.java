package com.lane.study.dubboprovider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lane.study.dubboapi.service.DubboProviderService;

@Service()
public class DubboProviderServiceImpl implements DubboProviderService {

    @Override
    public String provide(String var) {
        return String.format("hello %s",var);
    }
}
