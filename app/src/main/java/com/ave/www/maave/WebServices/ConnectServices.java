package com.ave.www.maave.WebServices;

import com.ave.www.maave.Model.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by trini on 16/05/18.
 */

public class ConnectServices {

    private static final String URL_BASE = "http://192.168.0.36:3000/";

    private static ConnectWS   connectWS;

    public static ConnectWS getConnectWS(){
        init();
        return connectWS;
    }

    public static void init(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                Request original = chain.request();
                Request request;

                if(CurrentUser.getToken() != null){
                    request  = original.newBuilder()
                            .header("Content-Type","application/json")
                            .header("X-User-Email",CurrentUser.getEmail())
                            .header("X-User-Token",  CurrentUser.getToken())
                            .method(original.method(), original.body())
                            .build();
                }else{
                    request = original.newBuilder()
                            .header("Content-Type", "application/json")
                            .method(original.method(), original.body())
                            .build();
                }
                return  chain.proceed(request);
            }
        });

        Gson gson = new GsonBuilder().setLenient().create();

        OkHttpClient client = httpClient.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        connectWS = retrofit.create(ConnectWS.class);
    }


    public interface ConnectWS{

        @POST("users/sign_in.json")
        Call<Usuario> login(@Body HttpRequestLogin requestLogIn);
    }
}


