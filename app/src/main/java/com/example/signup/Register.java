package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;  // This imports the Button class






public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        TextView btn=findViewById(R.id.ac);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this,signin.class));
            }
        });

        Button submitButton = findViewById(R.id.submit);  // Make sure the ID matches
        submitButton.setOnClickListener(v -> {
            // You can add form validation or other logic here if needed

            // Navigate to the Actionbar activity
            Intent intent = new Intent(Register.this, Actionbar.class);
            startActivity(intent);  // Start the Actionbar activity
            finish();  // Optional: Finish the Register activity to prevent returning back
        });



    }
}









