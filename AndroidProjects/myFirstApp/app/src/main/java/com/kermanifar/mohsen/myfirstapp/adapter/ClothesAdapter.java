package com.kermanifar.mohsen.myfirstapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kermanifar.mohsen.myfirstapp.R;
import com.kermanifar.mohsen.myfirstapp.datamodel.Cloth;

import java.util.List;

public class ClothesAdapter extends RecyclerView.Adapter<ClothesAdapter.ClothesViewHolder> {

    private Context context;
    private List<Cloth> clothes;

    public ClothesAdapter(Context context, List<Cloth> clothes) {

        this.context = context;
        this.clothes = clothes;
    }


    @NonNull
    @Override
    public ClothesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_botick_item, parent, false);
        return new ClothesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClothesViewHolder holder, int position) {

        Cloth cloth = clothes.get(position);
        holder.imageItem.setImageDrawable(cloth.getImageItem());
        holder.clothTitle.setText(cloth.getTxtTile());
        holder.clothViewCount.setText(String.valueOf(cloth.getViewCount()));

    }

    @Override
    public int getItemCount() {
        return clothes.size();
    }

    public class ClothesViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageItem;
        private TextView clothTitle;
        private TextView clothViewCount;

        public ClothesViewHolder(@NonNull View itemView) {
            super(itemView);

            imageItem = itemView.findViewById(R.id.image_item);
            clothTitle = itemView.findViewById(R.id.txt_title);
            clothViewCount = itemView.findViewById(R.id.txt_view);


        }
    }
}
