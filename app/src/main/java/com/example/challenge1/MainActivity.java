package com.example.challenge1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.annotation.Inherited;

public class MainActivity extends AppCompatActivity {
    private static final int REQ_CODE = 111;
    public String nome_snail="";
    public String nome_frog="";
    public String nome_rhino="";
    public String dono_snail="";
    public String dono_frog="";
    public String dono_rhino="";
    public String idade_snail="";
    public String idade_frog="";
    public String idade_rhino="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spin= findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ImageView image = findViewById(R.id.imageView);
                TextView dono = findViewById(R.id.dono);
                TextView nome = findViewById(R.id.nome);
                TextView idade = findViewById(R.id.idade);

                if(i==0) {
                    image.setImageResource(R.drawable.frog);
                    dono.setText(dono_frog);
                    nome.setText(nome_frog);
                    idade.setText(idade_frog);
                }
                if(i==1) {
                    image.setImageResource(R.drawable.snail);
                    dono.setText(dono_snail);
                    nome.setText(nome_snail);
                    idade.setText(idade_snail);
                }
                if(i==2) {
                    image.setImageResource(R.drawable.rhino);
                    dono.setText(dono_rhino);
                    nome.setText(nome_rhino);
                    idade.setText(idade_rhino);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Button editar = findViewById(R.id.button);
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (view.getContext() , Activity2.class);
                intent.putExtra("id", spin.getSelectedItemPosition());
                startActivity(intent);

            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode,resultCode,intent);
        if(resultCode==RESULT_OK){
            if (requestCode==REQ_CODE){
                //Vem da segunda atividade
                String dono_edit=intent.getStringExtra("dono");
                String nome_edit=intent.getStringExtra("nome");
                int idade_edit=intent.getIntExtra("idade",0);
                int animal_position = intent.getIntExtra("id",0);
                if(animal_position==0){
                    dono_frog=dono_edit;
                    nome_frog=nome_edit;
                    idade_frog=String.valueOf(idade_edit);
                }
                if(animal_position==1){
                    dono_snail=dono_edit;
                    nome_snail=nome_edit;
                    idade_snail=String.valueOf(idade_edit);
                }
                if(animal_position==2){
                    dono_rhino=dono_edit;
                    nome_rhino=nome_edit;
                    idade_rhino=String.valueOf(idade_edit);
                }
            }
        }
    }
}