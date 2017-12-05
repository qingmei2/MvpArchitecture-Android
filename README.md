# MvpArchitecture 2.x

MVP模式的模块化开发框架。

开发环境：AndroidStudio 3.0

#### 网络层：

HTTP : Rxjava2 + Retrofit2 + Okhttp3

ImageLoader:Glide v4

Cache: RxCache

#### 数据处理层：

JavaBean: lombok

Java8：Stream + Lambda

Dependencies Injection: DaggerAndroid

#### UI层：

Views Binding: DataBinding

> 关于ButterKnife：2.x模块化开发尝试使用DataBinding代替ButterKnife，功能仅使用最简单的View绑定，类似Kotlin插件的效果，只需要通过b.viewId即可进行对View的操作

Layout:ConstraintLayout

#### 测试层：

AndroidTest: Espresso

UnitTest: Mockito + Robolectric

## Modules

> 1.app： 最顶层的应用，通过组合不同的业务模块生成对应的App

> 2.module_x: 业务模块，比如搜索模块、用户信息模块、视频播放模块等

> 3.module_core:底部架构级模块，业务开发中很少修改的模块，包括各个三方库的依赖，各种BaseXXX类、Util类，以及底层级别的依赖注入配置等

> 4.module_business：不同业务模块间消息传递的模块，采用Router，比如搜索模块和用户信息模块界面之间数据的传递
