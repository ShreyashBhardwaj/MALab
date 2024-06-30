package com.example.program7;

import android.content.Intent; import android.os.Bundle; import android.view.Menu;
import android.view.MenuInflater; import android.view.MenuItem; import android.widget.Toast;
import androidx.activity.EdgeToEdge; import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity; import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;

import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    { super.onCreate(savedInstanceState); EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu)
    { MenuInflater inflater=getMenuInflater(); inflater.inflate(R.menu.optionmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    { if(item.getItemId()==R.id.php) {
        Toast.makeText(this, "Php Page", Toast.LENGTH_SHORT).show();
    }
        if(item.getItemId()==R.id.java) {
            Toast.makeText(this, "Java Page", Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId()==R.id.csharp) {
            Toast.makeText(this, "C# Page", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
