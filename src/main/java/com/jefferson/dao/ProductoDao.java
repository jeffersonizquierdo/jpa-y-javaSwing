package com.jefferson.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import com.jefferson.aplicacion.JPAUtil;
import com.jefferson.entidades.Producto;

import clases.PersonasProductos;
import controlador.Coordinador;

public class ProductoDao {
	
	
	EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	private Coordinador miCoordinador;
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
		
	}
	
	
	public String registrarProducto(Producto miProducto) {
		String resp ="";
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(miProducto);
			entityManager.getTransaction().commit();
			
			String  res = "ok";
			
			return res;
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "No se pudo registrar el producto ", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return	resp;
		
	}

	public Producto consultarProducto(long idProducto) {
		
		
		Producto miProducto = entityManager.find(Producto.class, idProducto);
		
		if (miProducto!= null) {
			
			return miProducto;
			
		} else {
			
			return null;
		}
		
		
	}

	public ArrayList<Producto> consultarListaProductos() {

		List<Producto> listaProductos = new ArrayList<Producto>();
		
		Query query  = entityManager.createQuery("SELECT p FROM Producto p");
		
		listaProductos = query.getResultList();
		
		return (ArrayList<Producto>) listaProductos;
	}

	public String   actualizarProducto(Producto miProducto) {
		
		
		entityManager.getTransaction().begin();
		entityManager.merge(miProducto);
		entityManager.getTransaction().commit();
		
		
		return "ok";
	}

	public String eliminarProducto(Producto miProducto) {


		entityManager.getTransaction().begin();
		entityManager.remove(miProducto);
		entityManager.getTransaction().commit();
		
		return "Producto eliminado Exitosamente";
	}

	public void close() {
		entityManager.close();
		JPAUtil.shutdown();
		
	}

	public String registrarCompra(PersonasProductos producto) {


		String res = "";
		
		try {
			
			entityManager.getTransaction().begin();
			entityManager.persist(producto);
			entityManager.getTransaction().commit();
			
			res = "Compra Registrada con exito";
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo Registrar el Producto", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
		return res;
	}

	
	
	
	
	
	
	

}
