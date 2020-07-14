package com.hh1995.myroutine;

import java.util.ArrayList;
import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

public interface RetrofitService {

    @Multipart
    @POST("/MyRoutine/insertDB.php")
    Call<String> postDataToRoutine(@PartMap Map<String, String> dataPart,
                                   @Part MultipartBody.Part filePart);

    @GET("/MyRoutine/loadDB.php")
    Call<ArrayList<Item>> loadDataFromRoutine();
}
