package com.example.flamingocookbook;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class HomeFragment extends Fragment {

//    TextView foodDescription;
//    ImageView foodImage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

//        foodDescription = (TextView)view.findViewById(R.id.tvDescription);
//        foodImage = (ImageView)view.findViewById(R.id.ivImages);

//        Bundle mBundle = getActivity().getIntent().getExtras();
//
//        if(mBundle!=null){
//
//            foodDescription.setText(mBundle.getString("Description"));
//            foodImage.setImageResource(mBundle.getInt("Image"));
//
//        }


        return view;
    }
}
