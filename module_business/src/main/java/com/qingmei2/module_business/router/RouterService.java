package com.qingmei2.module_business.router;

import com.baronzhang.android.router.annotation.router.FullUri;
import com.baronzhang.android.router.annotation.router.IntentExtrasParam;
import com.qingmei2.module_business.model.UserModel;

/**
 * @author baronzhang (baron[dot]zhanglei[at]gmail[dot]com ==>> baronzhang.com)
 *         2017/3/6
 */
public interface RouterService {

    @FullUri("router://com.qingmei2.module_a.homeactivity")
    void startHomeActivity(@IntentExtrasParam("userModel") UserModel userModel);

}
