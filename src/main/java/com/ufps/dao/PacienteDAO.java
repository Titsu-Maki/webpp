package com.ufps.dao;

import java.sql.SQLException;
import java.util.List;
import com.ufps.entidades.Paciente;


public interface PacienteDAO {
	public void insertPaciente(Paciente paciente) throws SQLException;
	public Paciente selectUser(int id);
	public List < Paciente > selectAllUsers();
	public boolean deleteUser(int id) throws SQLException;
	public boolean updateUser(Paciente user) throws SQLException;
}
