package com.ave.www.maave.Details;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ave.www.maave.Fracment.DetailsQuestionFragment;
import com.ave.www.maave.R;

public class QuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        DetailsQuestionFragment detailsQuestionFragment = new DetailsQuestionFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.Quescontent,detailsQuestionFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();
    }
}
