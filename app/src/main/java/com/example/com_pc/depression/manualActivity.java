package com.example.com_pc.depression;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class manualActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);
        TextView txtLink = (TextView)this.findViewById(R.id.txtLink);

        txtLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.ncmh.go.kr/kor/board/snmhHtmlView.jsp?no=1260&menu_cd=K_03_01_00_00_Q0"));
                startActivity(intent);

            }

        });
    }
}
