package com.example.bookolik.hobies;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class homeFragment extends Fragment {

    Button paylas,getir,teknoloji,film,bilim,eglence,kultur,sanat,haber;
    public homeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        paylas= getActivity().findViewById(R.id.paylas);
        paylas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent paylasintent=new Intent(getActivity(),paylasim.class);
                startActivity(paylasintent);


            }
        });


        getir= getActivity().findViewById(R.id.button3);
        getir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent paylasintent=new Intent(getActivity(),liste.class);
                startActivity(paylasintent);


            }
        });



        teknoloji= getActivity().findViewById(R.id.button4);
        teknoloji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent paylasintent=new Intent(getActivity(),liste_teknoloji.class);
                startActivity(paylasintent);


            }
        });


        film= getActivity().findViewById(R.id.button5);
        film.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent paylasintent=new Intent(getActivity(),liste_dizi_film.class);
                startActivity(paylasintent);


            }
        });

        bilim= getActivity().findViewById(R.id.button6);
        bilim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent paylasintent=new Intent(getActivity(),liste_bilim.class);
                startActivity(paylasintent);


            }
        });

        eglence= getActivity().findViewById(R.id.button7);
        eglence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent paylasintent=new Intent(getActivity(),liste_eglence.class);
                startActivity(paylasintent);


            }
        });

        kultur= getActivity().findViewById(R.id.button8);
        kultur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent paylasintent=new Intent(getActivity(),liste_kultur.class);
                startActivity(paylasintent);


            }
        });

        sanat= getActivity().findViewById(R.id.button9);
        sanat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent paylasintent=new Intent(getActivity(),liste_sanat.class);
                startActivity(paylasintent);


            }
        });

        haber= getActivity().findViewById(R.id.button10);
        haber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent paylasintent=new Intent(getActivity(),liste_haber.class);
                startActivity(paylasintent);


            }
        });





    }
}
