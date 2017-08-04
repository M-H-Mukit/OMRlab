package com.example.mukit.omrlab;

/**
 * Created by Mukit on 7/13/2017.
 */

public class StoreResult {
    public String id[] = new String[500];
    public String marks[] = new String[500];
    public String subject[] = {"Physics", "Chemistry", "Math"};
    int i;

    public void StoreResult() {
        i = 0;
    }

    public String getSubject(String subject_code) {
        if (subject_code == "111")
            return subject[0];
        else if (subject_code == "112")
            return subject[1];
        else if (subject_code == "113")
            return subject[2];
        else return "";

    }

    public void setMarks(String id, String mark) {
        this.id[i] = id;
        this.marks[i++] = mark;
    }


}
