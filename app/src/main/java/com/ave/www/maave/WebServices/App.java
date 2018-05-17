package com.ave.www.maave.WebServices;

/**
 * Created by trini on 16/05/18.
 */

public class App {

    private static final android.app.Application APP;

    public static android.content.Context getContext() {
        return APP.getApplicationContext();
    }

    static {
        try{
            Class<?> c = Class.forName("android.app.ActivityThread");
            APP = (android.app.Application) c.getDeclaredMethod("currentApplication").invoke(null);
        }catch (Throwable ex){
            throw new AssertionError(ex);
        }
    }
}
