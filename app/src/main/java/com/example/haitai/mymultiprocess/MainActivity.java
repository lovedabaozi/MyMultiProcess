package com.example.haitai.mymultiprocess;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myservices.IRemoteService;
import com.example.myservices.Person;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_open;
    private Button bt_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {

        bt_open = (Button) findViewById(R.id.bt_open);

        bt_close = (Button) findViewById(R.id.bt_close);
        bt_open.setOnClickListener(this);
        bt_close.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_open:
                Intent openIntent = new Intent();
                openIntent.setAction("android.com.example.aidl");
                openIntent.setPackage("com.example.myservices");
                bindService(openIntent, ServiceConnection, Context.BIND_AUTO_CREATE);
                break;
            case R.id.bt_close:
                break;
        }
    }

    ServiceConnection ServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("AAA", "绑定服务成功！");

            IRemoteService iRemoteService = IRemoteService.Stub.asInterface(service);
            if (iRemoteService != null) {


                try {
                    Person personInfo = iRemoteService.getPersonInfo();
                    Log.e("AAA", personInfo.getName() + personInfo.getAge() + personInfo.getName());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("AAA", "绑定服务失败！");
        }
    };
}
