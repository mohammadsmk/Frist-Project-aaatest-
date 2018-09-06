package com.example.mohammad.aaatest.L1_Basic;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.mohammad.aaatest.R;

public class ShowInfo {
        private Activity activity;
        private LinearLayout LayoutFormInfo;
        private EditText Name;
        private EditText Phone;
        private EditText Email;
        private CheckBox Share;
        private Button Submit;


        public ShowInfo(Activity activity, int LayoutId) {
            this.activity = activity;
            LayoutFormInfo = (LinearLayout) activity.findViewById(LayoutId);
            init();
        }

        public EditText getName() {
            return Name;
        }

        public void setName(EditText name) {
            Name = name;
        }

        public EditText getPhone() {
            return Phone;
        }

        public void setPhone(EditText phone) {
            Phone = phone;
        }

        public EditText getEmail() {
            return Email;
        }

        public void setEmail(EditText email) {
            Email = email;
        }

        public CheckBox getShare() {
            return Share;
        }

        public void setShare(CheckBox share) {
            Share = share;
        }

        public Button getSubmit() {
            return Submit;
        }

        public void setSubmit(Button submit) {
            Submit = submit;
        }

        private void init() {
            Name = (EditText) LayoutFormInfo.findViewById(R.id.forminfo_edittext_name);
            Phone = (EditText) LayoutFormInfo.findViewById(R.id.forminfo_edittext_phone);
            Email = (EditText) LayoutFormInfo.findViewById(R.id.forminfo_edittext_email);
            Share = (CheckBox) LayoutFormInfo.findViewById(R.id.forminfo_checkbox_share);
            Submit = (Button) LayoutFormInfo.findViewById(R.id.forminfo_btn_submit);


            Share.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    Phone.setEnabled(isChecked);
                }
            });

            Submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = Name.getText().toString().trim();
                    String phone = Phone.getText().toString().trim();
                    String email = Email.getText().toString().trim();
                    if (isValidInput(name, phone, email)) {

                        Intent intent = new Intent(activity, SecondActivity.class);
                        intent.putExtra("name", name);
                        intent.putExtra("email", email);
                        if (Share.isChecked()) {
                            intent.putExtra("phone", phone);
                        }
                        activity.startActivity(intent);


                    }


                }
            });


        }

        public boolean isValidInput(String name, String phone, String email) {
            if (name == null) {
                name = Name.getText().toString().trim();
            }
            if (phone == null) {
                phone = Phone.getText().toString().trim();
            }
            if (email == null) {
                email = Email.getText().toString().trim();
            }

            if (name.length() < 3) {
                Toast.makeText(activity, "ERROR NAME", Toast.LENGTH_SHORT).show();
                Name.requestFocus();
                return false;
            }
            if (!phone.isEmpty() && (phone.length() != 11 || !phone.startsWith("09"))) {
                Toast.makeText(activity, "ERROR PHONE", Toast.LENGTH_SHORT).show();
                Phone.requestFocus();
                return false;
            }
            if (!email.contains("@") && !email.contains(".") ||
                    email.lastIndexOf(".") < email.lastIndexOf("@") ||
                    email.lastIndexOf("@") <= 0 || email.split("@").length > 2
                    ) {
                Toast.makeText(activity, "ERROR EMAIL", Toast.LENGTH_SHORT).show();
                Email.requestFocus();
                return false;
            }
            return true;
        }
}



