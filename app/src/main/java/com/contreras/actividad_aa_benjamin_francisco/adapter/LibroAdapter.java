package com.contreras.actividad_aa_benjamin_francisco.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.contreras.actividad_aa_benjamin_francisco.R;
import com.contreras.actividad_aa_benjamin_francisco.models.Libro;

import java.util.ArrayList;

public class LibroAdapter extends RecyclerView.Adapter<LibroAdapter.ViewHolder> {
    ArrayList<Libro> listalibros;
    public LibroAdapter(ArrayList<Libro> lista) { this.listalibros = lista; }

    @NonNull
    @Override
    public LibroAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_libro,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull LibroAdapter.ViewHolder holder, int position) {
        holder.cargarLibro(listalibros.get(position));
    }

    @Override
    public int getItemCount() { return listalibros.size(); }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtFechaLibro,txtTitulolibro,txtCopiasLib,txtPaginasLibro,txtAutor,txtEditorial,txtEstante, txtDescripcionLibro;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtFechaLibro = itemView.findViewById((R.id.txtFechaLibro));
            txtTitulolibro = itemView.findViewById((R.id.txtTituloLibro));
            txtCopiasLib = itemView.findViewById((R.id.txtCopiasLib));
            txtPaginasLibro = itemView.findViewById((R.id.txtPaginasLibro));
            txtAutor = itemView.findViewById((R.id.txtAutor));
            txtEditorial = itemView.findViewById((R.id.txtEditorial));
            txtEstante = itemView.findViewById((R.id.txtEstante));
            txtDescripcionLibro = itemView.findViewById(R.id.txtDescripcionLibro);
        }

        public void cargarLibro(Libro l){
            txtFechaLibro.setText(l.getFechapublicacion());
            txtTitulolibro.setText(l.getTitulo());
            txtDescripcionLibro.setText(l.getDescripcion());
            txtCopiasLib.setText(String.valueOf(l.getCopias()));
            txtPaginasLibro.setText(String.valueOf(l.getCantidadpaginas()));
            txtAutor.setText(l.getAutor().toString());
            txtEditorial.setText(l.getAutor().toString());
            txtEstante.setText(l.getEstante().toString());

        }
    }
}
