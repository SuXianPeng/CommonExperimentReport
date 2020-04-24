package com.suxianpeng.uicomponents;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class XmlMenuClass extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_menu);
        editText = (EditText) findViewById(R.id.xmltext);

    }

    @Override
    //创建选项菜单,共有两种方式,xml创建和直接java代码装配
    public boolean onCreateOptionsMenu(Menu menu) {
        //使用XML文件定义选项菜单，并使用 MenuInflater.inflate() 扩充菜单资源（将 XML 资源转换为可编程对象）
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_xmlmain, menu);
        return true;
    }

    @Override
    //处理点击事件
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_font_small:
                editText.setTextSize(10 * 2);
                break;
            case R.id.menu_font_middle:
                editText.setTextSize(16 * 2);
                break;
            case R.id.menu_font_big:
                editText.setTextSize(20 * 2);
                break;
            case R.id.menu_Normal:
                Toast toast = Toast.makeText(this, "您点击了普通菜单项", Toast.LENGTH_SHORT);
                toast.show();
                break;
            case R.id.menu_color_red:
                editText.setTextColor(Color.RED);
                break;
            case R.id.menu_color_black:
                editText.setTextColor(Color.BLACK);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
