package com.qingmei2.module.http;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.content.ContextCompat;

import com.annimon.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.ArrayList;

import static junit.framework.Assert.assertTrue;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class CacheProvidersTest {

    /**
     * test for device's cache file path.
     */
    @Test
    public void getCacheFilesTest() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        File[] externalCacheDirs = ContextCompat.getExternalCacheDirs(appContext);

        ArrayList<String> list = Stream.of(externalCacheDirs)
                .map(File::getPath)
                .collect(ArrayList<String>::new, ArrayList<String>::add);

        assertTrue(list.size() >= 1);
    }
}
