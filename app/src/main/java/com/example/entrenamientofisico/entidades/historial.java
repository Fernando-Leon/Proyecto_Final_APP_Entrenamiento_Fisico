package com.example.entrenamientofisico.entidades;

public class historial {

    private int id;
    private String titulo;
    private int id2;
    private String peso;
    private String altura;
    private String imc;
    private String date;
    public historial() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitleEjercicio() {
        return titulo;
    }

    public void setTitleEjercicio(String titleEjercicio) {
        this.titulo = titleEjercicio;
    }


    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getImc() {
        return imc;
    }

    public void setImc(String imc) {
        this.imc = imc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
