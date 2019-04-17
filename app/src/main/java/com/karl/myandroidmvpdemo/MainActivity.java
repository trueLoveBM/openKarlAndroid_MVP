package com.karl.myandroidmvpdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnSongCi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSongCi=findViewById(R.id.btnSongCi);
        btnSongCi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSongCi:
                showActivity(SongCiActivity.class);
                break;
        }
    }

    private void showActivity(Class tClass){
        Intent intent=new Intent(this,tClass);
        startActivity(intent);
    }
}
