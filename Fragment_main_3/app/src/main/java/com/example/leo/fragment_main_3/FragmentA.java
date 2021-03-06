package com.example.leo.fragment_main_3;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Leo on 28.11.2016..
 */

public class FragmentA extends Fragment implements View.OnClickListener{

    Button button;
    int counter=0;
    Communicator comm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState==null) // fragment made for the first time
        {
            counter=0;
        }
        else
        {
            counter = savedInstanceState.getInt("counter",0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        comm = (Communicator) getActivity();
        button = (Button) getActivity().findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter",counter);
    }

    @Override
    public void onClick(View view) {
        counter++;
        comm.respond("The button was clicked " +counter+ " times");
    }
}
