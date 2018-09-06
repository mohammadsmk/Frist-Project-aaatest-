package com.example.mohammad.aaatest.L14_URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mohammad.aaatest.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLOneImg extends AppCompatActivity {
    ImageView img;
    Button btn;
//
//    private InputStream OpenHttpConnection(String urlString) throws
//            IOException {
//        InputStream in = null;
//        int response = -1;
//        URL url = new URL(urlString);
//        URLConnection conn = url.openConnection();
//        if (! (conn instanceof HttpURLConnection))
//            throw new IOException("Not an HTTP Connection");
//        try{
//            HttpURLConnection httpConn = (HttpURLConnection) conn;
//            httpConn.setAllowUserInteraction(false);
//            httpConn.setInstanceFollowRedirects(true);
//            httpConn.setRequestMethod("GET");
//            httpConn.connect();
//            response = httpConn.getResponseCode();
//            if (response == HttpURLConnection.HTTP_OK){
//                in = httpConn.getInputStream();
//            }
//        } catch (Exception ex){
//            Log.d("Networkong" , ex.getLocalizedMessage());
//            throw  new IOException("Error Connection");
//        }
//            return in;
//    }
//
//    private Bitmap DownloadImage(String URL){
//        Bitmap bitmap = null;
//        InputStream in = null;
//        try{
//            in = OpenHttpConnection(URL);
//            bitmap = BitmapFactory.decodeStream(in);
//            in.close();
//        } catch (IOException e) {
//            Log.d("NetworkingActivity" , e.getLocalizedMessage());
//        }
//        return bitmap;
//    }
//
//    private class DownloadImageTask extends AsyncTask<String , Void , Bitmap> {
//
//        @Override
//        protected Bitmap doInBackground(String... urls) {
//            return DownloadImage(urls[0]);
//        }
//
//        protected void onPostExecute(Bitmap result){
//            ImageView img = (ImageView) findViewById(R.id.URLOnePic_pic);
//            img.setImageBitmap(result);
//        }
//    }

    private InputStream OpenHttpConnection (String urlString) throws IOException {
        InputStream in = null;
        int response = -1;

        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();

        try
        {
            HttpURLConnection httpConn = (HttpURLConnection) conn;
            httpConn.setAllowUserInteraction(false);
            httpConn.setInstanceFollowRedirects(true);
            httpConn.setRequestMethod("GET");
            httpConn.connect();
            response = httpConn.getResponseCode();
            if (response == HttpURLConnection.HTTP_OK)
            {
                in = httpConn.getInputStream();
            }
        }
        catch (IOException e)
        {
            e.getLocalizedMessage();
        }
    return in;
    }

    private Bitmap imageDownload (String URL)
    {
        InputStream in = null;
        Bitmap bitmap = null;

        try
        {
            in = OpenHttpConnection(URL);
            bitmap = BitmapFactory.decodeStream(in);
            in.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return bitmap;
    }

    private class imageDownloadTask extends  AsyncTask<String , Void , Bitmap>
    {

        @Override
        protected Bitmap doInBackground(String... params)
        {
            return imageDownload(params[0]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            ImageView img = (ImageView) findViewById(R.id.URLOnePic_pic);
            img.setImageBitmap(bitmap);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urlone_img);

        Button btn = (Button) findViewById(R.id.URLOnePic_Refresh);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new imageDownloadTask().execute("http://aaaaaaa.zohosites.com/B.png");
            }
        });
    }
}
