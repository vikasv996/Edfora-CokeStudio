package com.example.android.edfora_cokestudio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity {

    ImageView logoImageView;
    Animation fadeInAnimation;
    Animation fadeZoomAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        logoImageView = (ImageView) findViewById(R.id.logo_image_view);
        fadeInAnimation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.fade_in);
        //fadeZoomAnimation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.animation);

        logoImageView.startAnimation(fadeInAnimation);
        fadeInAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //logoImageView.startAnimation(fadeInAnimation);
                finish();
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
