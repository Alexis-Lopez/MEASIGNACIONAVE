package com.ave.www.maave;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.ave.www.maave.Fracment.DocFragment;
import com.ave.www.maave.Fracment.GrafictFragment;
import com.ave.www.maave.Fracment.MethodAveFragment;
import com.ave.www.maave.Fracment.SessionsFragment;
import com.ave.www.maave.Fracment.TestFragment;

public class DashboardTeaActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_tea);
        SessionsFragment leccionesFragment = new SessionsFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,leccionesFragment).commit();
        botom();
    }

    public void botom(){
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottombarteacher);
        bottomNavigationView.setSelectedItemId(R.id.leccionesitem);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.leccionesitem){
                    showToolbar("Lecciones",false);
                    SessionsFragment leccionesFragment = new SessionsFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,leccionesFragment).commit();
                    return true;
                }else if (item.getItemId() == R.id.examenesitem){
                    showToolbar("Examenes",false);
                    TestFragment examenesFragment =  new TestFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,examenesFragment).commit();
                    return true;
                }else if(item.getItemId() == R.id.docItem){
                    showToolbar("Documentos",false);
                    DocFragment documentFragment = new DocFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,documentFragment).commit();
                    return true;
                }else if(item.getItemId() == R.id.metItem){
                    showToolbar("Metodo EVA",false);
                    MethodAveFragment metodoAVEFragment = new MethodAveFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,metodoAVEFragment).commit();
                    return true;
                }else if (item.getItemId() == R.id.grafict){
                    showToolbar("Graficas del Alumno" , false);
                    GrafictFragment grafictFragment = new GrafictFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,grafictFragment).commit();
                }


                return false;
            }
        });
    }

    public void showToolbar(String Titulo,boolean upBotton){
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(Titulo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upBotton);
    }
}
