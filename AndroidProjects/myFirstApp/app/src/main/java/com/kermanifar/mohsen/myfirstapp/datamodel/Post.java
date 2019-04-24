package com.kermanifar.mohsen.myfirstapp.datamodel;

import android.graphics.drawable.Drawable;

public class Post  {

    private int PostId;
    private String postImageUrl;
    private String postTitle;
    private String postContent;
    private String postDate;
    private int is_visited = 0;

    public int getPostId() {
        return PostId;
    }

    public void setPostId(int postId) {
        PostId = postId;
    }

    public String getPostImageUrl() {
        return postImageUrl;
    }

    public void setPostImageUrl(String postImage) {
        this.postImageUrl = postImage;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public int getIs_visited() {
        return is_visited;
    }

    public void setIs_visited(int is_visited) {
        this.is_visited = is_visited;
    }
}
