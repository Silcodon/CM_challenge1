package com.example.challenge1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        ImageView image = findViewById(R.id.imageView2);
        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);
        if(id==0) {
            image.setImageResource(R.drawable.frog);
        }
        if(id==1) {
            image.setImageResource(R.drawable.snail);
        }
        if(id==2) {
            image.setImageResource(R.drawable.rhino);
        }
        Button guardar = findViewById(R.id.button2);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText dono = findViewById(R.id.editDono);
                EditText animal = findViewById(R.id.editNome);
                EditText idade = findViewById(R.id.editIdade);
                String nome_dono = dono.getText().toString();
                String nome_animal = animal.getText().toString();
                int idade_animal = Integer.valueOf(idade.getText().toString());
                Intent intent = new Intent();
                intent.putExtra("dono",nome_dono);
                intent.putExtra("nome",nome_animal);
                intent.putExtra("idade",idade_animal);
                intent.putExtra("id",id);
                setResult(RESULT_OK, intent);
                finish(); // calls onDestroy

            }
        });
    }
}