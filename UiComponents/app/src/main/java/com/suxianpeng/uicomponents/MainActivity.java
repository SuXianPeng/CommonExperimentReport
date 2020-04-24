package com.suxianpeng.uicomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    }



    public  void AlertDailog(){
        show=findViewById(R.id.show);
        TableLayout loginForm=(TableLayout)getLayoutInflater().inflate(R.layout.activity_alertdialog,null);//在扁平化获取布局文件资源时，需要指定布局文件类型
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

    }
}
