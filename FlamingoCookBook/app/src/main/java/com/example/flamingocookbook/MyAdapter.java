package com.example.flamingocookbook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.net.CacheRequest;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<FoodViewHolder> {

    private Context mContext;
    private List<FoodData> myFoodList;

    public MyAdapter(Context mContext, List<FoodData> myFoodList) {
        this.mContext = mContext;
        this.myFoodList = myFoodList;
    }

    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row_item, parent, false);


        return new FoodViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull final FoodViewHolder holder, final int position) {
        //this glide library is used for showing images from firebase storage with the help of images' path stored in database.
        Glide.with(mContext)
                .load(myFoodList.get(position).getItemImage())
                .into(holder.imageView);
//      holder.imageView.setImageResource(myFoodList.get(position).getItemImage());
        holder.mtitle.setText(myFoodList.get(position).getItemName());
        holder.mDescription.setText(myFoodList.get(position).getItemDescription());
        holder.mType.setText(myFoodList.get(position).getItemType());

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, HomeActivity.class);
                intent.putExtra("Image", myFoodList.get(holder.getAdapterPosition()).getItemImage());
                intent.putExtra("Title", myFoodList.get(holder.getAdapterPosition()).getItemName());
                intent.putExtra("Description", myFoodList.get(holder.getAdapterPosition()).getItemDescription());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myFoodList.size();
    }
}

class FoodViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView mtitle, mDescription, mType;
    CardView mCardView;

    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.ivImage);
        mtitle = itemView.findViewById(R.id.tvTitle);
        mDescription = itemView.findViewById(R.id.tvDescription);
        mType = itemView.findViewById(R.id.tvType);

        mCardView = itemView.findViewById(R.id.myCardView);
    }
}
