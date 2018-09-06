package com.example.mohammad.aaatest.L11_Spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohammad.aaatest.R;

/**
 * Created by Mohammad on 7/24/2018.
 */
//public class CountrySpinnerAdapter extends BaseAdapter {
//
//    private Context context;
//    private int[] flags;
//    private String[] names;
//    private LayoutInflater inflater;
//    public CountrySpinnerAdapter(Context context, int[] countryFlagIds, String[] countryNames){
//        this.context = context;
//        this.flags = countryFlagIds;
//        this.names = countryNames;
//        inflater = LayoutInflater.from(context);
//    }
//
//
//    @Override
//    public int getCount() {
//        return flags.length;
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return names[i];
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup viewGroup) {
//        ViewHolder holder;
//        if(convertView == null){
//            convertView = inflater.inflate(R.layout.custom_spinner_item, viewGroup, false);
//            holder = new ViewHolder();
//            holder.country_flag = (ImageView) convertView.findViewById(R.id.country_flag);
//            holder.country_name = (TextView) convertView.findViewById(R.id.country_name);
//            convertView.setTag(holder);
//        } else {
//            holder = (ViewHolder) convertView.getTag();
//        }
//
//        holder.fill(position);
//        return convertView;
//    }
//
//
//    public class ViewHolder{
//        public ImageView country_flag;
//        public TextView country_name;
//
//        public void fill(int position){
//            country_flag.setImageResource(flags[position]);
//            country_name.setText(names[position]);
//        }
//    }
//}






public class CustomSpinnerAdapter extends BaseAdapter {

    private Context context;
    private int[] Flags;
    private String[] Names;
    private LayoutInflater inflater;

    public CustomSpinnerAdapter(Context context , int[] Flags  , String[] Names){
        this.context = context;
        this.Flags = Flags;
        this.Names = Names;
        inflater = LayoutInflater.from(context);
    }



    @Override
    public int getCount() {
        return Flags.length;
    }

    @Override
    public Object getItem(int position) {
        return Names[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.customspinner ,parent , false);
            holder = new ViewHolder();
            holder.Flag = (ImageView) convertView.findViewById(R.id.image_Spinner);
            holder.Name = (TextView) convertView.findViewById(R.id.Text_Spinner);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.fill(position);
        return  convertView;
    }
    public class ViewHolder{
        public ImageView Flag;
        public TextView Name;

        public void fill(int position){
            Flag.setImageResource(Flags[position]);
            Name.setText(Names[position]);
        }

    }
}
