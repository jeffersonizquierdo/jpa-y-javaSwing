package com.jefferson.dao;

import java.util.ArrayList;  
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import com.jefferson.aplicacion.JPAUtil;
import com.jefferson.entidades.Mascota;
import com.jefferson.entidades.Persona;

import controlador.Coordinador;

public class MascotaDao {
	
	
	EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	private Coordinador miCoordinador;
	
	public String registrarMascota (Mascota miMascota) {
		
		String resp ="";
		try {
			entityManager.getTransaction().begin();
			
			entityManager.persist(miMascota);
			System.out.println("holaaa");
			entityManager.getTransaction().commit();
			
			String  res = "ok";
			
			return res;
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "No se puede Registrar la Mascota Verifique que el Dueño Exista", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return	resp;
		
	}
	
	
	public Mascota consultarMascota( Long idMascota) {
		
		
		Mascota miMascota = entityManager.find(Mascota.class,idMascota);
		
		if (miMascota!=null) {
			
			return miMascota;
		} else {
			return null;
		}
	}
	
	
	
	public List<Mascota> ConsultarListaMascotas (){
		
		List<Mascota> listaMascotas  = new ArrayList<Mascota>();
		Query query = entityManager.createQuery("SELECT m FROM Mascota m");
		listaMascotas = query.getResultList();
		
		return listaMascotas;
	}
	
	
	public List<Mascota> ConsultarListaMascotasPorSexo (String sexo){
		
		List<Mascota> listaMascotas  = new ArrayList<Mascota>();
		Query query = entityManager.createQuery("SELECT m FROM Mascota m WHERE m.sexo = : sexoMascota");
		query .setParameter("sexoMascota", sexo);
		listaMascotas = query.getResultList();
		
		return listaMascotas;
	}
	
	
	
	public String actualizarMascota(Mascota miMascota) {
		
		entityManager.getTransaction().begin();
		entityManager.merge(miMascota);
		entityManager.getTransaction().commit();
		
		String  res = "ok";
		return res;		
	}
	
	
	
	public String eliminarMascota(Mascota miMascota) {
		
		entityManager.getTransaction().begin();
		entityManager.remove(miMascota);
		entityManager.getTransaction().commit();
		String  res = "ok";
		return res;
	}


	public void close() {
		
		entityManager.close();
		JPAUtil.shutdown();
	}


	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
		
	}


	public String eliminarMascota(Persona persona) {
		entityManager.getTransaction().begin();
		entityManager.remove(persona.getIdPersona());
		entityManager.getTransaction().commit();
		
		String  res = "ok";
		return res;
	}
	
	
	

}
