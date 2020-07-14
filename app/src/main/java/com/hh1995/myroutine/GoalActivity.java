package com.hh1995.myroutine;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.bumptech.glide.Glide;

public class GoalActivity extends AppCompatActivity {

    EditText etweigh;
    EditText ettall;
    EditText etfatRate;
    EditText etfatWei;
    EditText etmuscle;
    EditText etvisceralFat;
    EditText etlegMuscle;
    EditText etbasal;

    int imgRequestCode =10;

    ImageView iv;

    Button btn;

    T1Fragment t1Fragment;

    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);
        etweigh=findViewById(R.id.et_weigh);
        ettall=findViewById(R.id.et_tall);
        etfatRate=findViewById(R.id.et_fat);
        etfatWei=findViewById(R.id.et_fatk);
        etmuscle=findViewById(R.id.et_muscle);
        etvisceralFat=findViewById(R.id.et_infat);
        etlegMuscle=findViewById(R.id.et_legMuscle);
        etbasal=findViewById(R.id.et_energy);

        iv=findViewById(R.id.goalIv);
//
//        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
//            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){
//                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
//
//            }
//        }

        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                Toast.makeText(GoalActivity.this, weigh+"", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        switch (requestCode){
//            case 100:
//                if (grantResults[0] ==PackageManager.PERMISSION_DENIED) {
//                    Toast.makeText(this, "앱을 사용할수 없습니다", Toast.LENGTH_SHORT).show();
//                    finish();
//
//                }
//                break;
//        }
//
//    }


    public void clickImg(View view) {
        Intent intent=new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,imgRequestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 10 && resultCode == RESULT_OK) {
            Uri uri=data.getData();
            if (uri != null) {
                Glide.with(this).load(uri).into(iv);
            }
        }
    }
}
