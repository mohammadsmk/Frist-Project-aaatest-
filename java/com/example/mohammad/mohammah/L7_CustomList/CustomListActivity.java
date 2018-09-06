package com.example.mohammad.aaatest.L7_CustomList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.mohammad.aaatest.R;

import java.util.ArrayList;
import java.util.List;

//public class CustomListActivity extends AppCompatActivity {
//
//    List<MyContact> contacts;
//    ContactAdapter adapter;
//
//    ListView listView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_custom_list);
//
//        listView = (ListView) findViewById(R.id.listview);
//        contacts = new ArrayList<>();
//        Data();
//        Refresh();
//    }
//
//    private void Data() {
//        addFakeContact(2);
//        contacts.add(new MyContact("Ali HasanZadeh" , "09123456789" , R.drawable.back));
//        contacts.add(new MyContact("Ali Zamani" , "091237986789" , R.drawable.ic1));
//        addFakeContact(2);
//        contacts.add(new MyContact("Ali HasanZadeh" , "09123456789" , R.drawable.pic1));
//        contacts.add(new MyContact("Ali Zamani" , "091237986789" , R.drawable.logo));
//        addFakeContact(2);
//        contacts.add(new MyContact("Ali HasanZadeh" , "09123456789" , R.drawable.back));
//        contacts.add(new MyContact("Ali Zamani" , "091237986789" , R.drawable.ic1));
//        addFakeContact(2);
//        contacts.add(new MyContact("Ali HasanZadeh" , "09123456789" , R.drawable.pic1));
//        contacts.add(new MyContact("Ali Zamani" , "091237986789" , R.drawable.logo));
//        addFakeContact(2);
//        contacts.add(new MyContact("Ali HasanZadeh" , "09123456789" , R.drawable.back));
//        contacts.add(new MyContact("Ali Zamani" , "091237986789" , R.drawable.ic1));
//        addFakeContact(2);
//        contacts.add(new MyContact("Ali HasanZadeh" , "09123456789" , R.drawable.pic1));
//        contacts.add(new MyContact("Ali Zamani" , "091237986789" , R.drawable.logo));
//
//    }
//
//    private void addFakeContact(int n) {
//        for (int i = 0; i < n; i++) {
//            contacts.add(new MyContact("Ali HasanZadeh"+i , "0912345678"+i , 0));
//        }
//
//    }
//    private void Refresh(){
//        adapter = new ContactAdapter(this , contacts);
//        listView.setAdapter(adapter);
//    }
//
//}
public class CustomListActivity extends AppCompatActivity {

    List<MyContact> contacts;
    ContactAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        listView = (ListView) findViewById(R.id.listview);

        contacts = new ArrayList<>();

        Data();
        Refresh();


    }

    private void Refresh() {
        adapter = new ContactAdapter(this , contacts);
        listView.setAdapter(adapter);
    }

    private void Data() {
        FakeContact(3);
        contacts.add(new MyContact("Ali" , "09" , R.drawable.red));
        FakeContact(3);
        contacts.add(new MyContact("Hassan" , "09" , R.drawable.yellow));
        FakeContact(3);
        contacts.add(new MyContact("Ali" , "09" , R.drawable.red));
        FakeContact(3);
        contacts.add(new MyContact("Hassan" , "09" , R.drawable.yellow));
    }

    private void FakeContact(int n) {
        for (int i = 0; i < n; i++) {
            contacts.add(new MyContact("Ali"+i , "09" + i , 0));
        }
    }
}
