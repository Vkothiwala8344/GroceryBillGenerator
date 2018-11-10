package com.stepintoit.vkoth.grocerybillgenerator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class InvoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);


        TextView tvProduct1Count, tvProduct1Price, tvProduct1TotalPrice,
                tvProduct2Count, tvProduct2Price, tvProduct2TotalPrice,
                tvProduct3Count, tvProduct3Price, tvProduct3TotalPrice,
                tvTotalInvoice;


        tvProduct1Count = (TextView) findViewById(R.id.tv_product1_count);
        tvProduct1Price = (TextView)findViewById(R.id.tv_product1_price);
        tvProduct1TotalPrice = (TextView)findViewById(R.id.tv_product1_tprice);

        tvProduct2Count = (TextView) findViewById(R.id.tv_product2_count);
        tvProduct2Price = (TextView)findViewById(R.id.tv_product2_price);
        tvProduct2TotalPrice = (TextView)findViewById(R.id.tv_product2_tprice);

        tvProduct3Count = (TextView) findViewById(R.id.tv_product3_count);
        tvProduct3Price = (TextView)findViewById(R.id.tv_product3_price);
        tvProduct3TotalPrice = (TextView)findViewById(R.id.tv_product3_tprice);

        tvTotalInvoice = (TextView)findViewById(R.id.tv_tprice);

        Product productApple = (Product) getIntent().getSerializableExtra("apple");
        tvProduct1Count.setText(Integer.toString(productApple.getProductQuantity()));
        tvProduct1Price.setText(Integer.toString(productApple.getProductPrice()));
        tvProduct1TotalPrice.setText(Integer.toString(productApple.getProductQuantity()*productApple.getProductPrice()));

        Product productGrapes = (Product) getIntent().getSerializableExtra("grapes");
        tvProduct2Count.setText(Integer.toString(productGrapes.getProductQuantity()));
        tvProduct2Price.setText(Integer.toString(productGrapes.getProductPrice()));
        tvProduct2TotalPrice.setText(Integer.toString(productGrapes.getProductQuantity()*productGrapes.getProductPrice()));

        Product productBanana = (Product) getIntent().getSerializableExtra("banana");
        tvProduct3Count.setText(Integer.toString(productBanana.getProductQuantity()));
        tvProduct3Price.setText(Integer.toString(productBanana.getProductPrice()));
        tvProduct3TotalPrice.setText(Integer.toString(productBanana.getProductQuantity()*productBanana.getProductPrice()));


        tvTotalInvoice.setText((Integer.toString(productApple.getProductQuantity()*productApple.getProductPrice()+
                productGrapes.getProductQuantity()*productGrapes.getProductPrice()+
               productBanana.getProductQuantity()*productBanana.getProductPrice())));

    }
}
