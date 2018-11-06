package com.example.eman.cv_builder;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

public class AlartDialogCalenderFragment extends DialogFragment implements View.OnClickListener{
    CalendarView start_date_CalendarView;
    String DATA;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.alatr_dialog_calender_date_fragment,container,false);
        View set= view.findViewById(R.id.set_buttom);
        set.setOnClickListener(this);
        start_date_CalendarView = (CalendarView) view.findViewById(R.id.start_date_cal); // get the reference of CalendarView
//        simpleCalendarView.setFocusedMonthDateColor(Color.RED); // set the red color for the dates of  focused month
//        simpleCalendarView.setUnfocusedMonthDateColor(Color.BLUE); // set the yellow color for the dates of an unfocused month
//        simpleCalendarView.setSelectedWeekBackgroundColor(Color.RED); // red color for the selected week's background
//        simpleCalendarView.setWeekSeparatorLineColor(Color.GREEN); // green color for the week separator line
        // perform setOnDateChangeListener event on CalendarView
        start_date_CalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // display the selected date by using a toast
                Toast.makeText(getActivity(), dayOfMonth + "/" + month + "/" + year, Toast.LENGTH_LONG).show();
                DATA=dayOfMonth + "/" + month + "/" + year;
            }
        });

        Dialog MyDialog = getDialog();
        MyDialog.setTitle("The Date ");
        MyDialog.setCanceledOnTouchOutside(false);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.set_buttom:
//                Toast.makeText(getActivity(), "the date is : "+DATA, Toast.LENGTH_LONG).show();
//
                break;

        }
        dismiss();

    }

}