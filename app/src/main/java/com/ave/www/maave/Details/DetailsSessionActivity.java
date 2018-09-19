package com.ave.www.maave.Details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.ave.www.maave.R;

import org.w3c.dom.Text;

public class DetailsSessionActivity extends AppCompatActivity {

    private static int id_custom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_session);

        Bundle bundle = getIntent().getExtras();
        id_custom = bundle.getInt("key_session_id");

        showToolbar("Leccion # " + id_custom+1,true);
        init();
    }

    public void showToolbar(String Titulo,boolean upBotton){
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(Titulo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upBotton);
    }

    public void init(){
        TextView textView = (TextView) findViewById(R.id.tvTema);
        TextView textView1 = (TextView) findViewById(R.id.tvSubtema);
        TextView textView2 = (TextView) findViewById(R.id.tvtext);
        switch (id_custom){
            case 0:
                textView.setText("Libro de Carlos Fuentes");
                textView1.setText("Colaboracion de Equipo");
                textView2.setText("A muchos empleados e inclusive a grandes gerentes, se les hace difícil colaborar o trabajar en equipo, ya que tienen la idea de que estas dos acciones se refieren a lo mismo"+
                        "\n" +
                        "Por un lado, el trabajo en equipo persigue un resultado en común por parte de los trabajadores, aunque las acciones y los esfuerzos de cada integrante son independientes.\n" +
                        "\n" +
                        "Al ejecutar un trabajo en equipo cada quien hace su parte, pero al final el éxito del proyecto dependerá de la unión de todos esos esfuerzos en común, siempre y cuando  el equipo cuente con un buen líder.\n" +
                        "\n" +
                        "Mientras, que por otro lado, la colaboraciónes trabajar unidos en un proceso para generar ideas o soluciones acordadas, que a veces no resultan tan estratégicas o eficientes como esperan los directivos porque en la mayoría de los casos son prácticas obligatorias y no intencionales.\n" +
                        "\n" +
                        "Sin embargo Theresa Wellbourne, directora del Centro de Emprendimiento de la Universidad de Nebraska Lincoln, afirma que “la colaboración a menudo se consigue en el camino de la innovación, requiere negociación constante entre los miembros del equipo, lo que realmente impulsa la innovación fuera del proceso”.\n" +
                        "\n" +
                        "Básicamente, para que la colaboración de tus empleados sea efectiva se deben establecer objetivos específicos y una estructura clara para las sesiones de colaboración.\n" +
                        "\n" +
                        "“Piensa en lo que estás tratando de lograr y si la colaboración te ayudará a llegar allí”, agrega Wellbourne.");
                break;
            case 1:
                textView.setText(" Hola mundo");
                textView1.setText(" Estoy vivo ");
                textView2.setText(" En informática, un programa Hola mundo es el que imprime el texto «¡Hola, mundo!» en un dispositivo de visualización, en la mayoría de los casos una pantalla de monitor. Este programa suele ser usado como introducción al estudio de un lenguaje de programación, siendo un primer ejercicio típico, y se considera fundamental desde el punto de vista didáctico. uenos días amigos y familiares. Gracias a vuestra compañía hoy será uno de los días más felices de mi vida, y eso el lo que yo deseo para todos y cada uno de vosotros. Que todas las bendiciones caigan sobre vosotros, que seáis felices en este día tan bello y hermoso. ");
                break;

            case 2:
                textView.setText("Prueba del Server");
                textView1.setText("Subtema del Server");
                textView2.setText("No tendo texto disponible ");
                break;
        }
    }
}
