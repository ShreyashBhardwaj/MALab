package com.example.program6;

import android.app.Dialog; import android.content.Context;
import android.content.DialogInterface; import android.os.Bundle;
import android.view.View; import android.view.ViewGroup;
import android.widget.ArrayAdapter; import android.widget.Button;

import android.widget.EditText; import android.widget.RadioButton; import android.widget.RadioGroup; import android.widget.Spinner; import android.widget.Toast;
import androidx.activity.EdgeToEdge; import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity; import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity { Button sub;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState); EdgeToEdge.enable(this); setContentView(R.layout.activity_main); Button sub=findViewById(R.id.submit);

        sub.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            { showMessage(MainActivity.this,"User Information","Successfully completed\"); completed");
            }
        });
        String[] item=new String[]{"India", "Pakisthan", "China", "America", "England"}; ArrayAdapter adapter = new ArrayAdapter<>(this,
            android.R.layout.simple_spinner_item, item); adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = findViewById(R.id.country); spinner.setAdapter(adapter);
    }
    public void showMessage(Context con,String t, String msg)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(con); builder.setTitle(t);
        builder.setMessage(msg);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
        { @Override
        public void onClick(DialogInterface dialog, int which)
        { dialog.dismiss();
        }
        });
        builder.show();


    }
}
