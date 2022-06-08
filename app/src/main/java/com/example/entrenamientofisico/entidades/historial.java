package com.example.entrenamientofisico.entidades;

public class historial {

    private int id;
    private String titulo;
    private int id2;
    private String peso;
    private String altura;
    private String imc;
    private String kcal;
    private String ejercicios;
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

    public String getKcal() {
        return kcal;
    }

    public void setKcal(String kcal) {
        this.kcal = kcal;
    }

    public String getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(String ejercicios) {
        this.ejercicios = ejercicios;
    }
}
