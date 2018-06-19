package com.ave.www.maave.Fracment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ave.www.maave.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GrafictFragment extends Fragment {


    public GrafictFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_grafict, container, false);
    }

}
