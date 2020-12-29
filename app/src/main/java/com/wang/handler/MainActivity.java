package com.wang.handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView viewById;
    private Button button;

    Handler handler = new Handler (){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1001:
                    Object obj = msg.obj;
                    viewById.setText("helllo");
                    break;
                default:
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        viewById = findViewById(R.id.tv_test);
        button = findViewById(R.id.btn_test);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_test:
                new Thread(()->{
                    Message message = Message.obtain();
                    message.what = 1001;
                    handler.sendMessage(message);
                }).start();
                break;
            default:
        }
    }
}