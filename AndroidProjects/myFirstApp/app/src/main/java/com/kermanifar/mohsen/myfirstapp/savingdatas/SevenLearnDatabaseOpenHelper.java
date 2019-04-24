package com.kermanifar.mohsen.myfirstapp.savingdatas;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.kermanifar.mohsen.myfirstapp.PostAsynTask;
import com.kermanifar.mohsen.myfirstapp.datamodel.Post;

import java.util.ArrayList;
import java.util.List;

public class SevenLearnDatabaseOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = "SevenLearnDatabaseOpenH";

    private static final String DATA_BASE_NAME = "db_7learn_id";
    private static final int DATABASE_VERSION = 1;
    public static final String POST_TABLE_NAME = "tbl_posts";

    public static final String COL_ID = "post_id";
    public static final String COL_TITLE = "post_title";
    public static final String COL_CONTENT = "post_content";
    public static final String COL_IMAGE_URL = "post_image_url";
    public static final String COL_IS_VISITED = "post_is_visited";
    public static final String COL_DATE = "post_date";

    private static final String SQL_COMMAND_CREATE_DATABASE = "CREATE TABLE IF NOT EXISTS "+POST_TABLE_NAME+"("+
            COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            COL_TITLE + " TEXT, "+
            COL_CONTENT + " TEXT, "+
            COL_IMAGE_URL +" TEXT, "+
            COL_IS_VISITED + " INTEGER DEFAULT 0, "+
            COL_DATE + " TEXT);";



    Context context;
    public SevenLearnDatabaseOpenHelper(Context context) {
        super(context, DATA_BASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(SQL_COMMAND_CREATE_DATABASE);
        }catch (SQLException e) {
            Log.e(TAG, "onCreate: " + e.toString() );
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }



    public void addPosts(List<Post> posts) {
       PostAsynTask postAsynTask = new PostAsynTask(posts, this, context);
       postAsynTask.execute();
    }

    public List<Post> getPosts() {
        List<Post> posts = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+ POST_TABLE_NAME, null);

        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            while (!cursor.isAfterLast()) {
                Post post = new Post();
                post.setPostId(cursor.getInt(0));
                post.setPostTitle(cursor.getString(1));
                post.setPostContent(cursor.getString(2));
                post.setPostImageUrl(cursor.getString(3));
                post.setIs_visited(cursor.getInt(4));
                post.setPostDate(cursor.getString(5));
                posts.add(post);
                cursor.moveToNext();
            }
        }

        cursor.close();
        sqLiteDatabase.close();
        return posts;
    }

    public void setPostIsVisited(int postId, int isVisited) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_IS_VISITED, isVisited);

        int rowAffected =  sqLiteDatabase.update(POST_TABLE_NAME, cv, COL_ID + " = ?", new String[] {String.valueOf(postId)});
        Log.i(TAG, "setPostIsVisited: id is "+ postId +"  rowAffected =>" + rowAffected);
    }

    private boolean checkPostId(int postId) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor =  sqLiteDatabase.rawQuery("SELECT * FROM " + POST_TABLE_NAME + " WHERE " + COL_ID + " = ?" , new String[] {String.valueOf(postId)});
        return cursor.moveToFirst();
    }
}
