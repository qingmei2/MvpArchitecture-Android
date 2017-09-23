package com.qingmei2.module.mvp.presenter;

import com.google.gson.Gson;
import com.qingmei2.module.http.entity.UserInfo;
import com.qingmei2.module.mocks.TestAssestsReader;
import com.qingmei2.module.mocks.TestAssets;
import com.qingmei2.module.mocks.TestRxTransformer;
import com.qingmei2.module.mvp.contract.HomeContract;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Maybe;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by QingMei on 2017/8/22.
 * desc:
 */
public class HomePresenterTest {

    @Mock
    HomeContract.View view;
    @Mock
    HomeContract.Model model;

    private HomePresenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        presenter = spy(new HomePresenter(view, model));
        doReturn(new TestRxTransformer<>()).when(presenter).bindViewMaybe(view);
    }

    @Test
    public void requestUserInfo_success() throws Exception {
        final String s = TestAssestsReader.readFile(TestAssets.USER_JSON);
        final UserInfo userInfo = new Gson().fromJson(s, UserInfo.class);

        when(model.requestUserInfo(anyString())).thenReturn(Maybe.just(userInfo));

        presenter.requestUserInfo("qingmei2");

        ArgumentCaptor<UserInfo> captor = ArgumentCaptor.forClass(UserInfo.class);
        verify(view).onGetUserInfo(captor.capture());
        verify(view, never()).onError(anyString());

        UserInfo captureUserInfo = captor.getValue();
        assertEquals(userInfo, captureUserInfo);
    }

    @Test
    public void requestUserInfo_failed_nameEmpty() throws Exception {
        final String s = TestAssestsReader.readFile(TestAssets.USER_JSON_ERROR);
        final UserInfo userInfo = new Gson().fromJson(s, UserInfo.class);

        when(model.requestUserInfo(anyString())).thenReturn(Maybe.just(userInfo));

        presenter.requestUserInfo("qingmei2");

        verify(view, never()).onGetUserInfo(any());
        verify(view).onError("用户信息为空");
    }
}