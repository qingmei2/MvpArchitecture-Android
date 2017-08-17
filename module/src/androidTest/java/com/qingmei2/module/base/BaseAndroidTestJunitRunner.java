package com.qingmei2.module.base;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.test.runner.AndroidJUnitRunner;

/**
 * Created by QingMei on 2017/7/6.
 * desc:AndroidTest Junit相关配置
 * 记得在build.gradle文件中声明testInstrumentationRunner
 */

public class BaseAndroidTestJunitRunner extends AndroidJUnitRunner {

    @Override
    public void onCreate(Bundle arguments) {
        super.onCreate(arguments);
    }

    @Override
    public Application newApplication(ClassLoader cl, String className, Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        String testApplicationClassName = BaseAndroidTestApplication.class.getName();
        return super.newApplication(cl, testApplicationClassName, context);
    }
}
