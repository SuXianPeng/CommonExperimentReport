package com.suxianpeng.uicomponents;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class SimpleAdapterClass extends AppCompatActivity {


    String[] animalNames=new String[]{"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    int[] animalImages=new int[]{R.drawable.lion, R.drawable.tiger, R.drawable.monkey, R.drawable.dog, R.drawable.cat, R.drawable.elephant};

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_simpleadapter);

        List<Map<String,Object>> listItems=new ArrayList<>();
        for(int i=0;i<animalNames.length;i++){
            //利用键值对存储数据
            Map<String,Object> listItem=new HashMap<>();
            listItem.put("animalName",animalNames[i]);
            listItem.put("animalImage",animalImages[i]);
            listItems.add(listItem);
        }

        String[] from=new String[]{"animalName","animalImage"};
        int[] to=new int[]{R.id.textView,R.id.imageView};

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

    }

}
