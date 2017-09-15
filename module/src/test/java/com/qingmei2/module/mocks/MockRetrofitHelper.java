package com.qingmei2.module.mocks;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by QingMei on 2017/6/27.
 * desc:
 */

public class MockRetrofitHelper {
    public <T> T create(Class<T> clazz) {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new MockInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://api.***.com")
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(clazz);
    }

    private String path;

    private int statusCode = 200;

    public void setPath(String path) {
        this.path = path;
    }

    private class MockInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            // 模拟网络数据
            String content = MockAssestsReader.readFile(path);

            ResponseBody body = ResponseBody.create(MediaType.parse("application/x-www-form-urlencoded"), content);

            Response response = new Response.Builder().request(chain.request())
                    .protocol(Protocol.HTTP_1_1)
                    .code(statusCode)
                    .body(body)
                    .message("mock_message")
                    .build();
            return response;
        }
    }


}
