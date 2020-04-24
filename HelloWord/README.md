#实验一相关说明<br>
================
已完成实验一的要求，安装了git工具与Android studio工具，并使用Android studio工具创建了HelloWord工程，利用git工具上传到github仓库中，并在第一次
上传完成之后，总结了上传github的步骤为：<br>
1.点击上传文件夹git bash打开<br>
2.输入git init 初始化本地仓库<br>
3.输入vim .gitignore来编辑gitinore文件（输入忽略文件或文件夹名称）并保存<br>
4.输入git add .添加文件夹中的工程到已初始化的本地仓库中（要输入两遍）<br>
5.输入git commit -m "信息"（信息即描述此次提交，输入此条语句是便于日后查看，并完成本地仓库的添加）<br>
6.输入 git remote add origin git@github.com:SuXianPeng/上传的仓库名.git<br>
7.输入git push origin master(若失败则先把pull再push即先git pullorigin master)<br>
8.若第七步出现push传输文件并成功即可到github中查看仓库了。<br>
以下为HelloWord工程在genymotion模拟器上运行的结果截图，佐证实验的完成:<br>
![](https://github.com/SuXianPeng/CommonExperimentReport/blob/master/images/Helloword.png)  
