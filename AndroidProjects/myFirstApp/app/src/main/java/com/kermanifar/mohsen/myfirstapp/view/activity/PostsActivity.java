package com.kermanifar.mohsen.myfirstapp.view.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.kermanifar.mohsen.myfirstapp.DownloadImageTask;
import com.kermanifar.mohsen.myfirstapp.network.ApiServices;
import com.kermanifar.mohsen.myfirstapp.savingdatas.SevenLearnDatabaseOpenHelper;
import com.kermanifar.mohsen.myfirstapp.adapter.PostsAdapter;
import com.kermanifar.mohsen.myfirstapp.R;
import com.kermanifar.mohsen.myfirstapp.datamodel.Post;

import java.util.ArrayList;
import java.util.List;

public class PostsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Post> posts = new ArrayList<>();

    private static final int CODE_PERMISION = 200;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);


        ApiServices apiServices = new ApiServices(PostsActivity.this);

        setRecycler();
        getDataFromDatabaseSqlite();

        apiServices.getPosts(new ApiServices.onPostsReceived() {
            @Override
            public void onReceived(List<Post> posts) {
                if (posts != null) {
                    PostsActivity.this.posts = posts;
                    SevenLearnDatabaseOpenHelper sevenLearnDatabaseOpenHelper = new SevenLearnDatabaseOpenHelper(PostsActivity.this);
                    //sevenLearnDatabaseOpenHelper.addPosts(posts);


                    PostsAdapter postsAdapter = new PostsAdapter(PostsActivity.this, posts);
                    recyclerView.setAdapter(postsAdapter);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                            saveImageInSdCard();
                        } else {
                            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, CODE_PERMISION);
                        }
                    } else {
                        saveImageInSdCard();
                    }

                } else {
                    Toast.makeText(PostsActivity.this, "اطلاعات ارسال نمی شود .", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        setView();


      }

//    private void setView() {
//        setRecycler();
//    }
//
    private void setRecycler() {
        recyclerView = findViewById(R.id.post_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(PostsActivity.this, LinearLayoutManager.VERTICAL, false));
    }
    private void getDataFromDatabaseSqlite() {
        SevenLearnDatabaseOpenHelper openHelper = new SevenLearnDatabaseOpenHelper(this);
        List<Post> posts = openHelper.getPosts();
        PostsAdapter postsAdapter = new PostsAdapter(this, posts);
        recyclerView.setAdapter(postsAdapter);
    }

    private void saveImageInSdCard() {
        List<String> urls = new ArrayList<>();

        for (int i = 0; i < posts.size(); i++) {
            urls.add(posts.get(i).getPostImageUrl().replace("127.0.0.1:8080", "192.168.1.3:8080"));
        }
        DownloadImageTask downloadImageTask = new DownloadImageTask(this, urls);
        downloadImageTask.execute();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == CODE_PERMISION) {
            if (grantResults.length > 0) {
                saveImageInSdCard();
            }else {
                Toast.makeText(this,"برای ذخیره سازی باید دسترسی لازم را بدهید.",Toast.LENGTH_LONG).show();
            }
        }
    }
}

