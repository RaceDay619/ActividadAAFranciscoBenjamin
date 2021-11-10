package com.contreras.actividad_aa_benjamin_francisco;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.contreras.actividad_aa_benjamin_francisco.models.Autor;
import com.contreras.actividad_aa_benjamin_francisco.models.Editorial;
import com.contreras.actividad_aa_benjamin_francisco.models.Estante;
import com.contreras.actividad_aa_benjamin_francisco.models.Libro;
import com.contreras.actividad_aa_benjamin_francisco.sqlite.DbAutor;
import com.contreras.actividad_aa_benjamin_francisco.sqlite.DbEditorial;
import com.contreras.actividad_aa_benjamin_francisco.sqlite.DbEstante;
import com.contreras.actividad_aa_benjamin_francisco.sqlite.DbLibro;

import java.util.ArrayList;

public class Form_Libro extends AppCompatActivity {

    EditText txtTituloLibro, txtDescripcionLibro, txtFechaLibro, txtCopiasLibro, txtPaginasLibro;
    Button btn_agregarLibro;
    Spinner spAutor, spEditoral, spEstante;

    public void cargarSpinner() {
        DbAutor dbaut = new DbAutor(this);// instancia
        ArrayList<Autor> autores = dbaut.getAutores();
        if (autores != null) { // si categorias no es vacío
            ArrayAdapter<Autor> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_dropdown_item, autores);
            spAutor.setAdapter(adapter);
        }

        DbEditorial dbedit = new DbEditorial(this);// instancia
        ArrayList<Editorial> editoriales = dbedit.getEditoriales();
        if (editoriales != null) { // si categorias no es vacío
            ArrayAdapter<Editorial> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_dropdown_item, editoriales);
            spEditoral.setAdapter(adapter);
        }


        DbEstante dbest = new DbEstante(this);// instancia
        ArrayList<Estante> estantes = dbest.getEstantes();
        if (estantes != null) { // si categorias no es vacío
            ArrayAdapter<Estante> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_dropdown_item, estantes);
            spEstante.setAdapter(adapter);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_libro);

        txtTituloLibro = findViewById(R.id.txtTituloLibro);
        txtDescripcionLibro = findViewById(R.id.txtDescripcionLibro);
        txtFechaLibro = findViewById(R.id.txtFechaLibro);
        txtCopiasLibro = findViewById(R.id.txtCopiasLibro);
        txtPaginasLibro = findViewById(R.id.txtPaginasLibro);
        spAutor = findViewById(R.id.spAutor);
        spEditoral = findViewById(R.id.spEditorial);
        spEstante = findViewById(R.id.spEstante);
        btn_agregarLibro = findViewById(R.id.btn_agregarlibro);

        cargarSpinner();

        btn_agregarLibro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titulo = txtTituloLibro.getText().toString();
                String descripcion = txtDescripcionLibro.getText().toString();
                String fecha = txtFechaLibro.getText().toString();
                int copias = Integer.parseInt(txtCopiasLibro.getText().toString());
                int cantP = Integer.parseInt(txtPaginasLibro.getText().toString());
                Autor autor = (Autor) spAutor.getSelectedItem();
                Editorial editorial = (Editorial) spEditoral.getSelectedItem();
                Estante estante = (Estante) spEstante.getSelectedItem();
                Libro l = new Libro(titulo, descripcion, fecha, copias, cantP, autor, editorial, estante);
                DbLibro db = new DbLibro(getApplicationContext());
                long id = db.insertarLibro(l);
                if (id >= 0) {
                    Toast.makeText(Form_Libro.this,
                            titulo + " Libro insertado correctamente", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Form_Libro.this,
                            "Error al insertar el libro", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (@NonNull MenuItem item){
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