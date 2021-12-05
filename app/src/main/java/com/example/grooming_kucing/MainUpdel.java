package com.example.grooming_kucing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Sumur, Sgroom;
    private EditText Enama, Eumur, Egroom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Sumur = i.getStringExtra("Iumur");
        Sgroom = i.getStringExtra("Igroom");
        Enama = (EditText) findViewById(R.id.updel_nm_anabul);
        Eumur = (EditText) findViewById(R.id.updel_umur_anabul);
        Egroom = (EditText) findViewById(R.id.updel_jenis_groom);
        Enama.setText(Snama);
        Eumur.setText(Sumur);
        Egroom.setText(Sgroom);
        Button btnUpdate = (Button) findViewById(R.id.btn_ubah);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sumur = String.valueOf(Eumur.getText());
                Sgroom = String.valueOf(Egroom.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi Namaa Anabul",
                            Toast.LENGTH_SHORT).show();
                } else if (Sumur.equals("")){
                    Eumur.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi Umur Anabul",
                            Toast.LENGTH_SHORT).show();
                } else if (Sgroom.equals("")){
                    Egroom.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi Jenis Grooming",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateGrooming(new Grooming(Sid, Snama, Sumur, Sgroom));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_hapus);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteGrooming(new Grooming(Sid, Snama, Sumur, Sgroom));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
