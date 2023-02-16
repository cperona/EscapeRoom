package com.example.escaperoom.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "modulo")
public class Modulo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idModulo")
    private int idModulo;
    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "modulo")
    private List<Examen> examens;

    public Modulo() {
    }

    public Modulo(int idModulo, String nombre, List<Examen> examens) {
        this.idModulo = idModulo;
        this.nombre = nombre;
        this.examens = examens;
    }

    @Override
    public String toString() {
        return "Modulo{" +
                "idModulo=" + idModulo +
                ", nombre='" + nombre + '\'' +
                ", examens=" + examens +
                '}';
    }

    public int getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Examen> getExamens() {
        return examens;
    }

    public void setExamens(List<Examen> examens) {
        this.examens = examens;
    }
}
