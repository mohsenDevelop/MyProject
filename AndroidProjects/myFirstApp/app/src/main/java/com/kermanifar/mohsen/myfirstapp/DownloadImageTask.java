package com.kermanifar.mohsen.myfirstapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.widget.LinearSmoothScroller;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DownloadImageTask extends AsyncTask<Long, Integer, String> {

    private Context context;
    private List<String> urls = new ArrayList<>();

    private ProgressDialog progressDialog;
    public DownloadImageTask(Context context, String url) {
        urls.add(url);
        this.context = context;
    }
    public DownloadImageTask(Context context, List<String> urls) {
        this.context = context;
        this.urls = urls;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("درحال ذخیره سازی.");
        progressDialog.setMessage("درحال ذخیره سازی عکس ها .");
        progressDialog.setIndeterminate(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();
    }
    @Override
    protected String doInBackground(Long... longs) {
        for (int i = 0; i < urls.size() ; i++) {

            try {
                Bitmap bitmap =  Picasso.get().load(urls.get(i)).get();

                String url = urls.get(i);

                File imgDirExt = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                String imgName = url.substring(url.lastIndexOf("/") + 1, url.length());

                File imageFile = new File(imgDirExt, imgName);
                FileOutputStream fos = new FileOutputStream(imageFile);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);

                fos.flush();
                fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            publishProgress((i * 100) / urls.size());

        }

        return null;
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        progressDialog.hide();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressDialog.setProgress(values[0]);
    }
}
