package com.kermanifar.mohsen.myfirstapp;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;


import com.kermanifar.mohsen.myfirstapp.datamodel.Post;
import com.kermanifar.mohsen.myfirstapp.savingdatas.SevenLearnDatabaseOpenHelper;

import java.util.List;

public class PostAsynTask extends AsyncTask<Long, Integer, String> {
    private static final String TAG = "PostAsynTask";

    private List<Post> posts;
    private SevenLearnDatabaseOpenHelper openHelper;
    private Context context;
    private ProgressDialog progressBar;

    public PostAsynTask(List<Post> posts, SevenLearnDatabaseOpenHelper openHelper, Context context) {
        this.posts = posts;
        this.openHelper = openHelper;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

       progressBar = new ProgressDialog(context);
       progressBar.setTitle("درحال ذخیره سازی ...");
       progressBar.setMessage("درحال ذخیره سازی پست ها ، لطفا صبر نمایید ...");
       progressBar.setIndeterminate(false);
       progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
       progressBar.show();
    }
    @Override
    protected String doInBackground(Long... voids) {

        for (int i = 0; i < posts.size(); i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Post post = posts.get(i);
            ContentValues cv = new ContentValues();
            cv.put(openHelper.COL_ID, post.getPostId());
            cv.put(openHelper.COL_TITLE, post.getPostTitle());
            cv.put(openHelper.COL_CONTENT, post.getPostContent());
            cv.put(openHelper.COL_IMAGE_URL, post.getPostImageUrl());
            cv.put(openHelper.COL_IS_VISITED, post.getIs_visited());
            cv.put(openHelper.COL_DATE, post.getPostDate());

            SQLiteDatabase sqLiteDatabase = openHelper.getWritableDatabase();
            long isInserted = sqLiteDatabase.insert(openHelper.POST_TABLE_NAME, null, cv);
            Log.i(TAG, "addPost: " + isInserted);

            publishProgress((i * 100) / posts.size());

        }
        return null;
    }


    @Override
    protected void onPostExecute(String aVoid) {
        super.onPostExecute(aVoid);
        progressBar.hide();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressBar.setProgress(values[0]);
    }
}
