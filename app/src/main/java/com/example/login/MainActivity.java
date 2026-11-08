package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText etUsuari = findViewById(R.id.etUsuari);
        EditText etContrasenya = findViewById(R.id.etContrasenya);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String usuari = etUsuari.getText().toString().trim();
            String contrasenya = etContrasenya.getText().toString().trim();

            if (usuari.isEmpty()) {
                etUsuari.setError(getString(R.string.error_camps));
                return;
            }

            if (contrasenya.isEmpty()) {
                etContrasenya.setError(getString(R.string.error_camps));
                return;
            }

            Intent intent = new Intent(MainActivity.this, SessioActivity.class);
            intent.putExtra("usuari", usuari);
            startActivity(intent);
            finish();
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}