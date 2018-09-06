package com.example.mohammad.aaatest.L1_Basic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.mohammad.aaatest.R;

public class SecondActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tv = (TextView) findViewById(R.id.TextView);

        Bundle Extras = getIntent().getExtras();
        if (Extras != null){
            String name = "";
            String phone = "";
            String email = "";
            if (Extras.containsKey("name")){
                name = Extras.getString("name");
            }
            if (Extras.containsKey("phone")){
                phone = Extras.getString("phone");
            }
            if (Extras.containsKey("email")){
                email = Extras.getString("email");
            }
            tv.setText("name :"+name + "\n");
            tv.append("phone : "+phone +"\n");
            tv.append("email :" + email +"\n");


        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id  == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem item = menu.add("Ok");
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                setResult(RESULT_OK);
                finish();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
