package com.jefferson.dao;

import java.util.ArrayList;  
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import com.jefferson.aplicacion.JPAUtil;
import com.jefferson.entidades.Nacimiento;
import com.jefferson.entidades.Persona;
import com.mysql.cj.Query;

import controlador.Coordinador;

public class PersonaDao {
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;	
	}
	
	EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	private Coordinador miCoordinador;

	public String registrarPersona(Persona miPersona) {
		
		entityManager.getTransaction().begin();
		entityManager.persist(miPersona);
		entityManager.getTransaction().commit();
		
		String res = "ok";
		
		return res;
	}

	public Persona consultarPersona(long idPersona) {
		
		Persona miPersona = entityManager.find(Persona.class, idPersona);
		
		if (miPersona!= null) {
			
			return miPersona;
		} else {
			return null;
		}
		
	}

	
	public List<Persona> consultarListaPersonas() {
	
		List<Persona> listaPersonas = new ArrayList<Persona>();
		
		javax.persistence.Query query = entityManager.createQuery("SELECT  p FROM Persona p");
		listaPersonas = query.getResultList();
		return listaPersonas;
	}
	

	public String actualizarPersona(Persona miPersona) {

		entityManager.getTransaction().begin();
		entityManager.merge(miPersona);
		entityManager.getTransaction().commit();
		
		String res = "ok";
		return res;
	}

	public String eliminarPersona(Persona miPersona) {

		String res= "";
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(miPersona);
			entityManager.getTransaction().commit();
			
			res = "Persona Actualizada con Exito";
			return res;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se puede eliminar la persona, verifique que no tenga otros registros en el sistema", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return res;
		
	
	}

	public void close() {
		
		entityManager.close();
		JPAUtil.shutdown();
		
	}

	

	public Nacimiento consultarNacimiento(Long idNacimiento) {
		
		Nacimiento miNacimiento = entityManager.find(Nacimiento.class, idNacimiento);
		
		if (miNacimiento!= null ) {
			return miNacimiento;
		} else {
			return null;
		}
		
	}

	public Nacimiento buscarNacimiento(Persona miPersona) {
		
		Nacimiento miNacimiento = entityManager.find(Nacimiento.class, miPersona.getNacimiento().getIdNacimiento());
		
		if (miNacimiento!=null) {
			
			return miNacimiento;
		} else {
			return null;
		}
		
	}

	public String actualizarNacimientoPersona(Nacimiento miNacimiento) {
		
		entityManager.getTransaction().begin();
		entityManager.merge(miNacimiento);
		entityManager.getTransaction().commit();
		String res  = "ok";
		return res;
	}
	
	
	

	
	
	
}
