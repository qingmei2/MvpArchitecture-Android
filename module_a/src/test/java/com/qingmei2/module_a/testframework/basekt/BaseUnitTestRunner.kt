package com.qingmei2.module.testframework.basekt

import org.robolectric.RoboSettings
import org.robolectric.RobolectricTestRunner

/**
 * Created by QingMei on 2017/11/6.
 * desc:
 */
class BaseUnitTestRunner<T>(clazz: Class<T>) : RobolectricTestRunner(clazz) {

    init {

        // 从源码知道MavenDependencyResolver默认以RoboSettings的repositoryUrl和repositoryId为默认值，因此只需要对RoboSetting进行赋值即可
        RoboSettings.setMavenRepositoryId("alimaven");
        RoboSettings.setMavenRepositoryUrl("http://maven.aliyun.com/nexus/content/groups/public/");
    }
}