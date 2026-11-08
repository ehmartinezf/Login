package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LogoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        TextView tvComiat = findViewById(R.id.tvComiat);
        Button btnTornar = findViewById(R.id.btnTornar);

        Bundle bundle = getIntent().getExtras();
        String usuari = bundle != null ? bundle.getString("usuari") : "";
        tvComiat.setText(getString(R.string.comiat, usuari));

        btnTornar.setOnClickListener(v -> {
            Intent intent = new Intent(LogoutActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}