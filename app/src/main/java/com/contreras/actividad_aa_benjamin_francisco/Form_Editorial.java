package com.contreras.actividad_aa_benjamin_francisco;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.contreras.actividad_aa_benjamin_francisco.models.Editorial;
import com.contreras.actividad_aa_benjamin_francisco.sqlite.DbEditorial;

public class Form_Editorial extends AppCompatActivity {
    EditText txtNombreEditorial;
    EditText txtNacionalidadEditorial;
    Button btn_AñadirEditorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_editorial);

        txtNombreEditorial = findViewById(R.id.txtNombreEditorial);
        txtNacionalidadEditorial = findViewById(R.id.txtNacionalidadEditorial);
        btn_AñadirEditorial = findViewById(R.id.btn_AñadirEditorial);

        btn_AñadirEditorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = txtNombreEditorial.getText().toString();
                String nacionalidad = txtNacionalidadEditorial.getText().toString();

                Editorial e = new Editorial(nombre,nacionalidad);
                DbEditorial dbedit = new DbEditorial(getApplicationContext());
                long id = dbedit.insertarEditorial(e);
                if( id >= 0 ){
                    Toast.makeText(Form_Editorial.this,
                            nombre+" Editorial insertada", Toast.LENGTH_LONG).show();
                    txtNombreEditorial.setText("");
                }else{
                    Toast.makeText(Form_Editorial.this,
                            "Error al insertar editorial", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // condicional - switch

        switch (item.getItemId()) { // tomamos el id del item seleccionado
            case R.id.menu_inicio:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;


            case R.id.menu_Libro:
                Intent intent1 = new Intent(this, Form_Libro.class);
                startActivity(intent1);
                return true;

            case R.id.menu_Autor:
                Intent intent2 = new Intent(this, Form_Autor.class);
                startActivity(intent2);
                return true;
            case R.id.menu_Estante:
                Intent intent3 = new Intent(this, Form_Estante.class);
                startActivity(intent3);
                return true;
            case R.id.menu_Editorial:
                Intent intent4 = new Intent(this, Form_Editorial.class);
                startActivity(intent4);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}