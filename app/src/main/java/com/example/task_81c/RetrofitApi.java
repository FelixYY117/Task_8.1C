package com.example.task_81c;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi {
    private static Retrofit retrofit = null;
    public static Service getClient() {
        if (retrofit == null) {
            // Create OkHttpClient with logging interceptor
            OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClientBuilder.addInterceptor(loggingInterceptor);

            // Build Retrofit instance with OkHttpClient and base URL
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:5000/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(new OkHttpClient.Builder().readTimeout(10, java.util.concurrent.TimeUnit.MINUTES).build())
                    // this will set the read timeout for 10mins (IMPORTANT: If not your request will exceed the default read timeout)
                    .build();
        }
        return retrofit.create(Service.class);
   }
}
