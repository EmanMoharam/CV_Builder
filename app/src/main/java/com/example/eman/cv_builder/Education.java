package com.example.eman.cv_builder;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.eman.cv_builder.objects.education_object;
import com.google.gson.Gson;

import java.util.ArrayList;

public class Education extends AppCompatActivity {
    public static ArrayList<String> eduction_nams = new ArrayList<>();
    Button saveEducation_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.education_layout);
//

        saveEducation_button = (Button) findViewById(R.id.saveEducation_button);
        saveEducation_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fr_manager = getFragmentManager();
                Education_fragment education_fragment = (Education_fragment) fr_manager.findFragmentById(R.id.fragment1_container);
                eduction_nams = education_fragment.getArrayEdue();
                Education_fragment education_lastfragment = (Education_fragment) fr_manager.findFragmentByTag("frag_tage");
                if (education_lastfragment != null) {
                    eduction_nams.add(education_lastfragment.getlastElement());
                }
                education_object education_object = new education_object();
                education_object.setEduction_nams(eduction_nams);

                Gson gson = new Gson();
                String gsonArrayString = gson.toJson(education_object);
                creat_shered_pre_for_education(gsonArrayString);
//                Toast.makeText(Education.this, eduction_nams.size() + " ------ " + gsonArrayString, Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Education.this, Skills.class);
                startActivity(i);
            }
        });
    }


    public void creat_shered_pre_for_education(String json_string) {

        SharedPreferences sharedPreferences_personal = getSharedPreferences(getPackageName() + "education_sheredPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences_personal.edit();
        editor.putString("education_object", json_string);

        editor.apply();
    }

}