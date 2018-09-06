package com.example.mohammad.aaatest.L16_Volloy;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Mohammad on 8/29/2018.
 */

public class AppController extends Application
{

    public static final String TAG = AppController.class.getSimpleName();

    public RequestQueue requestQueue;

    public static AppController mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized AppController getInstance()
    {
        return mInstance;
    }

    public RequestQueue getRequestQueue()
    {
        if (requestQueue == null)
        {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request , String tag)
    {
        request.setTag(TextUtils.isEmpty(tag) ? TAG  : null);
        getRequestQueue().add(request);
    }

    public <T> void addToRequestQueue(Request<T> request )
    {
        request.setTag(TAG);
        getRequestQueue().add(request);
    }


}
