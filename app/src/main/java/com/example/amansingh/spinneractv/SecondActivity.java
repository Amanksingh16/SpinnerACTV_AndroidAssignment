package com.example.amansingh.spinneractv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.xml.transform.Templates;

public class SecondActivity extends AppCompatActivity {

    Intent i;
    TextView name,phone,email,state,city;
    Button edit;
    String Name,Phone,Email,State,City;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        i = getIntent();
        name = (TextView)findViewById(R.id.name1);
        phone = (TextView)findViewById(R.id.phone1);
        email = (TextView)findViewById(R.id.email1);
        state = (TextView)findViewById(R.id.state1);
        city = (TextView)findViewById(R.id.city1);
        edit = (Button)findViewById(R.id.edit);
        Name = i.getStringExtra("name");
        Phone = i.getStringExtra("phone");
        Email = i.getStringExtra("email");
        State = i.getStringExtra("state");
        City = i.getStringExtra("city");

        name.setText(name.getText()+Name);
        phone.setText(phone.getText()+Phone);
        email.setText(email.getText()+Email);
        state.setText(state.getText()+State );
        city.setText(city.getText()+City);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this,MainActivity.class);
                i.putExtra("Name",Name);
                i.putExtra("Phone",Phone);
                i.putExtra("Email",Email);
                i.putExtra("State",State);
                i.putExtra("City",City);
                startActivity(i);
            }
        });

    }
}
