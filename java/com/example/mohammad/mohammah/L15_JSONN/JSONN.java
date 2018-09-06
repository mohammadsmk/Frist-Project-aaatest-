package com.example.mohammad.aaatest.L15_JSONN;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mohammad.aaatest.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JSONN extends AppCompatActivity
{

    Button btnJson;
    TextView txtResult;


    public String readJsonFeed (String URL)
    {
        StringBuilder stringBuilder = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(URL);

        try
        {
            HttpResponse response = client.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int StatusCode = statusLine.getStatusCode();

            if (StatusCode == 200)
            {
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while ((line = reader.readLine())!= null)
                {
                    stringBuilder.append(line);
                }
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

    public class readJsonFeedTask extends AsyncTask<String , String , String>
    {


        @Override
        protected String doInBackground(String... params) {
            return readJsonFeed(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {

            try
            {
                JSONArray jsonArray =new JSONArray(s);

                for (int i = 0; i <jsonArray.length() ; i++)
                {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    txtResult.append(jsonObject.getString("appeId")+"\n");
                }
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsonn);
        btnJson = (Button) findViewById(R.id.btn_Json_Refresh);
        txtResult = (TextView) findViewById(R.id.txt_Json_text);

        btnJson.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new readJsonFeedTask().execute("http://extjs.org.cn/extjs/examples/grid/survey.html");
//                new readJsonFeedTask().execute("http://mma.000webhostapp.com/mysite/places.json");
            }
        });

    }

}
