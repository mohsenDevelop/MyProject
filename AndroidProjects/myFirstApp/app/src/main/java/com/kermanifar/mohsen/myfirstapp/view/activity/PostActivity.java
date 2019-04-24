package com.kermanifar.mohsen.myfirstapp.view.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.kermanifar.mohsen.myfirstapp.R;
import com.kermanifar.mohsen.myfirstapp.savingdatas.SevenLearnDatabaseOpenHelper;
import com.squareup.picasso.Picasso;

public class PostActivity extends AppCompatActivity {
    ImageView postImageView;
    TextView titleTextView, contentTextView, dateTextView;
    Typeface typeface1, typeface2, typeface3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        setUpFonts();
        setUpView();
        gettingPost();
    }

    private void setUpView() {
        postImageView = findViewById(R.id.post_image);
        titleTextView = findViewById(R.id.post_title);
        contentTextView = findViewById(R.id.post_content);
        dateTextView = findViewById(R.id.post_date);
    }

    private void gettingPost() {
        Intent intent = getIntent();

        int id = intent.getIntExtra(SevenLearnDatabaseOpenHelper.COL_ID, 0);
        postVisited(id);

        String postImageUrl = intent.getStringExtra(SevenLearnDatabaseOpenHelper.COL_IMAGE_URL);
        String postTitle = intent.getStringExtra(SevenLearnDatabaseOpenHelper.COL_TITLE);
        String postContent = intent.getStringExtra(SevenLearnDatabaseOpenHelper.COL_CONTENT);
        String postDate = intent.getStringExtra(SevenLearnDatabaseOpenHelper.COL_DATE);

        Picasso.get().load(postImageUrl.replace("127.0.0.1:8080", "192.168.1.3:8080")).into(postImageView);
        titleTextView.setText(postTitle);
        contentTextView.setText(postContent);
        dateTextView.setText(postDate);

        titleTextView.setTypeface(typeface3);
        contentTextView.setTypeface(typeface1);
        dateTextView.setTypeface(typeface2);
    }

    private void setUpFonts() {
        typeface1 = Typeface.createFromAsset(getAssets(), "fonts/IRANSansMobile_Medium.ttf");
        typeface2  = Typeface.createFromAsset(getAssets(), "fonts/IRANSansMobile_Light.ttf");
        typeface3  = Typeface.createFromAsset(getAssets(), "fonts/IRANSansMobile_Bold.ttf");
    }

    private void postVisited(int postId) {
        SevenLearnDatabaseOpenHelper openHelper = new SevenLearnDatabaseOpenHelper(this);
        openHelper.setPostIsVisited(postId, 1);
    }
}
