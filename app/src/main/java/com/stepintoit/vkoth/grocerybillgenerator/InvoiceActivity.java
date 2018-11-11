package com.stepintoit.vkoth.grocerybillgenerator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InvoiceActivity extends AppCompatActivity {

    static final String KEY_APPLE = "apple";
    static  final String KEY_GRAPES = "grapes";
    static final String KEY_BANANA = "banana";

    @BindView(R.id.tv_product1_count)
    TextView tvProduct1Count;
    @BindView(R.id.tv_product1_price)
    TextView tvProduct1Price;
    @BindView(R.id.tv_product1_tprice)
    TextView tvProduct1TotalPrice;

    @BindView(R.id.tv_product2_count)
    TextView tvProduct2Count;
    @BindView(R.id.tv_product2_price)
    TextView tvProduct2Price;
    @BindView(R.id.tv_product2_tprice)
    TextView tvProduct2TotalPrice;

    @BindView(R.id.tv_product3_count)
    TextView tvProduct3Count;
    @BindView(R.id.tv_product3_price)
    TextView tvProduct3Price;
    @BindView(R.id.tv_product3_tprice)
    TextView tvProduct3TotalPrice;

    @BindView(R.id.tv_tprice)
    TextView tvTotalInvoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);
        ButterKnife.bind(this);

        showProductInformation();

    }

    void showProductInformation() {
        Product productApple = (Product) getIntent().getSerializableExtra(KEY_APPLE);
        tvProduct1Count.setText(Integer.toString(productApple.getProductQuantity()));
        tvProduct1Price.setText(Integer.toString(productApple.getProductPrice()));
        tvProduct1TotalPrice.setText(Integer.toString(productApple.getProductQuantity() * productApple.getProductPrice()));

        Product productGrapes = (Product) getIntent().getSerializableExtra(KEY_GRAPES);
        tvProduct2Count.setText(Integer.toString(productGrapes.getProductQuantity()));
        tvProduct2Price.setText(Integer.toString(productGrapes.getProductPrice()));
        tvProduct2TotalPrice.setText(Integer.toString(productGrapes.getProductQuantity() * productGrapes.getProductPrice()));

        Product productBanana = (Product) getIntent().getSerializableExtra(KEY_BANANA);
        tvProduct3Count.setText(Integer.toString(productBanana.getProductQuantity()));
        tvProduct3Price.setText(Integer.toString(productBanana.getProductPrice()));
        tvProduct3TotalPrice.setText(Integer.toString(productBanana.getProductQuantity() * productBanana.getProductPrice()));


        tvTotalInvoice.setText((Integer.toString(productApple.getProductQuantity() * productApple.getProductPrice() +
                productGrapes.getProductQuantity() * productGrapes.getProductPrice() +
                productBanana.getProductQuantity() * productBanana.getProductPrice())));

    }
}
