
/*
Assignment 1 ==>
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button convertBtn = (Button) findViewById(R.id.button);
        Button clearBtn = (Button) findViewById(R.id.button2);
        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String convertedValue = "";
                EditText USdollars = (EditText) findViewById(R.id.editTextTextPersonName);
                EditText pounds = (EditText) findViewById(R.id.editTextTextPersonName2);
                if (USdollars.getText().toString().equals("") && pounds.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), " invalid data !!! ", Toast.LENGTH_LONG);
                } else {
                    if (!(USdollars.getText().toString().equals(""))) {
                        float value = Float.parseFloat(USdollars.getText().toString());
                        float convertDollarsToPounds = value * 18;
                        pounds.setText(String.valueOf(convertDollarsToPounds));
                    } else if (!(pounds.getText().toString().equals(""))) {
                        float value = Float.parseFloat(USdollars.getText().toString());
                        float convertPoundsToDollars = value / 18;
                        USdollars.setText(String.valueOf(convertPoundsToDollars));
                    }
                }
            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText USdollars = (EditText) findViewById(R.id.editTextTextPersonName);
                EditText pounds = (EditText) findViewById(R.id.editTextTextPersonName2);
                pounds.setText(String.valueOf(""));
                USdollars.setText(String.valueOf(""));
            }
        });
    }
}


assignment 2
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView = (ListView)findViewById(R.id.list);
        final ArrayAdapter<String> listAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        listView.setAdapter(listAdapter);

        Button addTaskbutton = (Button) findViewById(R.id.button);
        addTaskbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText newTask =(EditText)findViewById(R.id.editTextTextPersonName);
                String taskvalue= newTask.getText().toString();
                if(!(taskvalue.equals(""))){
                    listAdapter.add(taskvalue);
                    newTask.getText().clear();
                }

            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                listAdapter.remove(listAdapter.getItem(i));
                listAdapter.notifyDataSetChanged();
                return true;
            }
        }) ;
    }
}
Assignment 3
package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        EditText number1 = (EditText) findViewById(R.id.text1);
        EditText number2 = (EditText) findViewById(R.id.text2);
        EditText result = (EditText) findViewById(R.id.editTextTextPersonName3);
        float valueOfnumber1 = Float.parseFloat(number1.getText().toString());
        float valueOfnumber2 = Float.parseFloat(number2.getText().toString());
        float valueOfresult;
        switch (item.getItemId()){
            case R.id.Add:
                valueOfresult=valueOfnumber1+valueOfnumber2;
                result.setText(String.valueOf(valueOfresult));
                return true;
            case R.id.Multiply:
                valueOfresult=valueOfnumber1*valueOfnumber2;
                result.setText(String.valueOf(valueOfresult));
                return true;
            case R.id.Division:
                valueOfresult=valueOfnumber1/valueOfnumber2;
                result.setText(String.valueOf(valueOfresult));
                return true;

            case R.id.Subtract:
                valueOfresult=valueOfnumber1-valueOfnumber2;
                result.setText(String.valueOf(valueOfresult));
                return true;
        }
        return false;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //MenuInflater inflater = new MenuInflater(this);
        //inflater.inflate(R.menu.);
        getMenuInflater().inflate(R.menu.menu2,menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        EditText number1 = (EditText) findViewById(R.id.text1);
        EditText number2 = (EditText) findViewById(R.id.text2);
        EditText result = (EditText) findViewById(R.id.editTextTextPersonName3);
        float valueOfnumber1 = Float.parseFloat(number1.getText().toString());
        float valueOfnumber2 = Float.parseFloat(number2.getText().toString());
        float valueOfresult;
        switch (item.getItemId()){
            case R.id.Add:
                valueOfresult=valueOfnumber1+valueOfnumber2;
                result.setText(String.valueOf(valueOfresult));
                return true;
            case R.id.Multiply:
                valueOfresult=valueOfnumber1*valueOfnumber2;
                result.setText(String.valueOf(valueOfresult));
                return true;
            case R.id.Division:
                valueOfresult=valueOfnumber1/valueOfnumber2;
                result.setText(String.valueOf(valueOfresult));
                return true;

            case R.id.Subtract:
                valueOfresult=valueOfnumber1-valueOfnumber2;
                result.setText(String.valueOf(valueOfresult));
                return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText result = (EditText) findViewById(R.id.editTextTextPersonName3);
        registerForContextMenu(result);
    }
}

 */
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int empId;
        final ListView lView = (ListView)findViewById(R.id.listView);
        final ArrayAdapter<String> Adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        lView.setAdapter(Adapter);

        ImageButton imageButton = (ImageButton) findViewById (R.id.imageBtn);

        final EmployeeDBHealper emp=new EmployeeDBHealper(this);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText Name =(EditText)findViewById(R.id.editText);
                String strName= Name.getText().toString();

                final Cursor cursor = emp.getEmployees(strName);
                while (!cursor.isAfterLast())
                {
                    Adapter.add(cursor.getString(1));
                    cursor.moveToNext();
                }
            }
        });
        lView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView <?> adapterView, View view, int i, long l) {
                TextView name = (TextView)view;
                String nameval =name.getText().toString();
                Intent activity= new Intent(MainActivity.this,MainActivity2.class);
                activity.putExtra( "name",nameval);
                activity.putExtra( "i",i);

                startActivity(activity);
                return true;
            }
        });
    }
}

