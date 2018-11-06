package com.example.eman.cv_builder.objects;

import java.io.Serializable;
import java.util.ArrayList;

public class education_object implements Serializable {
    ArrayList<String> eduction_nams;

    public ArrayList<String> getEduction_nams() {
        return eduction_nams;
    }

    public void setEduction_nams(ArrayList<String> eduction_nams) {
        this.eduction_nams = eduction_nams;
    }
}
