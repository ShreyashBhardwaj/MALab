package com.example.program9;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
public class ViewActivity extends AppCompatActivity {
    ListView lst1;
    ArrayList<String> titles = new ArrayList<String>();

    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        SQLiteDatabase db = openOrCreateDatabase("SliteDb", Context.MODE_PRIVATE,null);
        lst1 = findViewById(R.id.lst1);
        final Cursor c = db.rawQuery("select * from records",null);
        int id = c.getColumnIndex("id");
        int name = c.getColumnIndex("name");
        int course = c.getColumnIndex("course");
        int fee = c.getColumnIndex("fee");
        titles.clear();
        arrayAdapter = new ArrayAdapter(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,titles);
        lst1.setAdapter(arrayAdapter);
        final ArrayList<Student> stud = new ArrayList<Student>();
        if(c.moveToFirst())
        {

            do{
                Student stu = new Student();
                stu.id = c.getString(id);
                stu.name = c.getString(name);
                stu.course = c.getString(course);
                stu.fee = c.getString(fee);
                stud.add(stu);
                titles.add(c.getString(id) + " \t " + c.getString(name) + "  \t " + c.getString(course) + " \t " + c.getString(fee) );
            } while(c.moveToNext());
            arrayAdapter.notifyDataSetChanged();
            lst1.invalidateViews();
        }
        lst1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long id) {
                String aa = titles.get(position).toString();
                Student stu = stud.get(position);
                Intent i = new Intent(getApplicationContext(),EditActivity.class);

                i.putExtra("id",stu.id);
                i.putExtra("name",stu.name);
                i.putExtra("course",stu.course);
                i.putExtra("fee",stu.fee);
                startActivity(i);
            }
        });
    }
}
