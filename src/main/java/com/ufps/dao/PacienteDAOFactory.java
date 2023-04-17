package com.ufps.dao;

public class PacienteDAOFactory {
    public static PacienteDAO getPacienteDAO(String type) { 
    	switch(type) {
    		case "singleton":
    			return new PacienteDAOSingleton();
    		case "jpa":
    			return new PacienteDAOJpa();
    		default:
    			return new PacienteDAOJdbc();
    	}
    }
    
    public static PacienteDAO getUserDAO(String type, String motor) { 
    	switch(type) {
    		case "singleton":
    			return new PacienteDAOSingleton(motor);
    		case "jpa":
    			return new PacienteDAOJpa();
    		default:
    			return new PacienteDAOJdbc();
    	}
    }
}
