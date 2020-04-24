#实验三Android Ui组件实验说明<br>
======================
* 本次实验完成实验三的简单适配器、自定义对话框、xml定义菜单以及上下文菜单实验。本次实验采取的是一个主界面通过intent在不同页面之间的跳转，与实验二
形成比较明显的区别，无需手动进行改代码运行工程，只需点击不同的按钮即可。接下来展示的是启动界面及各界面的布局以及部分代码，若想查看
更多请自行查看仓库下本工程的布局文件代码。<br>

* 下图为启动界面截图，其中有一个edittext是为了显示自定义对话框点击按钮时显示相应按钮上的文字作用，由于在本次编辑时github出现错误无法上传截图所以
将在后续补全。<br>
启动界面截图，在genymotion模拟下运行的结果图：<br>
![起始界面截图](https://github.com/SuXianPeng/CommonExperimentReport/blob/master/images/%E8%B5%B7%E5%A7%8B%E7%95%8C%E9%9D%A2%E6%88%AA%E5%9B%BE.JPG)<br>
此界面布局文件为线性布局，代码为：<br>
```
  
  EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/show"
        android:hint="@string/defaultinfo"
        />
    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/simple_adapter_btn"
        android:text="@string/simple_adapter"
        />

    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/alert_dialog_btn"
        android:text="@string/alertdialog"
        />

    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/xml_menu_btn"
        android:text="@string/xml_menu"
        />

    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/context_menu_btn"
        android:text="@string/context_menu_btn"
        />
```
该按钮事件的处理，其中自定义对话框无需跳转页面而是在MainActivity中直接完成：
```
Button btn_simpleadapter=findViewById(R.id.simple_adapter_btn);
        btn_simpleadapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this, SimpleAdapterClass.class);
                startActivity(intent);
            }
        });

        Button btn_alertdialog=findViewById(R.id.alert_dialog_btn);
        btn_alertdialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDailog();
            }
        });

        Button btn_xmlmenu=findViewById(R.id.xml_menu_btn);
        btn_xmlmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, XmlMenuClass.class);
                startActivity(intent);
            }
        });

        Button btn_contextmenu=findViewById(R.id.context_menu_btn);
        btn_contextmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, ContextMenuClass.class);
                startActivity(intent);
            }
        });
```



* 下图为完成简单适配器后，在genymotion模拟下运行的结果图：<br>
![简单适配器截图](https://github.com/SuXianPeng/CommonExperimentReport/blob/master/images/%E7%AE%80%E5%8D%95%E9%80%82%E9%85%8D%E5%99%A8%E6%88%AA%E5%9B%BE.JPG)<br>
简单适配器每个条目的代码为：<br>

```
 <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        android:layout_weight="1">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:id="@+id/textView"
            android:text="@string/demo"
            android:textColor="#000"
            android:layout_gravity="left"
            />
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        android:layout_weight="1">
        <ImageView
            android:layout_width="50dp"
            android:layout_height="50dp"
            android:padding="5dp"
            android:id="@+id/imageView"
            android:layout_marginRight="10dp"
            android:layout_gravity="right"
            />
    </LinearLayout>
```
简单适配器的装配、创建代码为：

```
//创建简单适配器,将数据装配到弄好的listview_items中，并将该适配器装配到listview中
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,R.layout.listview_items,from,to);
        ListView simpleListView;
        simpleListView=findViewById(R.id.mylist);
        simpleListView.setAdapter(simpleAdapter);//装配适配器到listview中
        
 //Toast显示
        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {

                Toast.makeText(getApplicationContext(),animalNames[i],Toast.LENGTH_SHORT).show();
            }
        });
```
* 下图为完成自定义对话框后，在genymotion模拟下运行的结果图：<br>
![自定义对话框截图](https://github.com/SuXianPeng/CommonExperimentReport/blob/master/images/%E8%87%AA%E5%AE%9A%E4%B9%89%E5%AF%B9%E8%AF%9D%E6%A1%86%E6%88%AA%E5%9B%BE.JPG)<br>
其布局文件代码为：<br>

```
 <EditText

            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="@string/username"
            android:selectAllOnFocus="true"
            android:drawablePadding="10dp"
            android:padding="10dp"
            style="@style/InputBoxStyle"
             />

        <EditText

            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="@string/password"
            android:selectAllOnFocus="true"
            android:inputType="textPassword"
            android:drawablePadding="10dp"
            android:padding="10dp"
            style="@style/InputBoxStyle"
            />
```
其主要的创建代码为：

```
new AlertDialog.Builder(this)
                //设置标题
                .setTitle("ANOROIO  APP")
                //设置对话框的view对象
                .setView(loginForm)
                .setPositiveButton("Sign in", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        show.setText("点击了Sign in按钮！");
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        show.setText("点击了Cancel按钮！");
                    }
                })
                .create()
                .show();
```


* 下图为完成XML定义菜单后，在genymotion模拟下运行的结果图：<br>
![菜单截图1](https://github.com/SuXianPeng/CommonExperimentReport/blob/master/images/%E8%8F%9C%E5%8D%95%E6%88%AA%E5%9B%BE1.JPG)<br>
![菜单截图2](https://github.com/SuXianPeng/CommonExperimentReport/blob/master/images/%E8%8F%9C%E5%8D%95%E6%88%AA%E5%9B%BE2.JPG)<br>
![菜单截图3](https://github.com/SuXianPeng/CommonExperimentReport/blob/master/images/%E8%8F%9C%E5%8D%95%E6%88%AA%E5%9B%BE3.JPG)<br>
其需要创建menu资源并对菜单项进行设置，该xml配置代码为：<br>

```
  <item android:title="@string/menu_Font">
        <menu>
            <item
                android:id="@+id/menu_font_small"
                android:title="@string/menu_font_small" />
            <item
                android:id="@+id/menu_font_middle"
                android:title="@string/menu_font_middle" />
            <item
                android:id="@+id/menu_font_big"
                android:title="@string/menu_font_big" />
        </menu>
    </item>
    <item
        android:id="@+id/menu_Normal"
        android:title="@string/menu_Normal">
    </item>
    <item android:title="@string/menu_Color">
        <menu>
            <item
                android:id="@+id/menu_color_red"
                android:title="@string/menu_color_red" />
            <item
                android:id="@+id/menu_color_black"
                android:title="@string/menu_color_black"/>
        </menu>
    </item>
```
其引用的代码为：

```
 @Override
    //创建选项菜单,共有两种方式,xml创建和直接java代码装配
    public boolean onCreateOptionsMenu(Menu menu) {
        //使用XML文件定义选项菜单，并使用 MenuInflater.inflate() 扩充菜单资源（将 XML 资源转换为可编程对象）
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_xmlmain, menu);
        return true;
    }
```

* 下图为完成上下文菜单实验后，在genymotion模拟下运行的结果图：<br>
![上下文菜单截图](https://github.com/SuXianPeng/CommonExperimentReport/blob/master/images/%E4%B8%8A%E4%B8%8B%E6%96%87%E8%8F%9C%E5%8D%95%E6%88%AA%E5%9B%BE.JPG)<br>
菜单启动监听代码为：<br>

```
 getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int position, long arg3) {


                getListView().setItemChecked(position, !mAdapter.isPositionChecked(position));
                return false;
            }
        });
```
其余代码过于长，请见源码。<br>

* 在实验过程中遇到的问题有:
1.intent无法跳转，原因是未设置资源文件，后来设置资源配置文件解决
代码：<br>
```
<activity android:name=".SimpleAdapterClass"></activity><!--进行页面跳转需要将跳转页面在此声明，设置监听-->
        <activity android:name=".XmlMenuClass"></activity>
        <activity android:name=".ContextMenuClass"></activity>
```
     
2.跳转后文本与图片无法显示，如下图1：
![下图1](https://github.com/SuXianPeng/CommonExperimentReport/blob/master/images/%E5%9B%BE%E7%89%871.jpg)<br>
最后经过查看代码发现是自己用Map存储数据时写法错误，导致数据未存储成功导致的。

3.初次写好自定义对话框时出错，显示如下界面，点击后报错如下图2：
![下图2](https://github.com/SuXianPeng/CommonExperimentReport/blob/master/images/%E5%9B%BE%E7%89%872.jpg)<br>

发现是自己多此一举了，后来解决方法为：将自定义对话框类去掉如何在启动主界面直接编写完成即可。

4.遇到了菜单栏无法显示的问题，寻找了很久的解决方法，截图如下图3：
![下图3](https://github.com/SuXianPeng/CommonExperimentReport/blob/master/images/%E5%9B%BE%E7%89%873.jpg)<br>
最后发现的解决方法为，让活动继承 AppCompatActivity这个类就好了，当有进行页面跳转的时候就需要这样，否则跳转后的页面不显示菜单栏。
* 以上即为对本次实验完成的结果以及一些地方进行一些总结，至于想知道其它更加详细的地方，请翻阅本工程下的相关文件。
