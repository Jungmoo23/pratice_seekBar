package com.example.pratice_seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekBar;
    private TextView textView;
    private Button decrease, increase;
    private int value = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setLisner();
    }

    private void init(){
        seekBar = findViewById(R.id.seek);
        textView = findViewById(R.id.text);
        decrease = findViewById(R.id.btndec);
        increase = findViewById(R.id.btninc);
        value = seekBar.getProgress();
    }

    private void setLisner(){
        decrease.setOnClickListener(new TouchLisenr());
        increase.setOnClickListener(new TouchLisenr());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                addText(seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                addText(seekBar.getProgress());
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                addText(seekBar.getProgress());
            }
        });

    }

    class TouchLisenr implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btndec:
                    if(value <0){
                        seekBar.setProgress(0);
                    }
                    seekBar.setProgress(--value);
                    break;
                case R.id.btninc:
                    if(value >11){
                        seekBar.setProgress(10);
                    }
                    seekBar.setProgress(++value);
                    break;
            }
        }
    }

    private void addText(int value){
        this.value = value;
        textView.setText("this is seekBar value:: "+value);
    }

}