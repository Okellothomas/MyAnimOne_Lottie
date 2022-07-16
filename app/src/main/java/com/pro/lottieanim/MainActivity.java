package com.pro.lottieanim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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