package com.ufps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ufps.entidades.Paciente;

public class PacienteDAOSingleton {

    private static PacienteDAOSingleton instancia;
    private EntityManagerFactory emf;

    private PacienteDAOSingleton() {
        emf = Persistence.createEntityManagerFactory("biblioteca");
    }

    public static PacienteDAOSingleton getInstancia() {
        if (instancia == null) {
            instancia = new PacienteDAOSingleton();
        }
        return instancia;
    }

    public List<Paciente> buscarTodos() {
        EntityManager em = emf.createEntityManager();
        List<Paciente> pacientes = em.createQuery("SELECT p FROM Paciente p", Paciente.class).getResultList();
        em.close();
        return pacientes;
    }

    public Paciente buscarPorId(int id) {
        EntityManager em = emf.createEntityManager();
        Paciente paciente = em.find(Paciente.class, id);
        em.close();
        return paciente;
    }

    public void insertar(Paciente paciente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(paciente);
        em.getTransaction().commit();
        em.close();
    }

    public void actualizar(Paciente paciente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(paciente);
        em.getTransaction().commit();
        em.close();
    }

    public void eliminar(Paciente paciente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        paciente = em.merge(paciente);
        em.remove(paciente);
        em.getTransaction().commit();
        em.close();
    }
}
