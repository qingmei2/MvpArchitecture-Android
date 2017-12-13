package com.qingmei2.module_business.router.service;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * 这个实现类是用来处理{@link com.alibaba.android.arouter.launcher.ARouter}数据的序列化和反序列化
 *
 * 如果没有这个类，会报{@link NullPointerException}
 *
 */
@Route(path = "/service/json")
public class JsonServiceImpl implements SerializationService {

    private Gson gson;

    @Override
    public void init(Context context) {
        gson = new Gson();
    }

    @Override
    public <T> T json2Object(String text, Class<T> clazz) {
        return gson.fromJson(text, clazz);
    }

    @Override
    public String object2Json(Object instance) {
        return gson.toJson(instance);
    }

    @Override
    public <T> T parseObject(String input, Type clazz) {
        return gson.fromJson(input, clazz);
    }
}
