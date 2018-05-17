package com.example.bookolik.hobies;


import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.facebook.share.internal.DeviceShareDialogFragment.TAG;


/**
 * A simple {@link Fragment} subclass.
 */

public class profileFragment extends Fragment {
    Button cikis;
    public static final String TAG="FACELOG";
    public profileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);




    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



        cikis= getActivity().findViewById(R.id.cikis);
        cikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                LoginManager.getInstance().logOut();

             //   Log.d(TAG, "facebook:onCancel");
               Intent cikisyap=new Intent(getActivity(),giris.class);
                startActivity(cikisyap);


            }
        });
    }


}
