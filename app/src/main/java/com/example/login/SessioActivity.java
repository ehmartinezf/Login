package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SessioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sessio);

        TextView tvBenvinguda = findViewById(R.id.tvBenvinguda);
        Button btnLogout = findViewById(R.id.btnLogout);

        String usuari = getIntent().getStringExtra("usuari");
        tvBenvinguda.setText(getString(R.string.benvinguda, usuari));

        btnLogout.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("usuari", usuari);

            Intent intent = new Intent(SessioActivity.this, LogoutActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        });
    }
}