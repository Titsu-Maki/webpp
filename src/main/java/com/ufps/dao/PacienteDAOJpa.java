package com.ufps.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class PacienteDAOJpa implements PacienteDAO {

    private static PacienteDAOJpa instancia;
    private EntityManagerFactory emf;

    private PacienteDAOJpa() {
        emf = Persistence.createEntityManagerFactory("biblioteca"); // nombre de la unidad de persistencia en persistence.xml
    }

    public static PacienteDAOJpa getInstancia() {
        if (instancia == null) {
            instancia = new PacienteDAOJpa();
        }
        return instancia;
    }

    @Override
    public void agregar(Paciente paciente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(paciente);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void actualizar(Paciente paciente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(paciente);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void eliminar(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Paciente estudiante = em.find(Paciente.class, id);
        em.remove(estudiante);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Paciente buscarPorId(int id) {
        EntityManager em = emf.createEntityManager();
        Paciente estudiante = em.find(Paciente.class, id);
        em.close();
        return estudiante;
    }

    @Override
    public List<Paciente> buscarTodos() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT e FROM Estudiante e");
        List<Estudiante> estudiantes = query.getResultList();
        em.close();
        return estudiantes;
    }

    // Otros métodos específicos de JPA si los necesitas
}
