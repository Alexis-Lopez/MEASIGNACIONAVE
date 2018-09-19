package com.ave.www.maave.Fracment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ave.www.maave.Adapter.AdapterDocuments;
import com.ave.www.maave.Model.mDocuments;
import com.ave.www.maave.Model.mdSession;
import com.ave.www.maave.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DocFragment extends Fragment {


    public DocFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_doc, container, false);

        RecyclerView rv = (RecyclerView) view.findViewById(R.id.rvDocumentCell);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);

        AdapterDocuments adapter = new AdapterDocuments(builDescription(),R.layout.item_documents,getActivity());
        rv.setAdapter(adapter);

        return view;
    }

    public ArrayList<mDocuments> builDescription(){
        ArrayList<mDocuments> sessions = new ArrayList<>();
        sessions.add(new mDocuments("Modelo de optimizacion","https://www.gams.com/fileadmin/community/contrib/doc/modelado_en_gams.pdf"));
        sessions.add(new mDocuments("El modelo de asignación. Caso del modelo de transporte","https://www.gestiopolis.com/modelo-asignacion-caso-modelo-transporte/"));
        //sessions.add(new mDocuments("Pruebas del Server",""));
        return sessions;
    }

}
