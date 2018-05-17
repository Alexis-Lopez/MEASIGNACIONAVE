package com.ave.www.maave.Fracment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ave.www.maave.Adapter.AdapterQuestions;
import com.ave.www.maave.Model.mdDetailsQuestion;
import com.ave.www.maave.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsQuestionFragment extends Fragment {


    public DetailsQuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details_question, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvQuestions);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        AdapterQuestions adapter = new AdapterQuestions(buildQuestions(),R.layout.item_questions,getActivity());
        recyclerView.setAdapter(adapter);


        return view;
    }

    public ArrayList<mdDetailsQuestion> buildQuestions(){
        ArrayList<mdDetailsQuestion> questions = new ArrayList<>();

        questions.add(new mdDetailsQuestion("Pregunta 1","Respuesta 1","Respuesta 2","Respuesta 3" ));
        questions.add(new mdDetailsQuestion("Pregunta 2","Respuesta 1","Respuesta 2","Respuesta 3" ));
        questions.add(new mdDetailsQuestion("Pregunta 3","Respuesta 1","Respuesta 2","Respuesta 3" ));
        questions.add(new mdDetailsQuestion("Pregunta 4","Respuesta 1","Respuesta 2","Respuesta 3" ));
        questions.add(new mdDetailsQuestion("Pregunta 5","Respuesta 1","Respuesta 2","Respuesta 3" ));

        return questions;
    }

}
