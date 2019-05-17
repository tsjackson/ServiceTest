package com.example.servicetest;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class CustomService extends Service {

    private static final String TAG = "CustomService";
    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
        mediaPlayer = MediaPlayer.create(this,
                R.raw.clint_eastwood);
    }
    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG,"Onunbind: ");
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"OnStartCommand: ");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"OnDestroyCommand: ");
        super.onDestroy();
        mediaPlayer.release();
    }
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG,"OnBind: ");
        return null;
    }
}
