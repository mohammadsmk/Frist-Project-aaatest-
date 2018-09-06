package com.example.mohammad.aaatest.L16_Volloy;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.mohammad.aaatest.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonRequest extends AppCompatActivity {

    Button btnOjectRequest , btnArrayRequest;

    ListView lstContact;

    ArrayList<Contact> contacts = new ArrayList<>();

    CustomAdapter customAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_request);

        btnOjectRequest = (Button) findViewById(R.id.Json_Obeject_Request);
        btnArrayRequest = (Button) findViewById(R.id.Json_Array_Request);

        lstContact = (ListView) findViewById(R.id.ListView_JsonRequest);

        customAdapter = new CustomAdapter(getApplicationContext() , contacts);
        lstContact.setAdapter(customAdapter);
        lstContact.setVisibility(View.GONE);

        btnOjectRequest.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                contacts.clear();
                OjectRequest();
            }
        });

        btnArrayRequest.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                contacts.clear();
                ArrayRequest();
            }
        });
    }

    private void ArrayRequest()
    {
//        String url = "http://wiadevelopers.ir/api/volley/contactJsonArray.json";
//       String url = "http://mma.000webhostapp.com/mysite/places.json";
       String url = "http://mehrdadsmk.000webhostapp.com/mysite/arraytest.json";




        final ProgressDialog mDialog;
        mDialog = new ProgressDialog(this);
        mDialog.setMessage("Loading");
        mDialog.setCancelable(false);
        mDialog.show();

        Response.Listener<JSONArray> listener = new Response.Listener<JSONArray>()
        {
            @Override
            public void onResponse(JSONArray response)
            {
                try
                {
                    for (int i = 0; i < response.length() ; i++)
                    {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String mName = jsonObject.getString("appeId");
                        String mPhone = jsonObject.getString("survId");
                        String mEmail = jsonObject.getString("location");

                        contacts.add(new Contact(mName , mPhone , mEmail));
                    }
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }

                ((BaseAdapter) lstContact.getAdapter()).notifyDataSetChanged();
                lstContact.setVisibility(View.VISIBLE);
                mDialog.dismiss();
            }
        };
        Response.ErrorListener errorListener = new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(JsonRequest.this, "ERROR", Toast.LENGTH_SHORT).show();
                mDialog.dismiss();
            }
        };

        JsonArrayRequest req = new JsonArrayRequest(Request.Method.GET , url ,null , listener ,errorListener);
        AppController.getInstance().addToRequestQueue(req);
    }

    private void OjectRequest()
    {
//        String url = "http://wiadevelopers.ir/api/volley/contactJsonObject.json";
//        String url = "https://mehrdadsmk.000webhostapp.com/test.json";
       String url = "http://mehrdadsmk.000webhostapp.com/mysite/places.json";

        final ProgressDialog mDialog;
        mDialog = new ProgressDialog(this);
        mDialog.setMessage("Loading");
        mDialog.setCancelable(false);
        mDialog.show();

        Response.Listener<JSONObject> listener = new Response.Listener<JSONObject>()
        {
            @Override
            public void onResponse(JSONObject response)
            {
                try
                {

                    String mName = response.getString("name");
                    String mPhone = response.getString("messages");
                    String mEmail = response.getString("age");

                    contacts.add(new Contact(mName ,mPhone , mEmail));
                    ((BaseAdapter) lstContact.getAdapter()).notifyDataSetChanged();
                    lstContact.setVisibility(View.VISIBLE);
                    mDialog.dismiss();


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        Response.ErrorListener errorListener = new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(JsonRequest.this, "ERROR", Toast.LENGTH_SHORT).show();
                mDialog.dismiss();
            }
        };

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET , url ,null,listener,errorListener);
        AppController.getInstance().addToRequestQueue(req);
    }

}
