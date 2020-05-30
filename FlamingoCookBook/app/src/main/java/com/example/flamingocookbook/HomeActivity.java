package com.example.flamingocookbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<FoodData> myFoodList;
    FoodData mFoodData;

    private DatabaseReference databaseReference;
    private ValueEventListener valueEventListener;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navlistener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(HomeActivity.this, 1);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading items . . . ");

        myFoodList = new ArrayList<>();

//        mFoodData = new FoodData("Momo","It is so delicious","Non-veg", R.drawable.img1);
//        myFoodList.add(mFoodData);

        final MyAdapter myAdapter = new MyAdapter(HomeActivity.this, myFoodList);
        mRecyclerView.setAdapter(myAdapter);

        //retrieve from database
        databaseReference = FirebaseDatabase.getInstance().getReference("Flamingo_Recipe");
        progressDialog.show();
        valueEventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                myFoodList.clear();

                for(DataSnapshot itemSnapshot: dataSnapshot.getChildren()){

                    FoodData foodData = itemSnapshot.getValue(FoodData.class);

                    myFoodList.add(foodData);
                }

                myAdapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                progressDialog.dismiss();

            }
        });
        //retrieve data ends


    }
    private BottomNavigationView.OnNavigationItemSelectedListener navlistener = new BottomNavigationView.OnNavigationItemSelectedListener() {;
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.nav_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.nav_favorite:
                    selectedFragment = new FavoritesFragment();
                    break;
                case R.id.nav_profile:
                    selectedFragment = new ProfileFragment();
                    break;

            }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                return true;
            }
            };





    public void upload(View view) {
//        startActivity(new Intent(this,RecipeActivity.class));
    }

    public void download(View view) {
    }

    public void btn_uploadActivity(View view) {

        startActivity(new Intent(this, Upload_Recipe.class));
    }
}
