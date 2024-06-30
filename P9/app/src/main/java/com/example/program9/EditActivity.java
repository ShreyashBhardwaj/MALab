package com.example.program9;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class EditActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        ed1 = findViewById(R.id.name);
        ed2 = findViewById(R.id.course);
        ed3 = findViewById(R.id.fee);
        ed4 = findViewById(R.id.id);
        b1 = findViewById(R.id.bt1);
        b2 = findViewById(R.id.bt2);
        b3 = findViewById(R.id.bt3);
        Intent i = getIntent();
        String t1 = i.getStringExtra("id").toString();
        String t2 = i.getStringExtra("name").toString();
        String t3 = i.getStringExtra("course").toString();
        String t4 = i.getStringExtra("fee").toString();
        ed4.setText(t1);
        ed1.setText(t2);
        ed2.setText(t3);
        ed3.setText(t4);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    String id = ed4.getText().toString();
                    SQLiteDatabase db = openOrCreateDatabase("SliteDb",Context.MODE_PRIVATE,null);
                    String sql = "delete from records where id = " + id + "";
                    SQLiteStatement statement = db.compileStatement(sql);
                    statement.execute();
                    Toast.makeText(EditActivity.this,"Record Deleted",Toast.LENGTH_LONG).show();
                    ed1.setText("");
                    ed2.setText("");
                    ed3.setText("");
                    ed1.requestFocus();
                }
                catch (Exception ex)
                {

                    Toast.makeText(EditActivity.this,"Record Fail",Toast.LENGTH_LONG).show();
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ViewActivity.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String name = ed1.getText().toString();
                    String course = ed2.getText().toString();
                    String fee = ed3.getText().toString();
                    String id = ed4.getText().toString();

                    SQLiteDatabase db = openOrCreateDatabase("SliteDb",
                            Context.MODE_PRIVATE, null);
                    String sql = "update records set name = '" + name + "',course='" +
                            course + "',fee='" + fee + "' where id= " + id + "";
                    SQLiteStatement statement = db.compileStatement(sql);
                    statement.execute();
                    Toast.makeText(EditActivity.this, "Record Updated",
                            Toast.LENGTH_LONG).show();
                    ed1.setText("");
                    ed2.setText("");
                    ed3.setText("");
                    ed1.requestFocus();
                } catch (Exception ex) {
                    Toast.makeText(EditActivity.this, "Record Fail",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

