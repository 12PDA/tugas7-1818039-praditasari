package com.example.grooming_kucing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Eumur, Egroom;
    private String Snama, Sumur, Sgroom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Enama = (EditText) findViewById(R.id.nm_anabul);
        Eumur = (EditText) findViewById(R.id.umur_anabul);
        Egroom = (EditText) findViewById(R.id.jenis_groom);
        Button btnCreate = (Button)
                findViewById(R.id.btn_simpan);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sumur = String.valueOf(Eumur.getText());
                Sgroom = String.valueOf(Egroom.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama Anabul",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Sumur.equals("")) {
                    Eumur.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Umur Anabul",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Sgroom.equals("")) {
                    Egroom.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Jenis Grooming",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Enama.setText("");
                    Eumur.setText("");
                    Egroom.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateGrooming(new Grooming(null, Snama, Sumur, Sgroom));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
