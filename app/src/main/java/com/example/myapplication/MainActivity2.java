package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String nameval=getIntent().getExtras().getString("name");
        int i=(int) getIntent().getExtras().getInt("i");
        final EmployeeDBHealper emp=new EmployeeDBHealper(this);
        final Cursor cursorName = emp.getEmployees(nameval);
        final TextView nameT = (TextView) findViewById(R.id.textView7);
        final TextView titleT = (TextView) findViewById(R.id.textView14);
        final TextView phoneT = (TextView) findViewById(R.id.textView16);
        final TextView emailT = (TextView) findViewById(R.id.textView13);
        final TextView depT = (TextView) findViewById(R.id.textView15);
        //final TextView empidT = (TextView) findViewById(R.id.textView18);
        nameT.setText(nameval);
        //empidT.setText(String.valueOf(i));
        int departmentId=0;
        int index=0;
        //int empId=5;
        while (!cursorName.isAfterLast())
        {
            if (index==i) {
                final Cursor cursorId = emp.getEmpByID(cursorName.getInt(0));
                //empidT.setText(String.valueOf( cursorName.getInt(0)));
                titleT.setText(cursorName.getString(2));
                phoneT.setText(cursorName.getString(3));
                emailT.setText(cursorName.getString(4));
                departmentId =cursorName.getInt(5);
                break;
            }
            index++;
            cursorName.moveToNext();
        }

        String departmentName;
        final Cursor cursorDept = emp.getDepartment(departmentId);
        while (!cursorDept.isAfterLast())
        {
            if ( cursorDept.getInt(0) == departmentId) {
                departmentName = cursorDept.getString(1);
                depT.setText(departmentName);
                break;
            }
            cursorDept.moveToNext();
        }


    }


}