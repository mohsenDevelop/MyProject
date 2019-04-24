package com.kermanifar.mohsen.myfirstapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.kermanifar.mohsen.myfirstapp.R;
import com.kermanifar.mohsen.myfirstapp.datamodel.AppFeature;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AppFeaturesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<AppFeature> appFeatureList = new ArrayList<>();

    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_APP_FEATURE = 1;

    private Typeface typeface;
    public AppFeaturesAdapter(Context context, List<AppFeature> appFeatures) {
        this.context = context;
        this.appFeatureList = appFeatures;
        typeface = Typeface.createFromAsset(context.getAssets(), "fonts/IRANSansMobile_Medium.ttf");

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_HEADER:
                View view = LayoutInflater.from(context).inflate(R.layout.layout_appfeature_header, parent, false);
                return new AppFeatureBanner(view , typeface);
            case VIEW_TYPE_APP_FEATURE:
                view = LayoutInflater.from(context).inflate(R.layout.layout_app_feature, parent, false);
                return new AppFeatureViewHolder(view, typeface);
            default:
                return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof AppFeatureViewHolder) {
            AppFeatureViewHolder viewHolder = (AppFeatureViewHolder)holder;
            viewHolder.binAppFeature(appFeatureList.get(position - 1));
        }

    }

    @Override
    public int getItemCount() {
        return appFeatureList.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
       if (position == 0) {
           return VIEW_TYPE_HEADER;
       }else {
           return VIEW_TYPE_APP_FEATURE;
       }
    }

    public static class AppFeatureViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageFeature;
        private TextView captionFeature;

        public AppFeatureViewHolder(@NonNull View itemView, Typeface typeface) {
            super(itemView);

            imageFeature = itemView.findViewById(R.id.image_feature);
            captionFeature = itemView.findViewById(R.id.text_view_feature);
            captionFeature.setTypeface(typeface);
        }

        public void binAppFeature(final AppFeature appFeature) {
            Picasso.get().load(appFeature.getImageFeature()).into(imageFeature);
            captionFeature.setText(appFeature.getCaption());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemView.getContext().startActivity(new Intent(itemView.getContext(), appFeature.getDestinationActivity()));
                }
            });
        }
    }

    public static class AppFeatureBanner extends RecyclerView.ViewHolder{
        private TextView appFeaturesLabel;
        public AppFeatureBanner(View itemView,Typeface typeface) {
            super(itemView);
            appFeaturesLabel = itemView.findViewById(R.id.lbl_app_feature_lst);
            appFeaturesLabel.setTypeface(typeface);
        }
    }
}
