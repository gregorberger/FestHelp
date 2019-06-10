package com.example.gregor.festhelp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.github.chrisbanes.photoview.PhotoView;


public class MapaFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_mapa, container, false);
        PhotoView photoView = (PhotoView) v.findViewById(R.id.mapaImageView);
        photoView.setImageResource(R.drawable.mapa);

//        Button glavniOder = (Button) v.findViewById(R.id.buttonMapaGlavniOder);
//
//        glavniOder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent in = new Intent(getActivity(), NocniActivity.class);
//                startActivity(in);
//            }
//        });

        return v;
    }


}
