package com.example.mohammad.aaatest.L16_Volloy;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.mohammad.aaatest.R;

public class StringRequest extends AppCompatActivity
{
    Button btn;
    TextView txtResult;
    CardView cdrRequestString;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_request);

        btn = (Button) findViewById(R.id.btn_StringRequest);
        cdrRequestString = (CardView) findViewById(R.id.crd_StringRequest);
        txtResult = (TextView) findViewById(R.id.txtResult_StringRequest);
        cdrRequestString.setVisibility(View.GONE);


        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                requestStringRequest();
            }
        });



    }

    private void requestStringRequest()
    {

        String url = "http://wiadevelopers.ir/api/volley/stringRequest.php";

        final ProgressDialog mDialog;
        mDialog = new ProgressDialog(this);
        mDialog.setMessage("Loading");
        mDialog.setCancelable(false);
        mDialog.show();

        Response.Listener<String> listener = new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                txtResult.setText(response);
                cdrRequestString.setVisibility(View.VISIBLE);
                mDialog.dismiss();
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(StringRequest.this, "ERROR", Toast.LENGTH_SHORT).show();
                mDialog.dismiss();
            }
        };

        com.android.volley.toolbox.StringRequest req = new com.android.volley.toolbox.StringRequest(Request.Method.GET , url ,listener , errorListener);
        AppController.getInstance().addToRequestQueue(req);
    }
}
