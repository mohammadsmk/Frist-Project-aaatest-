package com.example.mohammad.aaatest.L1_Basic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.mohammad.aaatest.R;

public class FormInfo extends AppCompatActivity {

    public  static  final  int REQ_CODE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final ShowInfo show = new ShowInfo(this , R.id.forminfo);
        show.getSubmit().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = show.getName().getText().toString().trim();
                String phone = show.getPhone().getText().toString().trim();
                String email = show.getEmail().getText().toString().trim();

                if (show.isValidInput(name , phone , email)){
                    Intent intent = new Intent(FormInfo.this , SecondActivity.class);
                        intent.putExtra("name" , name);
                        intent.putExtra("email" , email);
                            if (show.getShare().isChecked()){
                                intent.putExtra("phone",phone);
                            }
                    startActivityForResult(intent, REQ_CODE);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQ_CODE && resultCode==RESULT_OK){
            Toast.makeText(this, "Confrmied", Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id  == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
