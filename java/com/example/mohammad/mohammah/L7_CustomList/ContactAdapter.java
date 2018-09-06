package com.example.mohammad.aaatest.L7_CustomList;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohammad.aaatest.R;

import java.util.List;

//public class ContactAdapter extends ArrayAdapter {
//
//    private List<MyContact> contacts;
//
//    public ContactAdapter(Context context, List<MyContact> contacts) {
//        super(context, R.layout.mycontact_list_adapter, contacts);
//        this.contacts = contacts;
//    }
//
//
//    @NonNull
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        MyContact contact = contacts.get(position);
//        ViewHolder holder;
//        if(convertView == null){
//            LayoutInflater inflater = (LayoutInflater)
//                    getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = inflater.inflate(R.layout.mycontact_list_adapter, parent, false);
//            holder = new ViewHolder();
//            holder.img_profile = (ImageView) convertView.findViewById(R.id.mycontact_img);
//            holder.tv_phone = (TextView) convertView.findViewById(R.id.mycontact_phone);
//            holder.tv_name = (TextView) convertView.findViewById(R.id.mycontact_name);
//            holder.icsms = (ImageView) convertView.findViewById(R.id.img_sms);
//            holder.iccall = (ImageView) convertView.findViewById(R.id.img_call);
//            convertView.setTag(holder);
//        } else {
//            holder = (ViewHolder) convertView.getTag();
//        }
//
//        holder.fill(contact);
//        return convertView;
//    }
//
//
//    private class ViewHolder implements View.OnClickListener {
//        public ImageView img_profile;
//        public TextView tv_name;
//        public TextView tv_phone;
//        public ImageView icsms, iccall;
//
//        public void fill(MyContact contact){
//            img_profile.setImageResource(contact.getId());
//            tv_name.setText(contact.getName());
//            tv_phone.setText(contact.getPhoneNumber());
//            iccall.setTag(contact.getPhoneNumber());
//            icsms.setTag(contact.getPhoneNumber());
//            icsms.setOnClickListener(this);
//            iccall.setOnClickListener(this);
//        }
//
//        @Override
//        public void onClick(View view) {
//            String phone = (String) view.getTag();
//            Intent intent = new Intent(Intent.ACTION_VIEW);
//            if(view.equals(iccall)){
//                intent.setData(Uri.parse("tel:" + phone));
//                getContext().startActivity(intent);
//            } else if(view.equals(icsms)){
//                intent.setData(Uri.parse("sms:" + phone));
//                getContext().startActivity(intent);
//            }
//        }
//    }
//}
public class ContactAdapter extends ArrayAdapter {

    private List<MyContact> contacts;

    public ContactAdapter(Context context, List<MyContact> contacts) {
        super(context, R.layout.mycontact_list_adapter, contacts);
        this.contacts = contacts;
    }


        @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyContact contact = contacts.get(position);
        ViewHolder holder;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)
                    getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.mycontact_list_adapter, parent, false);
            holder = new ViewHolder();
            holder.img_profile = (ImageView) convertView.findViewById(R.id.mycontact_img);
            holder.tv_phone = (TextView) convertView.findViewById(R.id.mycontact_phone);
            holder.tv_name = (TextView) convertView.findViewById(R.id.mycontact_name);
            holder.icsms = (ImageView) convertView.findViewById(R.id.img_sms);
            holder.iccall = (ImageView) convertView.findViewById(R.id.img_call);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.fill(contact);
        return convertView;
    }


    public class ViewHolder implements View.OnClickListener {
        public ImageView img_profile , iccall , icsms;
        public TextView tv_name , tv_phone;

        public void fill(MyContact contact){
            img_profile.setImageResource(contact.getId());
            tv_name.setText(contact.getName());
            tv_phone.setText(contact.getPhoneNumber());
            icsms.setTag(contact.getPhoneNumber());
            iccall.setTag(contact.getPhoneNumber());
            iccall.setOnClickListener(this);
            icsms.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            String phone = (String) v.getTag();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            if (phone.equals(iccall)){
                intent.setData(Uri.parse("tel:"+phone));
                getContext().startActivity(intent);
            }
            if (phone.equals(icsms)){
                intent.setData(Uri.parse("sms:"+phone));
                getContext().startActivity(intent);
            }
        }
    }
}

