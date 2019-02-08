package com.example.mahfuz.myapplication;


import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import rubikstudio.library.LuckyWheelView;
import rubikstudio.library.model.LuckyItem;

public class MainActivity extends AppCompatActivity {

    List<LuckyItem> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LuckyWheelView luckyWheelView = (LuckyWheelView) findViewById(R.id.luckyWheel);
        List<LuckyItem> data = new ArrayList<>();
        for (int i=0; i<12; i++) {
            LuckyItem luckyItem = new LuckyItem();
            luckyItem.topText = "Item " + i;
            luckyItem.icon = R.drawable.ic_assignment_ind_black_24dp;
            luckyItem.color = 0xffFFF3E0;
            data.add(luckyItem);
        }

        luckyWheelView.setData(data);
        luckyWheelView.setRound(10);

// start
        luckyWheelView.startLuckyWheelWithTargetIndex(0);

// listener after finish lucky wheel
        luckyWheelView.setLuckyRoundItemSelectedListener(new LuckyWheelView.LuckyRoundItemSelectedListener() {
            @Override
            public void LuckyRoundItemSelected(int index) {
                Toast.makeText(MainActivity.this, "index: "+index, Toast.LENGTH_SHORT).show();
            }
        });

    }
    private int getRandomIndex() {
        Random rand = new Random();
        return rand.nextInt(data.size() - 1) + 0;
    }

    private int getRandomRound() {
        Random rand = new Random();
        return rand.nextInt(10) + 15;
    }

}
