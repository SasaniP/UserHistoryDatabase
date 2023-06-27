package com.example.sqlite_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,mail,age;
    Button insert_btn,view_btn;
    DBHelper db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name_ed);
        mail=findViewById(R.id.mail_ed);
        age=findViewById(R.id.age_ed);
        insert_btn=findViewById(R.id.insert_btn);
        view_btn=findViewById(R.id.view_btn);

        db=new DBHelper(this);


        view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,UserList.class));
            }
        });
        insert_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_text=name.getText().toString();
                String email_text=mail.getText().toString();
                String age_text=age.getText().toString();


                Boolean  checkinsertData=db.insertuserData(name_text,email_text,age_text);
                if (checkinsertData==true){
                    Toast.makeText(MainActivity.this, "New Data Inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "new Data Not Inserted!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}