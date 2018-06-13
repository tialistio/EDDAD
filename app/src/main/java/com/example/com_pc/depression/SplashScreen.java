package com.example.com_pc.depression;
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SplashScreen extends Activity {
    public void onAttachedToWindow(){
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }

    Thread splashTread;
    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_splashscreen);
        StartAnimations();
    }
    private void StartAnimations(){
        Animation anim = AnimationUtils.loadAnimation(this,R.anim.alpha);
        anim.reset();
        LinearLayout l = (LinearLayout)findViewById(R.id.lin_lay);
        l.clearAnimation();
        l.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this,R.anim.translate);
        anim.reset();
        ImageView iv = (ImageView)findViewById(R.id.splash1);
        iv.clearAnimation();
        iv.startAnimation(anim);
        ImageView iv2 = (ImageView)findViewById(R.id.splash2);
        iv2.clearAnimation();
        iv2.startAnimation(anim);
        splashTread = new Thread(){
            @Override
            public void run(){
                try {
                    int waited = 0;
                    while (waited < 3500) {
                        sleep(100);
                        waited +=100;
                    }
                    Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    SplashScreen.this.finish();
                }catch(InterruptedException e){

                }finally{
                    SplashScreen.this.finish();
                }
            }
        };
        splashTread.start();
    }
}