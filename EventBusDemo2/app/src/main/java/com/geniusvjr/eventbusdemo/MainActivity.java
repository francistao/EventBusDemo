package com.geniusvjr.eventbusdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView tv;
    EventBus eventBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);

        btn = (Button) findViewById(R.id.btn_try);
//        tv = (TextView)findViewById(R.id.tv);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(),
                        SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Subscribe
    public void onEventMainThread(FirstEvent event) {

        Log.d("harvic", "onEventMainThread收到了消息：" + event.getMsg());
    }
    //SecondEvent接收函数一
    @Subscribe
    public void onEventMainThread(SecondEvent event) {

        Log.d("harvic", "onEventMainThread收到了消息：" + event.getMsg());
    }
    //SecondEvent接收函数二
    @Subscribe
    public void onEventBackgroundThread(SecondEvent event){
        Log.d("harvic", "onEventBackground收到了消息：" + event.getMsg());
    }
    //SecondEvent接收函数三
    @Subscribe
    public void onEventAsync(SecondEvent event){
        Log.d("harvic", "onEventAsync收到了消息：" + event.getMsg());
    }
    @Subscribe
    public void onEvent(ThirdEvent event) {
        Log.d("harvic", "OnEvent收到了消息：" + event.getMsg());
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
