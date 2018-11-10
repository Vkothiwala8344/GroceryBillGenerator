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
        Product pApple = new Product();
        pApple.setProductId(1);
        pApple.setProductName("Apple");
        pApple.setProductPrice(3);
        pApple.setProductQuantity(cApple);

        Product pGrapes = new Product();
        pGrapes.setProductId(2);
        pGrapes.setProductName("Grapes");
        pGrapes.setProductPrice(5);
        pGrapes.setProductQuantity(cGrapes);

        Product pBanana = new Product();
        pBanana.setProductId(3);
        pBanana.setProductName("Banana");
        pBanana.setProductPrice(4);
        pBanana.setProductQuantity(cBanana);

        Intent i = new Intent(getApplicationContext(), InvoiceActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("apple", pApple);
        bundle.putSerializable("grapes", pGrapes);
        bundle.putSerializable("banana", pBanana);
        i.putExtras(bundle);
        startActivity(i);

    }


}

