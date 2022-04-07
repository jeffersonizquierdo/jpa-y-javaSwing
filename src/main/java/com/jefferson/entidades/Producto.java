package com.jefferson.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name="productos")
public class Producto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY) @Column (name = "id_producto") private Long idProducto;
	@Column (name = "nombre_producto", nullable = false, length = 45) private String nombreProducto;
	@Column (name = "precio_producto") private Double precioProducto;
	
	@ManyToMany (mappedBy = "listaProductos") private List<Persona> listaPersonas;

	
	
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto(String nombreProducto, Double precioProdcuto) {
		super();

		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProdcuto;
	}
	
	
	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(Double precioProdcuto) {
		this.precioProducto = precioProdcuto;
	}

	public List<Persona> getListaPersonas() {
		return listaPersonas;
	}

	public void setListaPersonas(List<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}

	@Override
	public String toString() {
		return "Producto idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", precioProducto="
				+ precioProducto + ", listaPersonas=" + lista();
	}
	
	public ArrayList<String> lista () {

		ArrayList<String> lista = new  ArrayList();
		
		for (Persona persona : listaPersonas) {
			
		
			lista.add(persona.getNombre());
			
		}
		
		return lista;
		
	}

}
