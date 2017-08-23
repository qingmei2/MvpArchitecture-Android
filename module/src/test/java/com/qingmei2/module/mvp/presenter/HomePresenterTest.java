package com.qingmei2.module.mvp.presenter;

import com.google.gson.Gson;
import com.qingmei2.module.http.entity.UserInfo;
import com.qingmei2.module.mocks.MockAssestsReader;
import com.qingmei2.module.mocks.MockAssets;
import com.qingmei2.module.mvp.contract.HomeContract;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import rx.Observable;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
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
    }

    @Test
    public void requestUserInfo_success() throws Exception {
        final String s = MockAssestsReader.readFile(MockAssets.USER_JSON);
        final UserInfo userInfo = new Gson().fromJson(s, UserInfo.class);

        when(model.requestUserInfo(anyString())).thenReturn(Observable.just(userInfo));

        presenter.requestUserInfo("qingmei2");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(view).onGetUserInfo(captor.capture());
        verify(view, never()).onError(anyString());

        String loginName = captor.getValue();
        assertEquals(userInfo.getLogin(), loginName);
    }

    @Test
    public void requestUserInfo_failed_nameEmpty() throws Exception {
        final String s = MockAssestsReader.readFile(MockAssets.USER_JSON_ERROR);
        final UserInfo userInfo = new Gson().fromJson(s, UserInfo.class);

        when(model.requestUserInfo(anyString())).thenReturn(Observable.just(userInfo));

        presenter.requestUserInfo("qingmei2");

        verify(view, never()).onGetUserInfo(anyString());
        verify(view).onError("用户信息为空");
    }
}