package com.qingmei2.module.mvp.model;

import com.qingmei2.module.http.entity.UserInfo;
import com.qingmei2.module.http.service.ServiceManager;
import com.qingmei2.module.http.service.UserInfoService;
import com.qingmei2.module.mocks.TestAssets;
import com.qingmei2.module.mocks.TestRetrofit;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.MaybeTransformer;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * Created by QingMei on 2017/8/22.
 * desc:
 */
public class HomeModelTest {

    @Mock
    ServiceManager serviceManager;

    private HomeModel homeModel;

    private MaybeTransformer<UserInfo, UserInfo> transformer = userInfo -> userInfo;
    private TestRetrofit retrofitHelper;

    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this); //初始化mock
//        MockRxUnitTestTools.asyncToSync();  //把异步变成同步，方便测试

        retrofitHelper = new TestRetrofit();
        UserInfoService userInfoService = retrofitHelper.create(UserInfoService.class);//mock userInfoService

        homeModel = spy(new HomeModel(serviceManager));//监控真实对象

        doReturn(transformer).when(homeModel).getUserInfoCache(anyString(), anyBoolean());//处理缓存
        when(serviceManager.getUserInfoService()).thenReturn(userInfoService);
    }

    @Test
    public void requestUserInfo() throws Exception {
        retrofitHelper.setPath(TestAssets.USER_JSON);//mock server数据

        UserInfo userInfo = homeModel.requestUserInfo("qingmei2")
                .blockingGet();

        assertEquals(userInfo.getName(), "青梅");
        assertEquals(userInfo.getLogin(), "qingmei2");
    }
}