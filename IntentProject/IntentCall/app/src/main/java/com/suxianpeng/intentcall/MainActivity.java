package com.suxianpeng.intentcall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity  {

    EditText exditText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exditText=findViewById(R.id.EdictText_uri);
        button=findViewById(R.id.Button_call);

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
        });
    }
}
