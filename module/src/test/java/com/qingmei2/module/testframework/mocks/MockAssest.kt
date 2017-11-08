package com.qingmei2.module.testframework.mocks

import java.io.File

/**
 * Created by QingMei on 2017/11/6.
 * desc:
 */
object MockAssest {

    private val BASE_PATH = "module/src/test/java/com/qingmei2/module/testframework/mocks/data"
    val USER_DATA = BASE_PATH + "/userJson_test"
    val error = BASE_PATH + "/error"

    fun readFile(path: String): String {
        val content = file2String(File(path))
        return content
    }

    fun file2String(f: File, charset: String = "UTF-8"): String {
        return f.readText(Charsets.UTF_8)
    }

}