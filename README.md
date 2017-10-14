# MvpArchitecture

MVP模式的开发框架。

开发环境：AndroidStudio 3.0 Beta7 

### 网络层：

HTTP : Rxjava2 + Retrofit2 + Okhttp

ImageLoader:Glide v4

Cache: RxCache

### 数据处理层：

JavaBean: lombok

Java8：Stream + Lambda

Dependencies Injection: DaggerAndroid

### UI层：

Views Binding: ButterKnife

Layout:ConstraintLayout

### 测试层：

AndroidTest: Espresso

UnitTest: Mockito + Robolectric

## 常见问题

**【Q】我的编译不通过怎么回事？**

【A】请首先查看您的编译环境，gradle plugin版本是否为3.0以上；

其次您需要为您的AndroidStudio 安装lombok插件，具体请参阅：

[Android中消除Java冗长代码神器——Lombok](http://www.jianshu.com/p/268fb94e858d)

如果还未能编译成功，请提issue，我将第一时间为您解答。
