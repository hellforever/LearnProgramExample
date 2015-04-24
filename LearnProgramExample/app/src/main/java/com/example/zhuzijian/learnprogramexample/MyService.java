package com.example.zhuzijian.learnprogramexample;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class MyService extends Service {
    private Binder myBinder = new MyBinder();

    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    /** method for clients */
    public int getRandomNumber() {
        Random random = new Random(System.currentTimeMillis());
        return random.nextInt();
    }

    public class MyBinder extends Binder {
        MyService getService(){
            return MyService.this;
        }
    }
}
