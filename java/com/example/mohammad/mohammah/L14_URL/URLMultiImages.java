package com.example.mohammad.aaatest.L14_URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Path;
import android.os.AsyncTask;
import android.support.v4.content.Loader;
import android.support.v4.view.InputDeviceCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mohammad.aaatest.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLMultiImages extends AppCompatActivity {


//
//    private InputStream OpenHttpConnection(String urlString) throws IOException {
//        InputStream in = null;
//        int response = -1;
//
//        URL url = new URL(urlString);
//        URLConnection conn = url.openConnection();
//
//        try
//        {
//            HttpURLConnection httpConn = (HttpURLConnection) conn;
//            httpConn.setInstanceFollowRedirects(true);
//            httpConn.setAllowUserInteraction(false);
//            httpConn.setRequestMethod("GET");
//            httpConn.connect();
//
//            response = httpConn.getResponseCode();
//
//            if(response == HttpURLConnection.HTTP_OK)
//            {
//                in = httpConn.getInputStream();
//            }
//        }catch (IOException e)
//        {
//            e.getLocalizedMessage();
//        }
//        return in;
//    }
//
//
//    private Bitmap DownloadImage(String URL)
//    {
//        Bitmap bitmap = null;
//        InputStream in = null;
//
//        try{
//            in = OpenHttpConnection(URL);
//            bitmap = BitmapFactory.decodeStream(in);
//            in.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return bitmap;
//    }
//
//    private class DownloadImageTask extends AsyncTask<String , Bitmap , Long>
//    {
//
//        @Override
//        protected Long doInBackground(String... params) {
//            long imageCount = 0;
//            for (int i = 0; i <params.length ; i++) {
//                Bitmap Downloaded = DownloadImage(params[i]);
//                if(Downloaded != null){
//                    imageCount++;
//                }
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                publishProgress(Downloaded);
//            }
//            return imageCount;
//        }
//
//        @Override
//        protected void onProgressUpdate(Bitmap... values) {
//            ImageView img = (ImageView) findViewById(R.id.URLMULTI_Image);
//            img.setImageBitmap(values[0]);
//        }
//
//        @Override
//        protected void onPostExecute(Long aLong) {
//            Toast.makeText(URLMultiImages.this, "Downloaded" + aLong,  Toast.LENGTH_SHORT).show();
//        }
//    }



    private InputStream OpenHttpConnection(String urlString) throws IOException {
        InputStream in = null;
        int Response = -1;

        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();

        try
        {
            HttpURLConnection httpConn = (HttpURLConnection) conn;
            httpConn.setAllowUserInteraction(false);
            httpConn.setInstanceFollowRedirects(true);
            httpConn.setRequestMethod("GET");
            httpConn.connect();
            Response = httpConn.getResponseCode();

            if (Response == HttpURLConnection.HTTP_OK)
            {
                in = httpConn.getInputStream();
            }

        }catch (IOException e)
        {
            e.getLocalizedMessage();
        }
        return in;
    }


    private Bitmap DownloadImages (String URL)
    {
        InputStream in = null;
        Bitmap bitmap = null;

        try
        {
            in = OpenHttpConnection(URL);
            bitmap = BitmapFactory.decodeStream(in);
                    in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    private class DownloadImagesTask extends AsyncTask<String , Bitmap , Long>
    {

        @Override
        protected Long doInBackground(String... params)
        {
            long imageCount = 0;

            for (int i = 0; i < params.length; i++)
            {
                Bitmap imageDownloaded = DownloadImages(params[i]);
                if (imageDownloaded != null) {
                    imageCount++;
                }
                try
                {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(imageDownloaded);
            }
            return imageCount;
        }

        @Override
        protected void onProgressUpdate(Bitmap... values) {
            ImageView img = (ImageView) findViewById(R.id.URLMULTI_Image);
            img.setImageBitmap(values[0]);
        }

        @Override
        protected void onPostExecute(Long aLong) {
            Toast.makeText(URLMultiImages.this, "Download" + aLong + "images", Toast.LENGTH_SHORT).show();
        }
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urlmulti_images);

        Button btn = (Button) findViewById(R.id.URLMULTI_Button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownloadImagesTask().execute(
                        "http://bdfjade.com/data/out/89/5941587-natural-image-download.jpg",
                        "http://files.all-free-download.com//downloadfiles/wallpapers/2560_1024/green_nature_dual_monitor_7677.jpg",
                        "http://wall2born.com/data/out/610/image-46024483-natural-image-download.png",
                        "https://traveltofranceandmore.com/wp-content/uploads/2018/07/the-best-nature-wallpaper-elegant-nacher-wallpaper-full-hd-all-wallpapers-pinterest-of-the-best-nature-wallpaper.jpg"
                );
            }
        });


    }
}
