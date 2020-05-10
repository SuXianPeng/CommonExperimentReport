#实验四Intent<br>
======================
* 本次实验主要是对于Intent隐式调用的使用并利用自定义应用进行相应的uri的访问，本次实验共创建了两个工程，本次实验过程及注意点如下：<br>

* 1.新建IntentCall工程用于获取url并进行隐式intent的调用，进行EditText与Button的定义：<br>
```
<EditText
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/EdictText_uri"
    tools:ignore="MissingConstraints"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintHorizontal_bias="0.5"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent"
    app:layout_constraintVertical_bias="0"
    android:id="@+id/EdictText_uri"
    />
<Button
    android:id="@+id/Button_call"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/button_call"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintHorizontal_bias="0.5"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent"
    app:layout_constraintVertical_bias="0.09" />
```
* 2.对本工程用到的string资源定义：<br>
```
<resources>
    <string name="app_name">IntentCall</string>
    <string name="EdictText_uri">https://www.baidu.com/</string>
    <string name="button_call">浏览该网页</string>
</resources>
```



* 3.对点击按钮的响应事件进行处理，下为具体代码：<br>
```
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    /*获取uri并使用隐式Intent来加载*/
        String address=exditText.getText().toString();
        Uri uri=Uri.parse(address);
        Intent intent=new Intent();

        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(uri);
        startActivity(intent);

    }
```
* 4.得到最终页面的效果图为：<br>
![图1](https://github.com/SuXianPeng/CommonExperimentReport/blob/master/images/Intent-%E5%9B%BE%E7%89%871.png)<br>
* 5.创建MyBrowser自定义浏览器工程，使用WebView对IntentCall工程的url进行访问，在xml文件中创建WebView：<br>
```
<WebView
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:id="@+id/webview"/>
```
* 6.获取intent传递的url，与WebView的实例化对象，并使用该对象，加载传递的url：<br>
```
Intent intent=getIntent();
webView=findViewById(R.id.webview);

Uri uri=intent.getData();
webView.loadUrl(uri.toString());//将该WebView的url加载为从intent中获得的uri

webView.setWebViewClient(new WebViewClient(){
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        //返回值是true的时候控制WebView打开，为false调用系统浏览器或第三方浏览器
        view.loadUrl(url);//将webView中的url加载出来
        return true;
    }
});
```

* 7.设置WebView的使其可加载出页面:<br>
```
webView.getSettings().setJavaScriptEnabled(true);//设置其支持Javascript
```
* 8.对该工程的intent-filter进行设置：<br>
```
<activity android:name=".MyBrowser">
    <intent-filter>
        <action android:name="android.intent.action.VIEW" />
        <category android:name="android.intent.category.DEFAULT"/><!--设置为默认-->
        <category android:name="android.intent.category.BROWSABLE"/><!--其描述策略还需加上此句否则无法识别-->
        <data android:scheme="https"></data>

    </intent-filter>
</activity>
```
* 9.如下图设置运行MyBrowser工程：<br>
![图2](https://github.com/SuXianPeng/CommonExperimentReport/blob/master/images/Intent-%E5%9B%BE%E7%89%872.png)<br>

* 10.再次运行IntentCall工程点击访问按钮，选择自定义的MyBrowser进行访问，其运行成功，结果图如下：<br>
![图3](https://github.com/SuXianPeng/CommonExperimentReport/blob/master/images/Intent-%E5%9B%BE%E7%89%873.png)<br>
![图4](https://github.com/SuXianPeng/CommonExperimentReport/blob/master/images/Intent-%E5%9B%BE%E7%89%874.png)<br>
* 至此本次实验完成，以上即为对本次实验完成的结果以及过程等进行描述，通过本次对intent的隐式调用更加熟练了，如果想查看源代码请见源文件。
