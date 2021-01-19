package com.cookandroid.project6_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Chronometer chrono;
//    Button btnStart, btnEnd;
    RadioButton rdoCal, rdoTime;
    RadioGroup rGroup;
    //    CalendarView calView;
    DatePicker datepickerView;
    TimePicker tPicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;
    int selectYear, selectMonth, selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("시간 예약");

//        btnStart = (Button) findViewById(R.id.btnStart);
//        btnEnd = (Button) findViewById(R.id.btnEnd);


        chrono = (Chronometer) findViewById(R.id.chronometer1);
        rGroup = (RadioGroup) findViewById(R.id.rGroup);
        rdoCal = (RadioButton) findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);

        tPicker = (TimePicker) findViewById(R.id.timePicker1);
//        calView = (CalendarView) findViewById(R.id.calendarView1);
        datepickerView = (DatePicker) findViewById(R.id.datepickerView);
        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMonth = (TextView) findViewById(R.id.tvMonth);
        tvDay = (TextView) findViewById(R.id.tvDay);
        tvHour = (TextView) findViewById(R.id.tvHour);
        tvMinute = (TextView) findViewById(R.id.tvMinute);

        rGroup.setVisibility(View.INVISIBLE);
        tPicker.setVisibility(View.INVISIBLE);
        //calView.setVisibility(View.INVISIBLE);
        datepickerView.setVisibility(View.INVISIBLE);
        //날짜설정 라디오버튼 클릭 시 이벤트
        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tPicker.setVisibility(View.INVISIBLE);
                //calView.setVisibility(View.VISIBLE);
                datepickerView.setVisibility(View.VISIBLE);
            }
        });
        //시간설정 라디오버튼 클릭 시 이벤트
        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tPicker.setVisibility(View.VISIBLE);
                datepickerView.setVisibility(View.INVISIBLE);
            }
        });
        chrono.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                rGroup.setVisibility(View.VISIBLE);
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
            }
        });

        datepickerView.setOnDateChangedListener(new DatePicker.OnDateChangedListener(){
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                selectYear = year;
                selectMonth = monthOfYear + 1;
                selectDay = dayOfMonth;
            }
        });




        //예약시작 버튼 클릭 시 발생하는 이벤트
//        btnStart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                chrono.setBase(SystemClock.elapsedRealtime());  //크로노미터를 0으로 초기화
//                chrono.start();
//                chrono.setTextColor(Color.RED);
//            }
//        });
        //예약완료 버튼 클릭 시 발생하는 이벤트
//        btnEnd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                chrono.stop();
//                chrono.setTextColor(Color.BLUE);
//                tvYear.setText(Integer.toString(selectYear));
//                tvMonth.setText(Integer.toString(selectMonth));
//                tvDay.setText(Integer.toString(selectDay));
//
//                tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
//                tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));
//            }
//        });
        //캘린더의 날짜 변경 시 발생하는 이벤트
//        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
//                selectYear = year;
//                selectMonth = month + 1;
//                selectDay = dayOfMonth;
//            }
//        });

        //연도 롱 클릭시 예약완료 기능
        tvYear.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);
                rGroup.setVisibility(View.INVISIBLE);
                datepickerView.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));

                tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
                tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));
                return false;
            }
        });
    }
}