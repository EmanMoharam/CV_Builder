package com.example.eman.cv_builder;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eman.cv_builder.objects.education_object;
import com.example.eman.cv_builder.objects.skill_object;
import com.google.gson.Gson;

public class Final_Result extends AppCompatActivity {
    TextView cv_name, cv_email, cv_phone, cv_address, cv_education, cv_skills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_result_layout);
        cv_name = (TextView) findViewById(R.id.cv_name);
        cv_email = (TextView) findViewById(R.id.cv_email);
        cv_phone = (TextView) findViewById(R.id.cv_phone);
        cv_address = (TextView) findViewById(R.id.cv_address);
        cv_education = (TextView) findViewById(R.id.cv_education);
        cv_skills = (TextView) findViewById(R.id.cv_skills);

        load_shered_pref_prsonal_data();
        load_shered_pref_education_data();
        load_shered_pref_skills_data();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getTitle().equals("edit")){
                    Toast.makeText(this, "EDIT " , Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "DELETE " , Toast.LENGTH_SHORT).show();
        }
        return true;
    }
    public void load_shered_pref_prsonal_data() {
        SharedPreferences sharedPreferences_personal = getSharedPreferences(getPackageName() + "personal_sheredPref", Context.MODE_PRIVATE);
        String Name = sharedPreferences_personal.getString("Name", "#");
        String Email = sharedPreferences_personal.getString("Email", "#");
        String Phone = sharedPreferences_personal.getString("Phone", "#");
        String Address = sharedPreferences_personal.getString("Address", "#");
        int Age = sharedPreferences_personal.getInt("Age", -1);
        String Gender = sharedPreferences_personal.getString("Gender", "#");

        cv_name.setText(Name);
        cv_email.setText(Email);
        cv_phone.setText(Phone);
        cv_address.setText(Address);

//        Toast.makeText(this, Name + " , " + Email + " , " + Phone + " , " + Address + " , " + Age + " , " + Gender, Toast.LENGTH_SHORT).show();
        Log.i("personalInfo", Name + " , " + Email + " , " + Phone + " , " + Address + " , " + Age + " , " + Gender + "  *************");

    }

    public void load_shered_pref_education_data() {
        SharedPreferences sharedPreferences_education = getSharedPreferences(getPackageName() + "education_sheredPref", Context.MODE_PRIVATE);
        String education_object_on_ref = sharedPreferences_education.getString("education_object", "#");
        Gson gson = new Gson();
        education_object education_object = gson.fromJson(education_object_on_ref, education_object.class);
        String EductionString = getEducationString(education_object);

        cv_education.setText(EductionString);

//        Toast.makeText(this, "EductionString : " + EductionString, Toast.LENGTH_SHORT).show();
        Log.i("Eduction", "EductionString : " + EductionString + "  *************");
    }

    public void load_shered_pref_skills_data() {
        SharedPreferences sharedPreferences_skiils = getSharedPreferences(getPackageName() + "skills_sheredPref", Context.MODE_PRIVATE);
        String skill_object_on_ref = sharedPreferences_skiils.getString("skill_object", "#");
        Gson gson = new Gson();
        skill_object skill_object = gson.fromJson(skill_object_on_ref, skill_object.class);
        String SkillString = getSkillString(skill_object);

        cv_skills.setText(SkillString);

//        Toast.makeText(this, "SkillString : " + SkillString, Toast.LENGTH_SHORT).show();
        Log.i("Skills", "SkillString : " + SkillString + "  *************");

    }

    public String getEducationString(education_object education_object) {
        String EductionString = "";
        for (int i = 0; i < education_object.getEduction_nams().size(); i++) {
            EductionString += education_object.getEduction_nams().get(i) +"\n"+ " Started at :" + " Ended at :" + "\n";
        }

        return EductionString;
    }

    public String getSkillString(skill_object skill_object) {
        String SkillString = "";
        for (int i = 0; i < skill_object.getSkills_nams().size(); i++) {
            SkillString += skill_object.getSkills_nams().get(i) + " -- on level -- " + skill_object.getSkills_level().get(i) + "\n";
        }

        return SkillString;
    }
}
