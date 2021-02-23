package com.zzh.vrdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zzh.vrdemo.adapter.FruitAdapter;
import com.zzh.vrdemo.view.FlowLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    //点赞
    Button zanLayout,zanLayoutOne;
    //取消点赞
    Button cancelLayout,cancelLayoutOne;
    //流布局
    FlowLayout flowLayout,flowLayoutOne;

    private List<String> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initFruits();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(this, fruitList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        zanLayout = (Button) findViewById(R.id.zan_layout);
        cancelLayout = (Button) findViewById(R.id.cancel_layout);
        flowLayout = (FlowLayout) findViewById(R.id.flow_layout);

        zanLayoutOne = (Button) findViewById(R.id.zan_layout_one);
        cancelLayoutOne = (Button) findViewById(R.id.cancel_layout_one);
        flowLayoutOne = (FlowLayout) findViewById(R.id.flow_layout_one);

        initData();

        flowLayout.setUrls(approveList);

        flowLayoutOne.setUrls(approveList);

        cancelLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flowLayout.cancels("http://www.baidu.com/img/bdlogo.png");
            }
        });


        zanLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flowLayout.setOneUrls("http://www.baidu.com/img/bdlogo.png");
            }
        });


        zanLayoutOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置左边添加
                flowLayoutOne.setFlag(true);
                flowLayoutOne.setOneUrls("http://www.baidu.com/img/bdlogo.png");
            }
        });

        cancelLayoutOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flowLayoutOne.cancels("http://www.baidu.com/img/bdlogo.png");
            }
        });

    }

    private void initFruits() {
        for(int i = 0; i < 10; i++) {
            fruitList.add("http://www.baidu.com/img/bdlogo.png");
        }
    }

    private List<String> approveList;

    private void initData() {
        approveList = new ArrayList<>();
        approveList.add("http://www.baidu.com/img/bdlogo.png");
        approveList.add("http://rongcloud-web.qiniudn.com/docs_demo_rongcloud_logo.png");
        approveList.add("http://www.baidu.com/img/bdlogo.png");
        approveList.add("http://rongcloud-web.qiniudn.com/docs_demo_rongcloud_logo.png");
    }


}
