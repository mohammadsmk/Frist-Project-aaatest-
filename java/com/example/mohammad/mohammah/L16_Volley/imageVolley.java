package com.example.mohammad.aaatest.L16_Volloy;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.example.mohammad.aaatest.R;

public class imageVolley extends AppCompatActivity
{

    ImageView img;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_volley);

        img =(ImageView) findViewById(R.id.imageVolley_image);
        btn = (Button) findViewById(R.id.imageVolley_button);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                RequestImage();
            }
        });
    }

    private void RequestImage()
    {
        String url = "http://wiadevelopers.ir/api/volley/wiadevelopers.png";

        final ProgressDialog mDialog;
        mDialog = new ProgressDialog(this);
        mDialog.setMessage("Loading");
        mDialog.setCancelable(false);
        mDialog.show();

        Response.Listener<Bitmap> listener = new Response.Listener<Bitmap>()
        {
            @Override
            public void onResponse(Bitmap response)
            {
                img.setImageBitmap(response);
                mDialog.dismiss();
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(imageVolley.this, "ERROR", Toast.LENGTH_SHORT).show();
                mDialog.dismiss();
            }
        };
        ImageRequest req = new ImageRequest(url ,listener , 0 ,0 ,null , null ,errorListener);
        AppController.getInstance().addToRequestQueue(req);
    }
}
