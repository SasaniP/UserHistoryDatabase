package com.example.sqlite_database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;
import java.util.ArrayList;

public class UserList extends AppCompatActivity {


    RecyclerView recyclerView;
    ArrayList<String> name,mail,age;
    DBHelper db;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        db=new DBHelper( this);
        name=new ArrayList<>();
        mail=new ArrayList<>();
        age=new ArrayList<>();
        recyclerView=findViewById(R.id.recycler_view);
        adapter=new Adapter(this,name,mail,age);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();
    }

    private void displayData() {
        Cursor cursor=db.getData();
        if (cursor.getCount()==0){
            Toast.makeText(this, "No Data Exists", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                name.add(cursor.getString(0));
                mail.add(cursor.getString(1));
                age.add(cursor.getString(2));


            }
        }
    }
}