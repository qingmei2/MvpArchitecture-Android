package com.qingmei2.module.mvp.model;

import com.qingmei2.module.http.entity.UserInfo;
import com.qingmei2.module.http.service.ServiceManager;
import com.qingmei2.module.http.service.UserInfoService;
import com.qingmei2.module.mocks.MockAssets;
import com.qingmei2.module.mocks.MockRetrofitHelper;
import com.qingmei2.module.mocks.MockRxUnitTestTools;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import rx.Observable;

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

    private Observable.Transformer<UserInfo, UserInfo> transformer = userInfo -> userInfo;
    private MockRetrofitHelper retrofitHelper;

    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
        MockRxUnitTestTools.asyncToSync();
        retrofitHelper = new MockRetrofitHelper();
        UserInfoService userInfoService = retrofitHelper.create(UserInfoService.class);

        homeModel = spy(new HomeModel(serviceManager));

        doReturn(transformer).when(homeModel).getUserInfoCache(anyString(), anyBoolean());
        when(serviceManager.getUserInfoService()).thenReturn(userInfoService);
    }

    @Test
    public void requestUserInfo() throws Exception {
        retrofitHelper.setPath(MockAssets.USER_JSON);

        UserInfo userInfo = homeModel.requestUserInfo("qingmei2")
                .toBlocking()
                .single();

        assertEquals(userInfo.getName(), "青梅");
        assertEquals(userInfo.getLogin(), "qingmei2");
    }


}