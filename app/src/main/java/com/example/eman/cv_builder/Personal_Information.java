package com.example.eman.cv_builder;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Personal_Information extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner_gender;
    ArrayAdapter<CharSequence> adapter;
    String name, email, phone, address, gender;
    EditText name_editText, email_editText, phone_editText, address_editText, age_editText;

    int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_info_layout);

        spinner_gender = (Spinner) findViewById(R.id.Gender_spinner);
        name_editText = (EditText) findViewById(R.id.Name_editText);
        email_editText = (EditText) findViewById(R.id.Email_editText);
        phone_editText = (EditText) findViewById(R.id.Phone_editText);
        address_editText = (EditText) findViewById(R.id.Address_editText);
        age_editText = (EditText) findViewById(R.id.age_editText);

        adapter = ArrayAdapter.createFromResource(this,
                R.array.Gender_spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_gender.setAdapter(adapter);
        spinner_gender.setOnItemSelectedListener(this);

    }

    public void saveAndnext(View view) {
        Intent i = new Intent(Personal_Information.this, Education.class);
        getText_from_editText();

        create_shered_pref_prsonal(name, email, phone, address, age, gender);
//        load_shered_pref_prsonal_data();
        startActivity(i);

    }

    public void create_shered_pref_prsonal(String name, String email, String phone, String address, int age, String gender) {

        SharedPreferences sharedPreferences_personal = getSharedPreferences(getPackageName()+"personal_sheredPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences_personal.edit();
        editor.putString("Name", name);
        editor.putString("Email", email);
        editor.putString("Phone", phone);
        editor.putString("Address", address);
        editor.putInt("Age", age);
        editor.putString("Gender", gender);
        editor.apply();

    }

    public void getText_from_editText() {
        name = name_editText.getText() + "";
        email = email_editText.getText() + "";
        phone = phone_editText.getText() + "";
        address = address_editText.getText() + "";
        age = Integer.parseInt(age_editText.getText() + "");

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        gender= (String) parent.getItemAtPosition(position);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void load_shered_pref_prsonal_data(){
        SharedPreferences sharedPreferences_personal = getSharedPreferences(getPackageName()+"personal_sheredPref", Context.MODE_PRIVATE);
        String Name=sharedPreferences_personal.getString("Name","#");
        String Email=sharedPreferences_personal.getString("Email","#");
        String Phone=sharedPreferences_personal.getString("Phone","#");
        String Address=sharedPreferences_personal.getString("Address","#");
        int Age=sharedPreferences_personal.getInt("Age",-1);
        String Gender=sharedPreferences_personal.getString("Gender","#");

        Toast.makeText(this, Name+" , "+Email+" , "+Phone+" , "+Address+" , "+Age+" , "+Gender, Toast.LENGTH_SHORT).show();
        Log.i("Personal_Information",Name+" , "+Email+" , "+Phone+" , "+Address+" , "+Age+" , "+Gender +"  *************");

    }
}