package com.example.program4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }
    public void onImplicitButtonClicked(View view)
    {
        Uri url=Uri.parse("https://www.google.com");
        Intent i=new Intent(Intent.ACTION_VIEW, url);
        startActivity(i);
    }
    public void onExplicitButtonClicked(View view )
    {
        Intent i=new Intent(MainActivity.this, SecondActivity.class);
        startActivity(i);
    }
}
