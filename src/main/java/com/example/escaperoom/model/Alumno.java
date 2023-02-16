package com.example.escaperoom.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "alumno")
public class Alumno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAlumno")
    private int idAlumno;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "edad")
    private int edad;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "repetidor")
    private String repetidor;

    @OneToMany(mappedBy = "alumno")
    private List<Examen> examens;

    public Alumno() {
    }

    public Alumno(int idAlumno, String apellidos, int edad, String nombre, String repetidor, List<Examen> examens) {
        this.idAlumno = idAlumno;
        this.apellidos = apellidos;
        this.edad = edad;
        this.nombre = nombre;
        this.repetidor = repetidor;
        this.examens = examens;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "idAlumno=" + idAlumno +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", nombre='" + nombre + '\'' +
                ", repetidor='" + repetidor + '\'' +
                ", examens=" + examens +
                '}';
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRepetidor() {
        return repetidor;
    }

    public void setRepetidor(String repetidor) {
        this.repetidor = repetidor;
    }

    public List<Examen> getExamens() {
        return examens;
    }

    public void setExamens(List<Examen> examens) {
        this.examens = examens;
    }
}
