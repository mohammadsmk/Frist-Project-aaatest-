package com.example.mohammad.aaatest.L14_URL;

import android.graphics.Path;
import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohammad.aaatest.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLTotalText extends AppCompatActivity {

//    private InputStream OpenHttpConnection (String urlString) throws IOException
//    {
//        InputStream in = null;
//        int response = -1;
//
//        URL url = new URL(urlString);
//        URLConnection conn = url.openConnection();
//
//        try
//        {
//            HttpURLConnection httpConn = (HttpURLConnection) conn;
//            httpConn.setAllowUserInteraction(false);
//            httpConn.setInstanceFollowRedirects(true);
//            httpConn.setRequestMethod("GET");
//            httpConn.connect();
//
//            response = httpConn.getResponseCode();
//
//            if (response == HttpURLConnection.HTTP_OK){
//                in = httpConn.getInputStream();
//            }
//
//        }
//        catch (IOException e)
//        {
//            e.getLocalizedMessage();
//        }
//        return in;
//    }
//
//    private String DownloadText(String URL) {
//        int BUFFER_SIZE = 2111;
//        InputStream in = null;
//        try {
//            in = OpenHttpConnection(URL);
//        } catch (IOException e) {
//            Log.d("Networking", e.getLocalizedMessage());
//            return "";
//        }
//        InputStreamReader isr = new InputStreamReader(in);
//        int charRead;
//        String str = "";
//        char[] inputBuffer = new char[BUFFER_SIZE];
//        try {
//            while ((charRead = isr.read(inputBuffer)) > 0) {
//// ---convert the chars to a String---
//                String readString = String
//                        .copyValueOf(inputBuffer, 0, charRead);
//                str += readString;
//                inputBuffer = new char[BUFFER_SIZE];
//            }
//            in.close();
//        } catch (IOException e) {
//            Log.d("Networking", e.getLocalizedMessage());
//            return "";
//        }
//        return str;
//    }
//    private class DownloadTextTask extends AsyncTask<String, Void, String>
//    {
//        protected String doInBackground(String... urls) {
//            return DownloadText(urls[0]);
//        }
//        @Override
//        protected void onPostExecute(String result) {
//            TextView txt = (TextView) findViewById(R.id.URLText_text);
//           txt.setText(result);
//
//        }
//    }



    private  InputStream OpenHttpConnection(String urlString) throws IOException {
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

    private String DownloadText (String URL)
    {
        InputStream in = null;
        int Buffer_Size = 2000;

        try
        {
            in = OpenHttpConnection(URL);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        InputStreamReader isr = new InputStreamReader(in);
        int charRead;
        char[] Input_Buffer =new char[Buffer_Size];
        String str = "";
        try {
            while ((charRead = isr.read(Input_Buffer))>0)
            {
                String ReadString = String.valueOf(Input_Buffer , 0 , charRead);
                str += ReadString;
                Input_Buffer = new char[Buffer_Size];
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    private class DownloadTextTask extends AsyncTask<String , String , String>
    {

        @Override
        protected String doInBackground(String... params) {
            return DownloadText(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            TextView txt = (TextView) findViewById(R.id.URLText_text);
            txt.setText(s);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urltotal_text);
        Button btn = (Button) findViewById(R.id.URLTotalText_Button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownloadTextTask().execute("http://wiadevelopers.ir/api/volley/stringRequest.php");
            }
        });
    }
}
