#Android 优化 图标文字

使用图标文字代替图片的实践

进入项目的`main`文件夹创建一个`assets`文件夹,并在`assets`下创建`fonts`文件夹, 把非系统字体放在`fonts`下
![Snip20170218_2.png](http://upload-images.jianshu.io/upload_images/1476913-a93eae91a0a21386.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


###使用:

1. 先在`.xml`文件,设置好文本

	```
	<TextView
	        android:layout_width="wrap_content"
	        android:layout_height="wrap_content"
	        android:textSize="50sp"
	        android:text="\ue900"
	        android:fontFamily="IconMoon-Free.ttf"/>
	```
![Snip20170218_5.png](http://upload-images.jianshu.io/upload_images/1476913-e817c51a5dc22afa.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


2. 在`.java`文件中设置字体

	```
	public class MainActivity extends AppCompatActivity {
	
	    private TextView screenTitle;
	
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	
			 // 设置TextView使用导入的文本
	        screenTitle = (TextView) findViewById(R.id.main_text);
	        Typeface iconMoonFont = Typeface.createFromAsset(getAssets(), "fonts/IcoMoon-Free.ttf");
	        screenTitle.setTypeface(iconMoonFont);
	
	    }
	}
	```
![Snip20170218_4.png](http://upload-images.jianshu.io/upload_images/1476913-dcca281673c09184.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

3. 效果:
![Snip20170218_7.png](http://upload-images.jianshu.io/upload_images/1476913-6bf844d58a500c90.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

4. 图标文本 & ImageView & TextView.drawableLeft 三者比较
![Snip20170218_10.png](http://upload-images.jianshu.io/upload_images/1476913-2e6b0a4da94f8040.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

###图标文本的使用
图标文本一般使用在导航栏或标签栏上, 以 天猫 为例

1. 图标文本使用在导航栏上
![Snip20170218_13.png](http://upload-images.jianshu.io/upload_images/1476913-220aa874123d1416.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
补充说明: 之所以方括号后面有说明文字是 `textview.contentDescription` 属性
![Snip20170218_23.png](http://upload-images.jianshu.io/upload_images/1476913-d17e47013a8ae3b2.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

2. 在标签栏上使用图标文本
![Snip20170218_18.png](http://upload-images.jianshu.io/upload_images/1476913-657b4b84d18fd555.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
注意:  上面的图标和下面的文字`天猫`都是文字

3. 图标文本区别于`TextView.drawableTop`等
![Snip20170218_17.png](http://upload-images.jianshu.io/upload_images/1476913-6f66325f5598637f.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

标签文本的使用需要满足一个条件:  该图标是纯色的
只有满足这个条件如果能使用图标文本就尽量使用, 而不要讲图标制作成.png图片.

### 为什么要使用图标文本代替图片
使用图标文本可以将多个图标放在一个字体文件中(我这里是.ttf格式的), 文件的尺寸是非常小的. 而如果将所有的图标制作成.png图片会比较大, 通过图标文本可以优化`Apk`(Android) / `ipa`(iOS) 的大小.  属于安装包的优化, 而这种思想也可以用在`iOS`的`App`制作中

### 如何制作字体
使用该软件:  Birdfont
如果想要一些现成的图标字体可以在该网址上找:  <a href='https://icomoon.io'>https://icomoon.io</a>

Demo 地址:  <a href='https://github.com/tackor/Android'>https://github.com/tackor/Android</a>
