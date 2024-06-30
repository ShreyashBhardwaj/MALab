package com.example.program8;

import androidx.appcompat.app.AppCompatActivity; import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences; import android.os.Bundle;
import android.view.View; import android.widget.Button; import android.widget.EditText; import android.widget.Toast;
public class MainActivity extends AppCompatActivity { Button btnsave,btnnext;
    EditText etUserName,etPassword; @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); setContentView(R.layout.activity_main); btnsave=(Button) findViewById(R.id.btnsave); btnnext = (Button) findViewById(R.id.btnnext);
        etUserName = (EditText)findViewById(R.id.etUserName); etPassword = (EditText)findViewById(R.id.etPassword); btnsave.setOnClickListener(new View.OnClickListener() { @Override public void onClick(View view) {
// Writing data to SharedPreferences
            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit(); editor.putString("username",
                    etUserName.getText().toString()); editor.putString("password",

                    etPassword.getText().toString()); editor.apply();
            Toast.makeText(getApplicationContext(),"Saved successfully",Toast.LENGTH_LONG).show();

        }


        });

        btnnext.setOnClickListener(new View.OnClickListener() { @Override public void onClick(View view) {

            Intent intent = new Intent(getApplicationContext(),MainActivity2.class);

            startActivity(intent);
        }

        });
    }

}
