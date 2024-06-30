package com.example.program5;

import android.content.Intent; import android.os.Bundle; import android.os.Handler;
import android.view.WindowManager; import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity; import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    private static final int SPLASH_SCREEN_TIME_OUT = 10000; @Override
    protected void onCreate(Bundle savedInstanceState)
    { super.onCreate(savedInstanceState); EdgeToEdge.enable(this); setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        new Handler().postDelayed(new Runnable()
        { @Override public void run()
        {
            Intent i = new Intent(MainActivity.this, Mainscreen.class); startActivity(i);
            finish();
        }
        }, SPLASH_SCREEN_TIME_OUT);
    }
}
