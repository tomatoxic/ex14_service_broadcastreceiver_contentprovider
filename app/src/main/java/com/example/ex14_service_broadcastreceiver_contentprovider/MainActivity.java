package com.example.ex14_service_broadcastreceiver_contentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    Button btnStart, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("서비스 테스트 예제");

        intent = new Intent(this, MusicService.class);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(intent);
//                android.util.Log.i("서비스 테스트", "startService()");

                // 로그 대신 토스트 메시지, 음악 재생과 동시에 앱은 종료하되 음악은 재생
                Toast.makeText(getApplicationContext(),"startService()",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(intent);
//                android.util.Log.i("서비스 테스트", "stopService()");
                Toast.makeText(getApplicationContext(),"stopService()",Toast.LENGTH_SHORT).show();
            }
        });
    }


}