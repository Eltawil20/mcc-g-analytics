package com.example.homework2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    Context context;
    List<ProductModel> ProductModelList;

    public ProductAdapter(Context context, List<ProductModel> ProductModelList) {
        this.context = context;
        this.ProductModelList = ProductModelList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        ProductModel productModel = ProductModelList.get(position);
        holder.name.setText(productModel.getName());
        holder.imageView.setImageResource(context.getResources().getIdentifier(productModel.getImage(), "drawable", context.getPackageName()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Deatil.class);
                intent.putExtra("id", productModel.getId());
                intent.putExtra("name", productModel.getName());
                intent.putExtra("image", productModel.getImage());
                intent.putExtra("deatil", productModel.getDetail());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return ProductModelList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        CircleImageView imageView;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.circleImageView);

        }
    }
}
