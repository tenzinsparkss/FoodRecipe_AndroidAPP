package com.example.flamingocookbook;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    TextView foodTitle;
    TextView foodDescription;
    ImageView foodImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        foodTitle = (TextView)findViewById(R.id.tvTitle);
        foodDescription = (TextView)findViewById(R.id.tvDescription);
        foodImage = (ImageView)findViewById(R.id.ivImages);

        Bundle mBundle = getIntent().getExtras();

        if(mBundle!=null){

            foodTitle.setText(mBundle.getString("Title"));
            foodDescription.setText(mBundle.getString("Description"));
            //foodImage.setImageResource(mBundle.getInt("Image"));

            Glide.with(this)
                    .load(mBundle.getString("Image"))
                    .into(foodImage);

        }
    }
}
