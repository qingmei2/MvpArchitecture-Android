# MvpArchitecture 2.x 

MVP模式的模块化开发框架。

> 因为MVP满足不了我的开发体验，因此该项目已停止维护。  
> 相比前者，我更喜欢MVVM架构中这次实践，它更趋近我理想中的设计，更加Reactive和Functional：

[MVVM-Rhine:The MVVM Architecture in Android.](https://github.com/qingmei2/MVVM-Rhine)

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

#### 其他三方库：

[1.AutoDispose:Automatic binding+disposal of RxJava 2 streams.](https://github.com/uber/AutoDispose)  

> 关于AutoDispose在本项目中的应用，我偏向为项目中使用方式的展示，如果希望看到进阶优雅的使用方式，请参考本文档最下方的MVVM项目。

[2.RxBinding:RxJava binding APIs for Android's UI widgets.](https://github.com/JakeWharton/RxBinding)  
[3.ARouter:An android router middleware that help app navigating to activities and custom services.](https://github.com/alibaba/ARouter)  

#### 测试层：

AndroidTest: Espresso

UnitTest: Mockito + Robolectric

## Modules

> 1.app： 最顶层的应用，通过组合不同的业务模块生成对应的App

> 2.module_x: 业务模块，比如搜索模块、用户信息模块、视频播放模块等

> 3.module_core:底部架构级模块，业务开发中很少修改的模块，包括各个三方库的依赖，各种BaseXXX类、Util类，以及底层级别的依赖注入配置等

> 4.module_business：不同业务模块间消息传递的模块，采用ARouter，比如搜索模块和用户信息模块界面之间数据的传递

