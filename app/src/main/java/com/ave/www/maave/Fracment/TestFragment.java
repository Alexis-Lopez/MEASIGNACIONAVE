package com.ave.www.maave.Fracment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ave.www.maave.Adapter.AdapterTest;
import com.ave.www.maave.Model.mdSession;
import com.ave.www.maave.Model.mdTest;
import com.ave.www.maave.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment extends Fragment {


    public TestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_test, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvTest);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        AdapterTest adapterTest = new AdapterTest(builDescription(),R.layout.item_lecciones,getActivity());
        recyclerView.setAdapter(adapterTest);

        return view;
    }

    public ArrayList<mdTest> builDescription(){
        ArrayList<mdTest> sessions = new ArrayList<>();
        sessions.add(new mdTest("Cultura general"));

        return sessions;
    }

}
