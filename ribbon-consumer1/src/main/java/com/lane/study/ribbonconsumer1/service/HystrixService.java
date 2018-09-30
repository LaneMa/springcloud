package com.lane.study.ribbonconsumer1.service;

import java.util.concurrent.Future;

public interface HystrixService {

    String test();

    String test(String var);

    Future<String> asyncTest(String var);

}
