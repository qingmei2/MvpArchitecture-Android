package com.qingmei2.module.utils;

import android.Manifest;
import android.os.Build;

import com.qingmei2.module.BuildConfig;
import com.qingmei2.module.base.BaseUnitTestApplication;
import com.qingmei2.module.base.BaseUnitTestTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;
import org.robolectric.manifest.AndroidManifest;
import org.robolectric.res.Fs;

import java.util.HashSet;

import static org.assertj.core.api.Java6Assertions.assertThat;


/**
 * Created by QingMei on 2017/8/7.
 * desc:
 */

@RunWith(BaseUnitTestTestRunner.class)
@Config(constants = BuildConfig.class,manifest = Config.NONE, sdk = Build.VERSION_CODES.JELLY_BEAN, application = BaseUnitTestApplication.class)
public final class PermissionsTest {

    private static final String[] EXPECTED_PERMISSIONS = {
            Manifest.permission.INTERNET
    };

    private static final String MERGED_MANIFEST =
            "build/intermediates/manifests/full/debug/AndroidManifest.xml";

    @Test
    public void shouldMatchPermissions() {
        AndroidManifest manifest = new AndroidManifest(
                Fs.fileFromPath(MERGED_MANIFEST),
                null,
                null
        );

        assertThat(new HashSet<>(manifest.getUsedPermissions())).
                containsOnly(EXPECTED_PERMISSIONS);
    }
}
