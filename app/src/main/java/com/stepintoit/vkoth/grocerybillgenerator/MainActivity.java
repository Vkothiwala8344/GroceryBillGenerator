package com.stepintoit.vkoth.grocerybillgenerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static int cApple = 0, cGrapes = 0, cBanana = 0;
    Button btnSubmit, btnIncrApple, btnDecrApple, btnIncrGrapes, btnDecrGrapes, btnIncrBanana, btnDecrBanana;
    TextView tvCountApple, tvCountGrapes, tvCountBanana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnSubmit = (Button) findViewById(R.id.btn_submit);
        btnIncrApple = (Button) findViewById(R.id.btn_increase_apple);
        btnDecrApple = (Button) findViewById(R.id.btn_decrease_apple);
        btnIncrGrapes = (Button) findViewById(R.id.btn_increase_grapes);
        btnDecrGrapes = (Button) findViewById(R.id.btn_decrease_grapes);
        btnIncrBanana = (Button) findViewById(R.id.btn_increase_banana);
        btnDecrBanana = (Button) findViewById(R.id.btn_decrease_banana);

        tvCountApple = (TextView) findViewById(R.id.tv_count_apple);
        tvCountGrapes = (TextView) findViewById(R.id.tv_count_grapes);
        tvCountBanana = (TextView) findViewById(R.id.tv_count_banana);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cApple < 0 || cGrapes < 0 || cBanana < 0) {
                    Toast.makeText(getApplicationContext(), "item number can not be negative", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(MainActivity.this, InvoiceActivity.class));
                }
            }
        });

        btnIncrApple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cApple++;
                tvCountApple.setText(Integer.toString(cApple));
            }
        });

        btnDecrApple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cApple--;
                tvCountApple.setText(Integer.toString(cApple));
            }
        });

        btnIncrGrapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cGrapes++;
                tvCountGrapes.setText(Integer.toString(cGrapes));
            }
        });

        btnDecrGrapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cGrapes--;
                tvCountGrapes.setText(Integer.toString(cGrapes));
            }
        });

        btnIncrBanana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cBanana++;
                tvCountBanana.setText(Integer.toString(cBanana));
            }
        });

        btnDecrBanana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cBanana--;
                tvCountBanana.setText(Integer.toString(cBanana));
            }
        });


    }

}
