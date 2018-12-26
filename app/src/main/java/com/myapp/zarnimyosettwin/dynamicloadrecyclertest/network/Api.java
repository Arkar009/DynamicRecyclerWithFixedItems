package com.myapp.zarnimyosettwin.dynamicloadrecyclertest.network;

import com.myapp.zarnimyosettwin.dynamicloadrecyclertest.models.NetworkResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ZNMSW on 10/11/2017.
 */

public interface Api {

    String BASE_URL = "http://navjacinth9.000webhostapp.com/json/";

    @GET("retrofit-demo.php")
    Call<NetworkResponse> getQuestion(@Query("company_no") int id);


}