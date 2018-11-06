package com.example.eman.cv_builder;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.gson.Gson;
import java.util.ArrayList;

public class skills_fragment extends Fragment implements AdapterView.OnItemSelectedListener {
    Spinner spinner_level;
    String chosen_level;
    ArrayAdapter<CharSequence> adapter;
    EditText skill_name_editText;
    Button add_skill_frag;
    public static final ArrayList<String> skills_nams = new ArrayList<>();
    public static final ArrayList<String> skills_level = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.skills_fragment, container, false);

        spinner_level = (Spinner) view.findViewById(R.id.level_spinner);
        adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Level_spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_level.setAdapter(adapter);
        spinner_level.setOnItemSelectedListener(this);

        skill_name_editText = (EditText) view.findViewById(R.id.skill_name_editText);

        add_skill_frag = (Button) view.findViewById(R.id.add_skill_frag);
        add_skill_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!skill_name_editText.getText().toString().isEmpty()) {
                FragmentManager fr_manager = getFragmentManager();

                skills_fragment skills_fragment = new skills_fragment();
                FragmentTransaction frag_trans = fr_manager.beginTransaction();
                frag_trans.add(R.id.container_of_addFRAG, skills_fragment, "frag_tage");
                frag_trans.commit();

                add_skill_frag.setVisibility(View.GONE);

                    skills_nams.add(skill_name_editText.getText()+"");

                }else{
                    Toast.makeText(getActivity(), " there is an empity field", Toast.LENGTH_SHORT).show();

                }
                skills_level.add(chosen_level);
//                Toast.makeText(getActivity(), skills_nams.size()+" ------ onClick--- "+skills_level.size(), Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        chosen_level = (String) adapter.getItem(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public String getlastNameElement(){
        if(!skill_name_editText.getText().toString().isEmpty()) {
            return skill_name_editText.getText() + "";
        }else{
            return "n/f";
        }
    }
    public String getlastLevelElement(){
        return   chosen_level;
    }

    public ArrayList<String> getArrayskills_nams(){
        return   skills_nams;
    }
    public ArrayList<String> getArrayskills_level(){
        return   skills_level;
    }

}