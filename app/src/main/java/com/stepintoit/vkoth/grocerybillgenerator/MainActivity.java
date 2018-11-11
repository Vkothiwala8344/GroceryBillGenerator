package com.stepintoit.vkoth.grocerybillgenerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    static int cApple = 0, cGrapes = 0, cBanana = 0;
    static final String KEY_APPLE = "apple";
    static  final String KEY_GRAPES = "grapes";
    static final String KEY_BANANA = "banana";

    static  final String PRODUCT1_NAME = "apple";
    static  final String PRODUCT2_NAME = "grapes";
    static  final String PRODUCT3_NAME = "banana";

    static final int PRODUCT1_PRICE = 3;
    static final int PRODUCT2_PRICE = 5;
    static final int PRODUCT3_PRICE = 4;

    @BindView(R.id.btn_increase_apple)
    Button btnIncrApple;
    @BindView(R.id.btn_decrease_apple)
    Button btnDecrApple;
    @BindView(R.id.btn_increase_grapes)
    Button btnIncrGrapes;
    @BindView(R.id.btn_decrease_grapes)
    Button btnDecrGrapes;
    @BindView(R.id.btn_increase_banana)
    Button btnIncrBanana;
    @BindView(R.id.btn_decrease_banana)
    Button btnDecrBanana;
    @BindView(R.id.btn_submit)
    Button btnSubmit;

    @BindView(R.id.tv_count_apple)
    TextView tvCountApple;
    @BindView(R.id.tv_count_grapes)
    TextView tvCountGrapes;
    @BindView(R.id.tv_count_banana)
    TextView tvCountBanana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("appleCount", cApple);
        outState.putInt("grapesCount", cGrapes);
        outState.putInt("bananaCount", cBanana);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        int cApp, cGra, cBan;
        cApp = savedInstanceState.getInt("appleCount");
        cGra = savedInstanceState.getInt("grapesCount");
        cBan = savedInstanceState.getInt("bananaCount");

        tvCountApple.setText(Integer.toString(cApp));
        tvCountGrapes.setText(Integer.toString(cGra));
        tvCountBanana.setText(Integer.toString(cBan));

        super.onRestoreInstanceState(savedInstanceState);
    }

    @OnClick(R.id.btn_submit)
    void onClickSubmit() {
        if (cApple < 0 || cGrapes < 0 || cBanana < 0) {
            Toast.makeText(getApplicationContext(), "item number can not be negative", Toast.LENGTH_SHORT).show();
        } else {
            openInvoicePage();
        }
    }

    @OnClick(R.id.btn_increase_apple)
    void onClickAppleIncrease() {
        cApple++;
        tvCountApple.setText(Integer.toString(cApple));
    }

    @OnClick(R.id.btn_decrease_apple)
    void onClickAppleDecrease() {
        cApple--;
        tvCountApple.setText(Integer.toString(cApple));
    }

    @OnClick(R.id.btn_increase_grapes)
    void onClickGrapesIncrease() {
        cGrapes++;
        tvCountGrapes.setText(Integer.toString(cGrapes));
    }

    @OnClick(R.id.btn_decrease_grapes)
    void onClickGrapesDecrease() {
        cGrapes--;
        tvCountGrapes.setText(Integer.toString(cGrapes));
    }

    @OnClick(R.id.btn_increase_banana)
    void onClickBananaIncrease() {
        cBanana++;
        tvCountBanana.setText(Integer.toString(cBanana));
    }

    @OnClick(R.id.btn_decrease_banana)
    void onClickBananaDecrease() {
        cBanana--;
        tvCountBanana.setText(Integer.toString(cBanana));
    }

    void openInvoicePage() {
        Product pApple = new Product(1,PRODUCT1_NAME,cApple,PRODUCT1_PRICE);
        Product pGrapes = new Product(2,PRODUCT2_NAME,cGrapes,PRODUCT2_PRICE);
        Product pBanana = new Product(3,PRODUCT3_NAME,cBanana,PRODUCT3_PRICE);

        Intent i = new Intent(getApplicationContext(), InvoiceActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_APPLE, pApple);
        bundle.putSerializable(KEY_GRAPES, pGrapes);
        bundle.putSerializable(KEY_BANANA, pBanana);
        i.putExtras(bundle);
        startActivity(i);

    }


}

