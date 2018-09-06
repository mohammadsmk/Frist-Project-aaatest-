package com.example.mohammad.aaatest.L6_simpleList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mohammad.aaatest.R;

import java.util.ArrayList;

public class SimpleListActivity extends AppCompatActivity {

    ArrayList<String> items;
    ArrayAdapter adapter;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);

        listView = (ListView) findViewById(R.id.listview);
        items = new ArrayList<>();

        Data();
        Refresh();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterview, View view, int position, long id) {
                Toast.makeText(SimpleListActivity.this, items.get(position) , Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void Refresh() {
        adapter = new ArrayAdapter(this , android.R.layout.simple_list_item_1 , items);
        listView.setAdapter(adapter);
    }

    private void Data() {
        items.add("Tehran");
        items.add("Ghom");
        items.add("Kashan");
        items.add("Semnan");
        items.add("Kermanshah");
        items.add("Mashhad");
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        MenuItem item = menu.add("Add");
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                items.add("new Add");
                adapter.notifyDataSetChanged();
                return false;
            }
        });
        final MenuItem itemremove = menu.add("Remove");
        itemremove.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        itemremove.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                items.remove(items.size()-1);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);

    }





}






