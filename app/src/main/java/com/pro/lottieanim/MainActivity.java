package com.pro.lottieanim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.firstOne) LottieAnimationView firstone;
    @BindView(R.id.secondOne) LottieAnimationView secondone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // set the onclickmethod.
        firstone.setOnClickListener(this);
        secondone.setOnClickListener(this);

        // we then move to the next activity after 4 seconds
        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // we define our intention
                Intent intent = new Intent(getApplicationContext(), Onboarding.class);
                startActivity(intent);
                finish();
            }
        },10000);
    }

    @Override
    public void onClick(View v) {

        if (v == firstone){
            // we go ahead and play the animation
            firstone.playAnimation();
            secondone.setProgress(0);
            secondone.pauseAnimation();
        }

        if (v == secondone){
            // we go ahead and play the animations
            secondone.playAnimation();
            firstone.setProgress(0);
            firstone.pauseAnimation();
        }
    }
}