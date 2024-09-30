package com.example.tyradssdkexample;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.tyrads.sdk.Tyrads;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Tyrads.getInstance().init(this,"","", false);

        //login user when he enters the dashboard
        Tyrads.getInstance().loginUser("");
        Tyrads.getInstance().showOffers("",0);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            Toast.makeText(this, "Please wait", Toast.LENGTH_SHORT).show();
        });
    }
}