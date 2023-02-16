package com.example.escaperoom.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "examen")
public class Examen implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idExamen")
    private int idExamen;
    @Column(name = "fecha")
    private LocalDate fecha;
    @Column(name = "nota")
    private Double nota;

    @Column(name = "idModul")
    private int idModul;
    @Column(name = "idAlumno")
    private int idAlumno;

    @ManyToOne()
    private Modulo modulo;

    @ManyToOne()
    private Alumno alumno;

    public Examen() {
    }

    public Examen(int idExamen, LocalDate fecha, Double nota, Modulo modulo, Alumno alumno) {
        this.idExamen = idExamen;
        this.fecha = fecha;
        this.nota = nota;
        this.modulo = modulo;
        this.alumno = alumno;
    }

    @Override
    public String toString() {
        return "Examen{" +
                "idExamen=" + idExamen +
                ", fecha=" + fecha +
                ", nota=" + nota +
                ", modulo=" + modulo +
                ", alumno=" + alumno +
                '}';
    }

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
}
