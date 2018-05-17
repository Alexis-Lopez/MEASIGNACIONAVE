package com.ave.www.maave.WebServices;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by trini on 16/05/18.
 */

public class CurrentUser {
    public static String getToken(){
        SharedPreferences prefs = App.getContext().getSharedPreferences("evatransportes", Context.MODE_PRIVATE);
        String value = prefs.getString("token",null);
        return value;
    }

    public static String getEmail(){
        SharedPreferences prefs = App.getContext().getSharedPreferences("evatransportes",Context.MODE_PRIVATE);
        String value = prefs.getString("email",null);
        return value;
    }

    public static String getRol(){
        SharedPreferences prefs =  App.getContext().getSharedPreferences("evatransportes",Context.MODE_PRIVATE);
        String value = prefs.getString("rol",null);
        return value;
    }

    public static void setPreferences(String rol , String token,String email) {

        SharedPreferences.Editor editor = App.getContext().getSharedPreferences("evatransportes", Context.MODE_PRIVATE).edit();

        editor.putString("rol", rol);
        editor.putString("token", token);
        editor.putString("email",email);
        editor.commit();

    }
}
