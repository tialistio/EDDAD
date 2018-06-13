package com.example.com_pc.depression.BDITest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.com_pc.depression.R;

public class bdiStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bdi_start);
        TextView bdiBtn = (TextView)findViewById(R.id.bdiBtn);
        bdiBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent bdiIntent1 = new Intent(bdiStart.this,bdiActivity.class);
                bdiStart.this.startActivity(bdiIntent1);
            }
        });
    }
}
