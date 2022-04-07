package controlador;


import java.util.ArrayList;

import com.jefferson.dao.MascotaDao;
import com.jefferson.dao.PersonaDao;
import com.jefferson.dao.ProductoDao;
import com.jefferson.entidades.Mascota;
import com.jefferson.entidades.Nacimiento;
import com.jefferson.entidades.Persona;
import com.jefferson.entidades.Producto;

import vista.gui.ConsultarMascotaGui;
import vista.gui.ConsultarPersonaGui;
import vista.gui.ConsultarProductoGui;
import vista.gui.EliminarMascotaGui;
import vista.gui.EliminarPersonaGui;
import vista.gui.EliminarProductoGui;
import vista.gui.RegistrarMascotasGui;
import vista.gui.RegistrarPersonasGui;
import vista.gui.RegistrarProductosGui;
import vista.gui.TablaMascotasGui;
import vista.gui.TablaPersonasGui;
import vista.gui.TablaProductosGui;
import vista.gui.VentanaPrincipal;

public class Coordinador {

	VentanaPrincipal miVentanaPrincipal;
	RegistrarPersonasGui miRegistrarPersonasGui;
	RegistrarMascotasGui miRegistrarMascotasGui;
	RegistrarProductosGui miRegistrarProductosGui;
	ConsultarPersonaGui miConsultarPersonaGui;
	TablaPersonasGui miTablaPersonasGui;
	EliminarPersonaGui miEliminarPersonasGui;
	ConsultarProductoGui miConsultarProductoGui;
	EliminarProductoGui miEliminarProductoGui;
	ConsultarMascotaGui miConsultarMascotaGui;
	TablaMascotasGui miTablaMascotasGui;
	TablaProductosGui miTablaProductosGui;
	EliminarMascotaGui miEliminarMascotaGui;
	PersonaDao miPersonaDao;
	MascotaDao miMascotaDao;
	ProductoDao miProductoDao;
	
	
	
	// //////////////////////////       Relaciones      ////////////////////////////////////
	
	public void setVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}
	

	public void setRegistrarPersonasGui(RegistrarPersonasGui miRegistrarPersonasGui) {
		this.miRegistrarPersonasGui  = miRegistrarPersonasGui;
	}
	

	public void setRegistrarMascotasGui(RegistrarMascotasGui miRegistrarMascotasGui) {
		this.miRegistrarMascotasGui = miRegistrarMascotasGui;
	}

	public void setRegistrarProductosGui(RegistrarProductosGui miRegistrarProductosGui) {
		this.miRegistrarProductosGui = miRegistrarProductosGui;
	}


	public void setConsultarPersonaGui(ConsultarPersonaGui miConsultaPersonaGui) {
		this.miConsultarPersonaGui = miConsultaPersonaGui;
	}


	public void setTablaPersonasGui(TablaPersonasGui miTablaPersonaGui) {
		this.miTablaPersonasGui = miTablaPersonaGui;
	}


	public void setEliminarPersonaGui(EliminarPersonaGui miElimminarPersonaGui) {
		this.miEliminarPersonasGui = miElimminarPersonaGui;
	}


	public void setConsultarProductoGui(ConsultarProductoGui miConsultarProductoGui) {
		this.miConsultarProductoGui = miConsultarProductoGui;
		
	}


	public void setEliminarProductoGui(EliminarProductoGui miEliminarProductoGui) {
		this.miEliminarProductoGui = miEliminarProductoGui;
	}


	public void setConsultarmascota(ConsultarMascotaGui miConsultarMascotaGui) {
		this.miConsultarMascotaGui = miConsultarMascotaGui;
	}


	public void setMiTablaMascotasGui(TablaMascotasGui miTablaMascotasGui) {
		this.miTablaMascotasGui = miTablaMascotasGui;
	}


	public void setTablaProductosGui(TablaProductosGui miTablaProductosGui) {
		this.miTablaProductosGui = miTablaProductosGui;
	}


	public void setEliminarMascotGui(EliminarMascotaGui miEliminarMascotaGui) {
		this.miEliminarMascotaGui = miEliminarMascotaGui;
	}


	public void setMiMascotaDao(MascotaDao miMascotaDao) {
		this.miMascotaDao = miMascotaDao;
	}

	public void setPersonaDao(PersonaDao miPersonaDao) {
		this.miPersonaDao = miPersonaDao;
	}


	public void setProductoDao(ProductoDao miProductoDao) {
		this.miProductoDao = miProductoDao;
	}	
	
/////////////////////////  Interfaces  ////////////////////////


	public void mostrarVentanaRegistroMascotas() {
		miRegistrarMascotasGui.setVisible(true);
	}
	
	public void mostarVentanaRegistroPersona() {
		miRegistrarPersonasGui.setVisible(true);
	}
	
	public void mostrarVentanaConsultarPersonas() {
		miConsultarPersonaGui.setVisible(true);
	}
	
	public void mostrarVentanaTablaPersonas() {
		miTablaPersonasGui.setVisible(true);
	}

	public void mostrarVentanaEliminarPersonaGui() {
		miEliminarPersonasGui.setVisible(true);
	}

	public void MostrarVentanaConsultarProductoGui() {
		miConsultarProductoGui.setVisible(true);
	}

	public void mostrarVentanaEliminarProducto() {
		miEliminarProductoGui.setVisible(true);	
	}

	public void mostrarVentanaConsultaMascota() {
		miConsultarMascotaGui.setVisible(true);
	}

	public void mostrarTablaProductos() {
		miTablaProductosGui.setVisible(true);
	}

	public void mostraTablaMascotas() {
		miTablaMascotasGui.setVisible(true);
	}

	public void mostrarVentanaEliminarMascota() {
		miEliminarMascotaGui.setVisible(true);
	}
	
	public void mostrarVentanaRegistrarProducto() {
		miRegistrarProductosGui.setVisible(true);	
	}

	
///////////////////////  funciones  /////////////////////////
	
	public String registrarPersona(Persona miPersona) {
		return miPersonaDao.registrarPersona(miPersona);
	}

	public Persona ConsultarPersona(Long idDocumento) {
		return miPersonaDao.consultarPersona(idDocumento);
	}

	public Nacimiento consultarNacimiento(Long idNacimiento) {
		return miPersonaDao.consultarNacimiento(idNacimiento);
	}

	public String actualizarPersona(Persona miPersona) {
		return miPersonaDao.actualizarPersona(miPersona);
	}

	public Nacimiento buscarNacimiento(Persona miPersona) {
		return miPersonaDao.buscarNacimiento(miPersona);
	}

	public String actualizarNacimiento(Nacimiento miNacimiento) {
		return miPersonaDao.actualizarNacimientoPersona(miNacimiento);
	}

	public String eliminarPersona(Persona persona) {
		return miPersonaDao.eliminarPersona(persona);
	}


	public String eliminarMascotaIdDuenio(Persona persona) {
		return miMascotaDao.eliminarMascota(persona);
	}

	public ArrayList<Persona> ListarPersonaRegistradas() {
		return (ArrayList<Persona>) miPersonaDao.consultarListaPersonas();
	}

	public String Registrarmascotas(Mascota mimascota) {
		return miMascotaDao.registrarMascota(mimascota);
	}

	public Mascota consultarMascota(long id_mascota) {
		return miMascotaDao.consultarMascota(id_mascota);
	}


	public String ActualizarMascota(Mascota miMascota) {
		return miMascotaDao.actualizarMascota(miMascota);
	}

	public String EliminarMascota(Mascota miMascota) {
		return miMascotaDao.eliminarMascota(miMascota);
	}


	public ArrayList<Mascota> ListaMascotasregistradas() {
		return (ArrayList<Mascota>) miMascotaDao.ConsultarListaMascotas();
	}


	public String registrarproductos(Producto miproducto) {
		return miProductoDao.registrarProducto(miproducto);
	}


	public Producto ConsultarProducto(Long id) {
		return miProductoDao.consultarProducto(id);
	}

	public String actualizarProducto(Producto miproducto) {
		return miProductoDao.actualizarProducto(miproducto);
	}

	public String EliminarProducto(Producto miProducto) {
		return miProductoDao.eliminarProducto(miProducto);
	}

	public ArrayList<Producto> ListarProductos() {
		return miProductoDao.consultarListaProductos();
	}


	
}
