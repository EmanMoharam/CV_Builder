package com.example.eman.cv_builder.objects;

import java.io.Serializable;
import java.util.ArrayList;

public class skill_object implements Serializable {
    ArrayList<String> skills_nams;
    ArrayList<String> skills_level;

    public ArrayList<String> getSkills_nams() {
        return skills_nams;
    }

    public void setSkills_nams(ArrayList<String> skills_nams) {
        this.skills_nams = skills_nams;
    }

    public ArrayList<String> getSkills_level() {
        return skills_level;
    }

    public void setSkills_level(ArrayList<String> skills_level) {
        this.skills_level = skills_level;
    }
}
