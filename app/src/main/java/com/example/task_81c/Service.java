package com.example.task_81c;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
public interface Service {
    @POST("chat")
    Call<Response> sendMessage(@Body ApiRequest request);
}
