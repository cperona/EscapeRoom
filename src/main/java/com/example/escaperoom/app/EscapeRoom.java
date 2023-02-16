package com.example.escaperoom.app;

import com.example.escaperoom.model.Alumno;
import org.hibernate.query.Query;
import org.hibernate.Session;

import java.util.List;

public class EscapeRoom {
    public static void main(String[] args) {
        int x=codigo1();
        int y=codigo2();
        int z=codigo3();
        int w=codigo4();
        //Mostrar por pantalla el resultado
        System.out.println("El código descubierto es: " +x+y+z+w);
    }
    public static int codigo1() {
        Session laSession = HibernateUtil.getSessionFactory().getCurrentSession();
        laSession.getTransaction().begin();

        Query q = laSession.createQuery("select count(m.idModulo) from Modulo m");
        long numModulos = (long) q.getResultList().get(0);

        laSession.getTransaction().commit();
        laSession.close();
        return (int) numModulos;
    }
    public static int codigo2() {
        Session laSession = HibernateUtil.getSessionFactory().getCurrentSession();
        laSession.getTransaction().begin();

        Query q = laSession.createQuery("select count(distinct e.idModul) from Examen e where e.idModul > 0");
        long numModulosExamen = (long) q.getResultList().get(0);

        laSession.getTransaction().commit();
        laSession.close();
        return (int) numModulosExamen;
    }
    public static int codigo3() {
        Session laSession = HibernateUtil.getSessionFactory().getCurrentSession();
        laSession.getTransaction().begin();

        Query q = laSession.createQuery("select round(avg(e.nota),0) from Examen e join Modulo m where m.idModulo = e.idModul and m.nombre like 'PRG'");
        double resultat = (double) q.getResultList().get(0);

        laSession.getTransaction().commit();
        laSession.close();
        return (int) resultat;
    }
    public static int codigo4() {
        Session laSession = HibernateUtil.getSessionFactory().getCurrentSession();
        laSession.getTransaction().begin();

        Query q = laSession.createQuery("select count(*) from Alumno a where a.apellidos like '%z%'");
        long resultat = (long) q.getResultList().get(0);

        return (int) resultat;
    }
}
