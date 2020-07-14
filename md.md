架构(mvvm)  

##### liveData
LiveData通常会配合ViewModel来使用，ViewModel负责触发数据的更新，更新会通知到LiveData，
然后LiveData再通知活跃状态的观察者。    
LiveData是一个数据持有类，它可以通过添加观察者被其他组件观察其变更。不同于普通的观察者，它最重要的特性就是遵从
应用程序的生命周期，如在Activity中如果数据更新了但Activity已经是destroy状态，LivaeData就不会通知
Activity(observer)。当然。LiveData的优点还有很多，如不会造成内存泄漏等。

##### ViewModel 
类旨在以注重生命周期的方式存储和管理界面相关的数据。ViewModel 类让数据可在发生屏幕旋转等配置更改后继续留存，
为界面准备数据。  
通常在系统首次调用 Activity对象的onCreate()方法时请求ViewModel。    
系统可能会在 Activity 的整个生命周期内多次调用 onCreate()，如在旋转设备屏幕时。   
ViewModel 存在的时间范围是从您首次请求ViewModel直到Activity完成并销毁。   

注意： ViewModel 绝不能引用视图、Lifecycle 或可能存储对 Activity 上下文的引用的任何类。



依赖库:

anko-commons : JetBrains出品的一个工具包，常用的有toast，sp
loadsir