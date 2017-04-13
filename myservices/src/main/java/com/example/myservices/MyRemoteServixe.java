package com.example.myservices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * Created by haitai on 2017/4/13.
 */

public class MyRemoteServixe  extends Service{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

        private  IRemoteService.Stub mBinder= new IRemoteService.Stub()

    {

        @Override
        public Person getPersonInfo() throws RemoteException {
            return new Person("张三",123,789);
        }
    };

}
