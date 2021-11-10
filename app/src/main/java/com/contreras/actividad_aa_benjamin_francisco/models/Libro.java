package com.contreras.actividad_aa_benjamin_francisco.models;

public class Libro {
    private int id;
    private String titulo;
    private String descripcion;
    private String fechapublicacion;
    private int copias;
    private int cantidadpaginas;
    private Autor autor;
    private Editorial editorial;
    private Estante estante;

    public Libro() {
    }

    public Libro(int id, String titulo, String descripcion, String fechapublicacion, int copias, int cantidadpaginas, Autor autor, Editorial editorial, Estante estante) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechapublicacion = fechapublicacion;
        this.copias = copias;
        this.cantidadpaginas = cantidadpaginas;
        this.autor = autor;
        this.editorial = editorial;
        this.estante = estante;
    }

    public Libro(String titulo, String descripcion, String fechapublicacion, int copias, int cantidadpaginas, Autor autor, Editorial editorial, Estante estante) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechapublicacion = fechapublicacion;
        this.copias = copias;
        this.cantidadpaginas = cantidadpaginas;
        this.autor = autor;
        this.editorial = editorial;
        this.estante = estante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechapublicacion() {
        return fechapublicacion;
    }

    public void setFechapublicacion(String fechapublicacion) {
        this.fechapublicacion = fechapublicacion;
    }

    public int getCopias() {
        return copias;
    }

    public void setCopias(int copias) {
        this.copias = copias;
    }

    public int getCantidadpaginas() {
        return cantidadpaginas;
    }

    public void setCantidadpaginas(int cantidadpaginas) {
        this.cantidadpaginas = cantidadpaginas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Estante getEstante() {
        return estante;
    }

    public void setEstante(Estante estante) {
        this.estante = estante;
    }
    @Override
    public String toString() {
        return this.titulo;
    }
}