package com.example.mohammad.aaatest.L16_Volloy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mohammad.aaatest.R;

import java.util.ArrayList;

/**
 * Created by Mohammad on 8/30/2018.
 */

public class CustomAdapter extends BaseAdapter
{
    private Context context;
    private ArrayList<Contact> data = new ArrayList<>();
    private LayoutInflater inflater = null;

    public CustomAdapter(Context ctx , ArrayList<Contact> data)
    {
        this.context = ctx;
        this.data = data;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        if (data.size() <= 0)
        {
            return 1;
        }
        return data.size();
    }

    @Override
    public Object getItem(int position)
    {
        return position;
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }


    public static class ViewHolder
    {
        public TextView Name;
        public TextView Phone;
        public TextView Email;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        View v = convertView;
        ViewHolder holder;

        if (convertView == null)
        {
            v = inflater.inflate(R.layout.item_rows ,null);
            holder = new ViewHolder();

            holder.Name = (TextView) v.findViewById(R.id.itemRow_name);
            holder.Phone = (TextView) v.findViewById(R.id.itemRow_phone);
            holder.Email = (TextView) v.findViewById(R.id.itemRow_email);

            v.setTag(holder);

        }
        else
        {
            holder = (ViewHolder) v.getTag();
        }

        if (data.size() != 0)
        {
            holder.Name.setText(data.get(position).getName());
            holder.Phone.setText(data.get(position).getPhone());
            holder.Email.setText(data.get(position).getEmail());
        }

        return v;
    }
}
