package com.hh1995.myroutine;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MyOptionActivity extends AppCompatActivity {
    ImageView iv;

    TextView date;

    EditText etweigh;
    EditText ettall;
    EditText etfatRate;
    EditText etfatWei;
    EditText etmuscle;
    EditText etvisceralFat;
    EditText etlegMuscle;
    EditText etbasal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_option);

        date=findViewById(R.id.optv);
        etweigh=findViewById(R.id.et_weigh);
        ettall=findViewById(R.id.et_tall);
        etfatRate=findViewById(R.id.et_fat);
        etfatWei=findViewById(R.id.et_fatk);
        etmuscle=findViewById(R.id.et_muscle);
        etvisceralFat=findViewById(R.id.et_infat);
        etlegMuscle=findViewById(R.id.et_legMuscle);
        etbasal=findViewById(R.id.et_energy);
    }

    public void clickBtn(View view) {
        String weigh=etweigh.getText().toString();
        String tall=ettall.getText().toString();
        String fatRate=etfatRate.getText().toString();
        String fatWei=etfatWei.getText().toString();
        String muscle=etmuscle.getText().toString();
        String visceralFat=etvisceralFat.getText().toString();
        String legMuscle=etlegMuscle.getText().toString();
        String basal=etbasal.getText().toString();

        Intent intent=getIntent();
        intent.putExtra("weigh",weigh);
        intent.putExtra("tall",tall);
        intent.putExtra("fatRate",fatRate);
        intent.putExtra("fatWei",fatWei);
        intent.putExtra("muscle",muscle);
        intent.putExtra("visceralFat",visceralFat);
        intent.putExtra("legMuscle",legMuscle);
        intent.putExtra("basal",basal);

        setResult(RESULT_OK,intent);
        finish();
    }

    public void clickImg(View view) {
        Intent intent=new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,11);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 11 && resultCode == RESULT_OK) {
            Uri uri=data.getData();
            if (uri != null) {
                Glide.with(this).load(uri).into(iv);
            }
        }
    }
}
