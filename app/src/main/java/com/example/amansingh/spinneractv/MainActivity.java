package com.example.amansingh.spinneractv;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String State[] = {"Punjab","Uttar Pradesh","Madhya Pradesh","Rajasthan","Bihar","Uttarakhand"};
    String punarr[] = {"Jalandhar","Patiala","Ludhiana","Amritsar","Chandigarh"};
    String UParr[] = {"Lucknow","Noida","Allahbad","Kanpur","Meerut"};
    String MParr[] = {"Bhopal","Indore","Jabalpur","Itarsi"};
    String Rajarr[] = {"Jaipur","Ajmer","Jodhpur","Jaisalmer","Udaipur","Suratgarh"};
    String Biharr[] = {"Muffarpur","Patna","Gaya","Samastipur","Katihar"};
    String Uttarr[] = {"Dehradun","Haridwar","Rishikesh"};
    EditText name, phone , email;
    Spinner state;
    Button save;
    String stateval;
    int value;
    AutoCompleteTextView city;
    ArrayAdapter<String> adapter;
    ArrayAdapter<String> cityadapter;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.name);
        phone = (EditText)findViewById(R.id.phone);
        email = (EditText)findViewById(R.id.email);
        state = (Spinner)findViewById(R.id.spinner);
        city = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        save = (Button)findViewById(R.id.save);

        intent = getIntent();
        if(intent.hasExtra("Name"))
        {
            name.setText(""+intent.getStringExtra("Name"));
        }
        if(intent.hasExtra("Phone"))
        {
            phone.setText(""+intent.getStringExtra("Phone"));
        }
        if(intent.hasExtra("Email"))
        {
            email.setText(""+intent.getStringExtra("Email"));
        }
        if(intent.hasExtra("City"))
        {
             city.setText(""+intent.getStringExtra("City"));
        }

        adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_list,State);
        state.setAdapter(adapter);

        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(getApplicationContext(),"State is "+State[position]+",select the city",Toast.LENGTH_SHORT).show();
                stateval = State[position];
                switch (position)
                {
                    case 0: cityadapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,punarr);
                            city.setAdapter(cityadapter);
                        break;
                    case 1: cityadapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,UParr);
                        city.setAdapter(cityadapter);
                        break;
                    case 2: cityadapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,MParr);
                        city.setAdapter(cityadapter);
                        break;
                    case 3: cityadapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,Rajarr);
                        city.setAdapter(cityadapter);
                        break;
                    case 4: cityadapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,Biharr);
                        city.setAdapter(cityadapter);
                        break;
                    case 5: cityadapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,Uttarr);
                        city.setAdapter(cityadapter);
                        break;
                        default:
                            break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
          save.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if(name.length()!=0 && phone.length()!=0 && email.length()!=0 && city.length()!=0)
                  {
                      Intent i = new Intent(MainActivity.this,SecondActivity.class);
                      i.putExtra("name",name.getText().toString());
                      i.putExtra("phone",phone.getText().toString());
                      i.putExtra("email",email.getText().toString());
                      i.putExtra("state",stateval);
                      i.putExtra("city",city.getText().toString());
                      startActivity(i);
                  }
                  else
                  {
                      Toast.makeText(getApplicationContext(),"Wrong Input",Toast.LENGTH_SHORT).show();
                  }
              }
          });
    }
}
