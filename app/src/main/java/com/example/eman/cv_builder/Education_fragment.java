package com.example.eman.cv_builder;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Education_fragment extends Fragment  {
//    CalendarView start_date_CalendarView;
    TextView start ,end ;
    EditText Name_UNIV_editText;
    String education_name;
    Button add_edu_frag;
    public static final  ArrayList<String> eduction_nams =new ArrayList<>();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.eduction_fragment, container, false);
        start =(TextView)view.findViewById(R.id.start_text_view);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fr_manager = getFragmentManager();
                AlartDialogCalenderFragment frag1 = new AlartDialogCalenderFragment();

                frag1.show(fr_manager, "fragAlartDialogCalenderFragmentstart");
            }
        });

        end =(TextView)view.findViewById(R.id.end_text_view);
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fr_manager = getFragmentManager();
                AlartDialogCalenderFragment frag1 = new AlartDialogCalenderFragment();

                frag1.show(fr_manager, "fragAlartDialogCalenderFragmentend");

            }
        });

        Name_UNIV_editText =(EditText) view.findViewById(R.id.Name_UNIV_editText);
//        education_name=Name_UNIV_editText.getText()+"";

        add_edu_frag=(Button)view.findViewById(R.id.add_edu_frag);
        add_edu_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fr_manager = getFragmentManager();
                if(!Name_UNIV_editText.getText().toString().isEmpty()) {

                    Education_fragment education_fragment = new Education_fragment();
                    FragmentTransaction frag_trans = fr_manager.beginTransaction();
                    frag_trans.add(R.id.container_of_addFRAG, education_fragment, "frag_tage");
                    frag_trans.commit();
                add_edu_frag.setVisibility(View.GONE);
                    eduction_nams.add(Name_UNIV_editText.getText() + "");

                }else{
                    Toast.makeText(getActivity(), " there is an empity field", Toast.LENGTH_SHORT).show();


                }


            }
        });
        return view;
    }

    public String getlastElement(){
        if(!Name_UNIV_editText.getText().toString().isEmpty()) {
            return Name_UNIV_editText.getText() + "";
        }else{
            return "n/f";
        }
    }
    public ArrayList<String> getArrayEdue(){
        return   eduction_nams;
    }



}
