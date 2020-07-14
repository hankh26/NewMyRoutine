package com.hh1995.myroutine;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

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

    String imgPath;

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
        String fatRat=etfatRate.getText().toString();
        String fatWei=etfatWei.getText().toString();
        String muscle=etmuscle.getText().toString();
        String visceralFat=etvisceralFat.getText().toString();
        String legMuscle=etlegMuscle.getText().toString();
        String basal=etbasal.getText().toString();

        Retrofit retrofit=RetrofitHelper.getInstance2();
        RetrofitService retrofitService=retrofit.create(RetrofitService.class);
        Map<String, String> dataPart=new HashMap<>();
        dataPart.put("weigh",weigh);
        dataPart.put("tall",tall);
        dataPart.put("fatRat",fatRat);
        dataPart.put("fatWei",fatWei);
        dataPart.put("muscle",muscle);
        dataPart.put("visceralFat",visceralFat);
        dataPart.put("legMuscle",legMuscle);
        dataPart.put("basal",basal);

        MultipartBody.Part filePart=null;
        if (imgPath!=null){
            File file=new File(imgPath);
            RequestBody requestBody=RequestBody.create(MediaType.parse("image/*"),file);
            filePart=MultipartBody.Part.createFormData("file",file.getName(),requestBody);
        }
        Call<String> call=retrofitService.postDataToRoutine(dataPart,filePart);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    finish();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });


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
                imgPath=getRealPathFromUri(uri);
            }
        }
    }

    String getRealPathFromUri(Uri uri){
        String[] proj= {MediaStore.Images.Media.DATA};
        CursorLoader loader= new CursorLoader(this, uri, proj, null, null, null);
        Cursor cursor= loader.loadInBackground();
        int column_index= cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result= cursor.getString(column_index);
        cursor.close();
        return  result;
    }
}
