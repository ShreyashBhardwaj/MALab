package com.example.program13;

import androidx.appcompat.app.AppCompatActivity; import android.os.Bundle;
import android.view.View; import android.widget.Button; import android.widget.EditText; import android.widget.TextView;
public class MainActivity extends AppCompatActivity { EditText etUsername,etPassword; Button btnLogin;

    TextView tvMessage; @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
        btnLogin = (Button) findViewById(R.id.btnLogin); etUsername = (EditText) findViewById(R.id.etUsername); etPassword = (EditText) findViewById(R.id.etPassword);
        tvMessage = (TextView) findViewById(R.id.tvMessage); btnLogin.setOnClickListener(new View.OnClickListener()
    { @Override
    public void onClick(View view)
    {
        if(etUsername.getText().toString().isEmpty())
        {
            etUsername.setError("Enter User name");
        } else if (etPassword.getText().toString().isEmpty()) { etPassword.setError("Enter Password");
        }
        else if(etUsername.getText().toString().equals("isbr") && etPassword.getText().toString().equals("isbr"))
        {
            tvMessage.setText("Valid Login");
        }
        else
        {
            tvMessage.setText("Invalid login");
        }
    }
    });
    }
}
