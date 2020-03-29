#实验二Android布局实验说明<br>
======================
* 本次实验完成实验二的线性布局、约束布局、表格布局编写出相应的布局图片。需要注意的是本次实验是在一个工程的一个app下创建了多个布局文件，
所以一次只能运行三个布局中的一个，想运行其它需要修改MainActivity代码中的显示的布局，接下来·展示的是布局的最终运行结果以及部分下说明的代码，若想查看
更多请自行查看仓库下本工程的布局文件代码。<br>
<br>
* 下图为完成线性布局后，在genymotion模拟下运行的结果图：<br>
![](https://github.com/SuXianPeng/CommonExperimentReport/blob/master/images/LinearLayout.png)<br>
此布局中文本框显示边框并为白色使用到的是设置文本框背景实现的代码为：<br>


 

```
  
  //在drawable中创建一个text.xml文件定义<br>
<stroke<br>
        android:width="1dip"<br>
        android:color="#ffffff" /><br>
//在该布局文件中的文本框定义<br>
android:background="@drawable/text"<br>
```
