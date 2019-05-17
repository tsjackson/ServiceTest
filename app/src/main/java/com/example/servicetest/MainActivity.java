package com.example.servicetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button onStart,onStop;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        onStart = findViewById(R.id.btn_startService);
        onStop = findViewById(R.id.tn_stopService);

        onStart.setOnClickListener(view -> startCService());
        onStop.setOnClickListener(view -> stopCService());
    }
    private void startCService(){
        startService(
                getStartIntentService()
        );

    }
    private void stopCService(){
        stopService(
                getStopIntentService()
        );

    }

    public Intent getCustomService(){
        return new Intent(MainActivity.this, CustomService.class);
    }
    public Intent getStartIntentService(){
        Intent intent = new Intent(this,MyIntentService.class);
        intent.setAction(MyIntentService.ACTION_FOO);
        return intent;
    }
    public Intent getStopIntentService(){
        Intent intent = new Intent(this,MyIntentService.class);
        intent.setAction(MyIntentService.ACTION_BAZ);
        return intent;
    }
}
