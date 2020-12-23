package com.aymen.essai;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTwo extends Fragment {

    Bundle b;
    TextView txt;

    public FragmentTwo() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_two, container, false);

        String don = this.getArguments().getString("donne1");
        txt = (TextView) view.findViewById(R.id.txt_frag2);
        txt.setText(don);
        return view;

    }

}
