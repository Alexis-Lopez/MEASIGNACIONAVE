package com.ave.www.maave;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ave.www.maave.Model.Usuario;
import com.ave.www.maave.WebServices.App;
import com.ave.www.maave.WebServices.ConnectServices;
import com.ave.www.maave.WebServices.CurrentUser;
import com.ave.www.maave.WebServices.HttpRequestLogin;


import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    void goRegister(View view){
        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }

    public void goDashBoard(final View view){

        /*TextInputEditText edtEmail = (TextInputEditText) findViewById(R.id.username);
        TextInputEditText editText  = (TextInputEditText) findViewById(R.id.password);

        String User , Pass;

        User  = edtEmail.getText().toString().trim();
        Pass = editText.getText().toString().trim();

        HttpRequestLogin lr = new HttpRequestLogin(User,Pass);
        retrofit2.Call api = ConnectServices.getConnectWS().login(lr);

       api.enqueue(new Callback<Usuario>() {
           @Override
           public void onResponse(retrofit2.Call<Usuario> call, Response<Usuario> response) {
               if(response.isSuccessful()){
                   CurrentUser.setPreferences(
                           response.body().getRol(),
                           response.body().getAuthentication(),
                           response.body().getRol()
                   );*/
                   Intent intent =  new Intent(getBaseContext(),DashboardTeaActivity.class);
                   startActivity(intent);

               /*}
               else{
                   Toast.makeText(getBaseContext(),"El usuario o la contrase;a esta equivocda",Toast.LENGTH_SHORT).show();
               }

           }

           @Override
           public void onFailure(retrofit2.Call<Usuario> call, Throwable t) {
                Log.e("ERROR",t.getMessage());

               Toast.makeText(App.getContext(),t.getMessage(), Toast.LENGTH_SHORT).show();
           }
       });*/


    }

}
