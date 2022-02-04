package com.example.rectangularprogressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import pl.pawelkleczkowski.customgauge.CustomGauge;

public class MainActivity extends AppCompatActivity {
    
    ProgressBar pb1,pb2,pb3,pb4;
    CustomGauge cg1,cg2,cg3,cg4;
    
    float overAllPercent = 75,totalLen = 0,horizontalLength= 200,verticalLength=60,curvedLength = 30;
    float horizontalPercentTop = 0,horizontalPercentBottom = 0,verticalPercentTop =0,verticalPercentBottom=0;
    float curvedPercentFirst =0,curvedPercentSecond =0,curvedPercentThird =0,curvedPercentForth =0;

    private ProgressBar progressBar;
    private TextView progressText;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        pb1 = findViewById(R.id.bar1);
        pb2 = findViewById(R.id.bar2);
        pb3 = findViewById(R.id.bar3);
        pb4 = findViewById(R.id.bar4);
        
        cg1 = findViewById(R.id.gauge01);
        cg2 = findViewById(R.id.gauge02);
        cg3 = findViewById(R.id.gauge03);
        cg4 = findViewById(R.id.gauge04);

        init();

        progressBar = findViewById(R.id.progress_bar);
        progressText = findViewById(R.id.progress_text);

        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (i <= 90) {
                    progressText.setText("" + i);
                    progressBar.setProgress(i);
                    i++;
                    handler.postDelayed(this, 150);
                } else {
                    handler.removeCallbacks(this);
                }
            }
        }, 200);
        
    }
    
    public void init(){
        totalLen = 2*horizontalLength+2*verticalLength+4*curvedLength;
        float horizontal = (horizontalLength*100)/totalLen;
        float vertical = (verticalLength*100)/totalLen;
        float curved = (curvedLength*100)/totalLen;
        Log.d("totalLen", "init: horizontal-"+horizontal+" vertical-"+vertical+" curved-"+curved);
        if(overAllPercent>=horizontal){
            pb1.setProgress(100);
            overAllPercent-=horizontal;
        }else if(overAllPercent<0){
            return;
        }else{
            float value = (100*overAllPercent)/horizontal;
            pb1.setProgress((int) value);
            overAllPercent-=horizontal;
            return;
        }
        Log.d("totalLen", "init: horizontal-"+horizontal+" vertical-"+vertical+" curved-"+curved+" percent-"+overAllPercent);
        if(overAllPercent>=curved){
            cg2.setValue(100);
            overAllPercent-=curved;
        }
        else if(overAllPercent<0){
            return;
        }else{
            float value = (100*overAllPercent)/curved;
            cg2.setValue((int) value);
            overAllPercent-=curved;
            return;
        }
        Log.d("totalLen", "init: horizontal-"+horizontal+" vertical-"+vertical+" curved-"+curved+" percent-"+overAllPercent);
        if(overAllPercent>=vertical){
            pb2.setProgress(100);
            overAllPercent-=vertical;
        }
        else if(overAllPercent<0){
            return;
        }else{
            float value = (100*overAllPercent)/vertical;
            pb2.setProgress((int) value);
            overAllPercent-=vertical;
            return;
        }
        Log.d("totalLen", "init: horizontal-"+horizontal+" vertical-"+vertical+" curved-"+curved+" percent-"+overAllPercent);
        if(overAllPercent>=curved){
            cg3.setValue(100);
            overAllPercent-=curved;
        }
        else if(overAllPercent<0){
            cg3.setValue(0);
            return;
        }else{
            float value = (100*overAllPercent)/curved;
            cg3.setValue((int) value);
            overAllPercent-=curved;
            return;
        }
        Log.d("totalLen", "init: horizontal-"+horizontal+" vertical-"+vertical+" curved-"+curved+" percent-"+overAllPercent);
        if(overAllPercent>=horizontal){
            pb3.setProgress(100);
            overAllPercent-=horizontal;
        }
        else if(overAllPercent<0){
            return;
        }else{
            float value = (100*overAllPercent)/horizontal;
            pb3.setProgress((int) value);
            overAllPercent-=horizontal;
            return;
        }
        Log.d("totalLen", "init: horizontal-"+horizontal+" vertical-"+vertical+" curved-"+curved+" percent-"+overAllPercent);
        if(overAllPercent>=curved){
            cg4.setValue(100);
            overAllPercent-=curved;
        }
        else if(overAllPercent<0){
            return;
        }else{
            float value = (100*overAllPercent)/curved;
            cg4.setValue((int) value);
            overAllPercent-=curved;
            return;
        }
        Log.d("totalLen", "init: horizontal-"+horizontal+" vertical-"+vertical+" curved-"+curved+" percent-"+overAllPercent);
        if(overAllPercent>=vertical){
            pb4.setProgress(100);
            overAllPercent-=vertical;
        }
        else if(overAllPercent<0){
            return;
        }else{
            float value = (100*overAllPercent)/vertical;
            pb4.setProgress((int) value);
            overAllPercent-=vertical;
            return;
        }
        Log.d("totalLen", "init: horizontal-"+horizontal+" vertical-"+vertical+" curved-"+curved+" percent-"+overAllPercent);
        if(overAllPercent>=curved){
            cg1.setValue(100);
            overAllPercent-=curved;
        } else{
            float value = (100*overAllPercent)/curved;
            cg1.setValue((int) value);
            overAllPercent-=curved;
        }
    }
}