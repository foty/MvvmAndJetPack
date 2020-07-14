package com.example.mvvmandjetpack;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Create by lxx
 * Date : 2020/7/14 15:09
 * Use by
 */
public class Test {

    private Interceptor initCommonInterceptor() {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                request.newBuilder()
                        .addHeader("","")
                        .addHeader("","")
                        .build();
                return chain.proceed(request);
            }
        };
        return interceptor;
    }

}
