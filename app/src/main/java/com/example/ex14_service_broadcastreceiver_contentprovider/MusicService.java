package com.example.ex14_service_broadcastreceiver_contentprovider;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MusicService extends Service {

    MediaPlayer mp;

    @Override
    public IBinder onBind(Intent intent){
        return null;
    }

    @Override
    public void onCreate() {
//        android.util.Log.i("서비스 테스트", "onCreate()");
        Toast.makeText(getApplicationContext(),"onCreate()",Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    @Override
    public void onDestroy() {
//        android.util.Log.i("서비스 테스트", "onDestroy()");
        Toast.makeText(getApplicationContext(),"onDestroy()",Toast.LENGTH_SHORT).show();
        mp.stop();
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        android.util.Log.i("서비스 테스트", "onStartCommand()");
        Toast.makeText(getApplicationContext(),"onStartCommand()",Toast.LENGTH_SHORT).show();
        mp = MediaPlayer.create(this, R.raw.logintheme);
        mp.setLooping(true);
        mp.start();
        return super.onStartCommand(intent, flags, startId);
    }
}