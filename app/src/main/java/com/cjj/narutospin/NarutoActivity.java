package com.cjj.narutospin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class NarutoActivity extends AppCompatActivity {
    private ImageView iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9;
    private View v1, v2, v3, v4, v5, v6, v7, v8, v9;
    private View g1, g2, g3, g4, g5, g6, g7, g8, g9;
    private ImageView iv_num1, iv_num2, iv_num3, iv_num4, iv_num5, iv_num6, iv_num7, iv_num8, iv_num9;
    private ValueAnimator valueAnimator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naruto);

        iv1 = (ImageView) this.findViewById(R.id.iv1);
        iv2 = (ImageView) this.findViewById(R.id.iv2);
        iv3 = (ImageView) this.findViewById(R.id.iv3);
        iv4 = (ImageView) this.findViewById(R.id.iv4);
        iv5 = (ImageView) this.findViewById(R.id.iv5);
        iv6 = (ImageView) this.findViewById(R.id.iv6);
        iv7 = (ImageView) this.findViewById(R.id.iv7);
        iv8 = (ImageView) this.findViewById(R.id.iv8);
        iv9 = (ImageView) this.findViewById(R.id.iv9);
        v1 = this.findViewById(R.id.v1);
        v2 = this.findViewById(R.id.v2);
        v3 = this.findViewById(R.id.v3);
        v4 = this.findViewById(R.id.v4);
        v5 = this.findViewById(R.id.v5);
        v6 = this.findViewById(R.id.v6);
        v7 = this.findViewById(R.id.v7);
        v8 = this.findViewById(R.id.v8);
        v9 = this.findViewById(R.id.v9);
        g1 = this.findViewById(R.id.g1);
        g2 = this.findViewById(R.id.g2);
        g3 = this.findViewById(R.id.g3);
        g4 = this.findViewById(R.id.g4);
        g5 = this.findViewById(R.id.g5);
        g6 = this.findViewById(R.id.g6);
        g7 = this.findViewById(R.id.g7);
        g8 = this.findViewById(R.id.g8);
        g9 = this.findViewById(R.id.g9);
        iv_num1 = (ImageView) this.findViewById(R.id.iv_num1);
        iv_num2 = (ImageView) this.findViewById(R.id.iv_num2);
        iv_num3 = (ImageView) this.findViewById(R.id.iv_num3);
        iv_num4 = (ImageView) this.findViewById(R.id.iv_num4);
        iv_num5 = (ImageView) this.findViewById(R.id.iv_num5);
        iv_num6 = (ImageView) this.findViewById(R.id.iv_num6);
        iv_num7 = (ImageView) this.findViewById(R.id.iv_num7);
        iv_num8 = (ImageView) this.findViewById(R.id.iv_num8);
        iv_num9 = (ImageView) this.findViewById(R.id.iv_num9);
        reSetBg();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startAnim(4);
            }
        }, 1000);
        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (valueAnimator != null) {
                    reSetBg();
                    valueAnimator.start();
                }
            }
        });
    }

    private void startAnim(int value) {
        valueAnimator = ValueAnimator.ofInt(0, 90+value);
        valueAnimator.setDuration(3 * 3000);
        valueAnimator.setRepeatMode(ValueAnimator.RESTART);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int curValue = (int) valueAnimator.getAnimatedValue();
                Log.i("cjj", "value--->" + curValue);
                marqueeImage(curValue % 9);
            }
        });
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                       v5.setVisibility(View.GONE);
                        g5.setVisibility(View.GONE);
                    }
                }, 1000);

            }
        });
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.start();
    }

    private void marqueeImage(int value) {
        reSetRbg();
        switch (value) {
            case 0:
                g1.setVisibility(View.VISIBLE);
                break;
            case 1:
                g2.setVisibility(View.VISIBLE);
                break;
            case 2:
                g3.setVisibility(View.VISIBLE);
                break;
            case 3:
                g4.setVisibility(View.VISIBLE);
                break;
            case 4:
                g5.setVisibility(View.VISIBLE);
                break;
            case 5:
                g6.setVisibility(View.VISIBLE);
                break;
            case 6:
                g7.setVisibility(View.VISIBLE);
                break;
            case 7:
                g8.setVisibility(View.VISIBLE);
                break;
            case 8:
                g9.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void reSetRbg() {
        g1.setVisibility(View.GONE);
        g2.setVisibility(View.GONE);
        g3.setVisibility(View.GONE);
        g4.setVisibility(View.GONE);
        g5.setVisibility(View.GONE);
        g6.setVisibility(View.GONE);
        g7.setVisibility(View.GONE);
        g8.setVisibility(View.GONE);
        g9.setVisibility(View.GONE);
    }

    private void reSetBg() {
        v1.setVisibility(View.VISIBLE);
        v2.setVisibility(View.VISIBLE);
        v3.setVisibility(View.VISIBLE);
        v4.setVisibility(View.VISIBLE);
        v5.setVisibility(View.VISIBLE);
        v6.setVisibility(View.VISIBLE);
        v7.setVisibility(View.VISIBLE);
        v8.setVisibility(View.VISIBLE);
        v9.setVisibility(View.VISIBLE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_naruto, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
