架构(mvvm)  

##### liveData
LiveData通常会配合ViewModel来使用，ViewModel负责触发数据的更新，更新会通知到LiveData，
然后LiveData再通知活跃状态的观察者。    
LiveData是一个数据持有类，它可以通过添加观察者被其他组件观察其变更。不同于普通的观察者，它最重要的特性就是遵从
应用程序的生命周期，如在Activity中如果数据更新了但Activity已经是destroy状态，LivaeData就不会通知
Activity(observer)。当然。LiveData的优点还有很多，如不会造成内存泄漏等。

使用：  
setValue(T)(主线程使用)和postValue(T)（子线程使用）两个方法来修改数据。LiveData并没有提供类似方法。    
当调用MutableLiveData的setValue(T)或postValue(T)方法后，Observer的onChanged()方法将会被回调，从而实现更
新UI的操作。

##### ViewModel 
类旨在以注重生命周期的方式存储和管理界面相关的数据。ViewModel 类让数据可在发生屏幕旋转等配置更改后继续留存，
为界面准备数据。  
通常在系统首次调用 Activity对象的onCreate()方法时请求ViewModel。    
系统可能会在 Activity 的整个生命周期内多次调用 onCreate()，如在旋转设备屏幕时。   
ViewModel 存在的时间范围是从您首次请求ViewModel直到Activity完成并销毁。   

注意： ViewModel 绝不能引用视图、Lifecycle 或可能存储对 Activity 上下文的引用的任何类。



实现流程:  
mvvmbase基类(viewModel,repository,livedata)  
retrofit + ok  


问题： 
livedata原理(怎么跟activity/fragment生命周期关联上的)?   
base用反射获取的repository原理?  
java下的retrofit与kotlin的retrofit区别?  
扩展函数、内联函数使用时机?  
