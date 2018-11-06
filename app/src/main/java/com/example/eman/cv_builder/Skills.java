package com.example.eman.cv_builder;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.eman.cv_builder.objects.skill_object;
import com.google.gson.Gson;

import java.util.ArrayList;

public class Skills extends AppCompatActivity {
    public ArrayList<String> skills_nams = new ArrayList<>();
    public ArrayList<String> skills_level = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skills_layout);
    }

    public void saveAndnext(View view) {
        FragmentManager fr_manager = getFragmentManager();
        skills_fragment skills_fragment = (skills_fragment) fr_manager.findFragmentById(R.id.fragment1_container);
        skills_nams = skills_fragment.getArrayskills_nams();
        skills_level = skills_fragment.getArrayskills_level();
        skills_fragment skills_lastfragment = (skills_fragment) fr_manager.findFragmentByTag("frag_tage");
        boolean stop = false;

        if (skills_lastfragment != null) {
            if (!skills_lastfragment.getlastNameElement().equals("n/f")) {
                skills_nams.add(skills_lastfragment.getlastNameElement());
                skills_level.add(skills_lastfragment.getlastLevelElement());

                stop = true;
            }
        } else {
            if (!skills_fragment.getlastNameElement().equals("n/f")) {

                skills_nams.add(skills_fragment.getlastNameElement());
                skills_level.add(skills_fragment.getlastLevelElement());
                stop = true;
            }
        }
        skill_object skill_object = new skill_object();
        skill_object.setSkills_nams(skills_nams);
        skill_object.setSkills_level(skills_level);

        Gson gson = new Gson();
        String gsonArrayString = gson.toJson(skill_object);
        creat_shered_pre_for_skills(gsonArrayString);
//        Toast.makeText(Skills.this, gsonArrayString+ " ------ saveAndnext---------- ", Toast.LENGTH_SHORT).show();
        if (stop) {
            Intent i = new Intent(Skills.this, Final_Result.class);
            startActivity(i);
        }
    }

    public void creat_shered_pre_for_skills(String json_string) {

        SharedPreferences sharedPreferences_personal = getSharedPreferences(getPackageName() + "skills_sheredPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences_personal.edit();
        editor.putString("skill_object", json_string);

        editor.apply();
    }

}