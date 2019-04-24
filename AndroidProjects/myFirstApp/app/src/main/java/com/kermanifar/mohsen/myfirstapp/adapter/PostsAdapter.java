package com.kermanifar.mohsen.myfirstapp.adapter;


import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kermanifar.mohsen.myfirstapp.view.activity.PostActivity;
import com.kermanifar.mohsen.myfirstapp.R;
import com.kermanifar.mohsen.myfirstapp.savingdatas.SevenLearnDatabaseOpenHelper;
import com.kermanifar.mohsen.myfirstapp.datamodel.Post;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostHolder> {

    private Context context;
    private List<Post> posts;

    public PostsAdapter(Context context, List<Post> posts) {

        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_posts, parent, false);
        Typeface typeface1  = Typeface.createFromAsset(context.getAssets(), "fonts/IRANSansMobile_Medium.ttf");
        Typeface typeface2  = Typeface.createFromAsset(context.getAssets(), "fonts/IRANSansMobile_Light.ttf");
        Typeface typeface3  = Typeface.createFromAsset(context.getAssets(), "fonts/IRANSansMobile_Bold.ttf");
        return new PostHolder(view, typeface1, typeface2, typeface3);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        final Post post=  posts.get(position);
        Picasso.get().load(post.getPostImageUrl().replace("127.0.0.1:8080", "192.168.1.3:8080")).into(holder.postImage);
        holder.postTitle.setText(post.getPostTitle());
        holder.postContent.setText(post.getPostContent());
        holder.postDate.setText(post.getPostDate());

        if (post.getIs_visited() == 1) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.color_post_visited));
        }else  {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.color_post_not_visited));

        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PostActivity.class);
                intent.putExtra(SevenLearnDatabaseOpenHelper.COL_ID, post.getPostId());
                intent.putExtra(SevenLearnDatabaseOpenHelper.COL_TITLE, post.getPostTitle());
                intent.putExtra(SevenLearnDatabaseOpenHelper.COL_CONTENT, post.getPostContent());
                intent.putExtra(SevenLearnDatabaseOpenHelper.COL_IMAGE_URL, post.getPostImageUrl());
                intent.putExtra(SevenLearnDatabaseOpenHelper.COL_IS_VISITED, post.getIs_visited());
                intent.putExtra(SevenLearnDatabaseOpenHelper.COL_DATE, post.getPostDate());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }


    public class PostHolder extends RecyclerView.ViewHolder {

        private ImageView postImage;
        private TextView postTitle;
        private TextView postContent;
        private TextView postDate;

        public PostHolder(@NonNull View itemView, Typeface typeface1, Typeface typeface2,  Typeface typeface3) {
            super(itemView);

            postImage = itemView.findViewById(R.id.post_image);
            postTitle = itemView.findViewById(R.id.post_title);
            postTitle.setTypeface(typeface3);

            postContent = itemView.findViewById(R.id.post_content);
            postContent.setTypeface(typeface1);

            postDate = itemView.findViewById(R.id.post_date);
            postDate.setTypeface(typeface2);
        }
    }
}
