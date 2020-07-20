 android.support(design.widget)库在迁移android x之后统一变成了com.google.android.material  
 在android x使用材料设计，也就是com.google.android.material(android X之前叫android.support.design)
 后，如果出现找不到相关的控件名称(首字母搜索没有出现对应的控件)，可以关闭项目，重新打开项目，就可以了。  
 
 
 FloatingActionButton -- 悬浮按钮控件。   
 FloatingActionButton继承ImageButton(ImageView),所以FloatingActionButton(一下简称fab)具有ImageView的所
 有属性(比如基本view属性，如宽、高、margin、padding等)，它的额外属性: 
 * app:backgroundTint -- 正常背景颜色
 * app:rippleColor -- 按下时背景颜色
 * app:elevation -- 正常阴影大小
 * app:pressedTranslationZ -- 按下时阴影大小
 * app:layout_anchor -- 设置锚点，以该控件为参考
 * app:fabSize -- fab大小，有三个选项(auto=自动大小，normal=正常大小，mini=缩小版)
 * app:fabCustomSize -- fab大小，此属性设置后，fabSize属性将失效。
 * app:layout_behavior -- 联动行为。在界面中存在列表与fab:列表上滑，fab消失，列表下滑，fab显示时这样的场景，可通过此属性实现。

1.要想让fab显示点击后的颜色和阴影变化效果，必须设置onClick事件.   
2.app:layout_anchor 其父布局需要是 CoordinatorLayout，否则没有效果。参考的的锚点，不能是父布局，否则会报错。
   
 
部分第三方轮子从github上下载需要先添加git发布支持(maven { url "https://jitpack.io" })   


BottomNavigationView -- 材料控件 - 底部导航栏。
* labelVisibilityMode -- 展现模式。有unlabeled(所有都只展现图片，不会展现文字，没有动画效果)、labeled(立即展现所有图片与文字，选中位置文字偏大一点)、
selected(与auto相同)、auto(只有被选中的才展现图片与文字，未被选中的只展现图片，切换时有个动画效果)
* menu -- 设置关联的文字图片
* style -- 展现样式。例如: "@style/Widget.Design.BottomNavigationView"
* layout_behavior  -- 联动行为。可从系统选择，如"@string/hide_bottom_view_on_scroll_behavior"