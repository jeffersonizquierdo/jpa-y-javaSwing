package controlador;

import com.jefferson.dao.MascotaDao;
import com.jefferson.entidades.Mascota;

import com.jefferson.entidades.Persona;

import clases.PersonasProductos;
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

public class Relaciones {
	
	
	public Relaciones () {
		
		VentanaPrincipal miVentanaPrincipal;
		RegistrarPersonasGui miRegistrarPersonasGui;
		RegistrarMascotasGui miRegistrarMascotasGui;
		RegistrarProductosGui miRegistrarProductosGui;
		ConsultarPersonaGui miConsultarPersonaGui;
		TablaPersonasGui miTablaPersonaGui;
		EliminarPersonaGui miElimminarPersonaGui;
		ConsultarProductoGui miConsultarProducto;
		EliminarProductoGui miEliminarProductoGui;
		ConsultarMascotaGui miConsultarMascotaGui;
		TablaMascotasGui miTablaMascotasGui;
		TablaProductosGui miTablaProductosGui;
		EliminarMascotaGui miEliminarMascotaGui;
		com.jefferson.dao.MascotaDao miMascotaDao;
		com.jefferson.dao.PersonaDao miPersonaDao;
		com.jefferson.dao.ProductoDao miProductoDao;
		Coordinador miCoordinador;
		
		
		miVentanaPrincipal= new VentanaPrincipal();
		miRegistrarPersonasGui= new RegistrarPersonasGui(miVentanaPrincipal, true);
		miRegistrarMascotasGui= new RegistrarMascotasGui(miVentanaPrincipal, true, "");
		miRegistrarProductosGui= new RegistrarProductosGui(miVentanaPrincipal, true);
		miConsultarPersonaGui=new ConsultarPersonaGui(miVentanaPrincipal,true);
		miTablaPersonaGui = new TablaPersonasGui();
		miElimminarPersonaGui=new EliminarPersonaGui(miVentanaPrincipal, true);
		miConsultarProducto = new ConsultarProductoGui();
		miEliminarProductoGui=new EliminarProductoGui();
		miConsultarMascotaGui=new ConsultarMascotaGui(miVentanaPrincipal, true);
		miTablaMascotasGui = new TablaMascotasGui();
		miTablaProductosGui = new TablaProductosGui();
		miEliminarMascotaGui=new EliminarMascotaGui(miVentanaPrincipal, true);
		miMascotaDao = new com.jefferson.dao.MascotaDao();
		miPersonaDao = new com.jefferson.dao.PersonaDao();
		miProductoDao = new com.jefferson.dao.ProductoDao();
		miCoordinador = new Coordinador();
		
		
		
		miCoordinador.setVentanaPrincipal(miVentanaPrincipal);
		miCoordinador.setRegistrarPersonasGui(miRegistrarPersonasGui);
		miCoordinador.setRegistrarMascotasGui(miRegistrarMascotasGui);
		miCoordinador.setRegistrarProductosGui(miRegistrarProductosGui);
		miCoordinador.setConsultarPersonaGui(miConsultarPersonaGui);
		miCoordinador.setTablaPersonasGui(miTablaPersonaGui);
		miCoordinador.setEliminarPersonaGui(miElimminarPersonaGui);
		miCoordinador.setConsultarProductoGui(miConsultarProducto);
		miCoordinador.setEliminarProductoGui(miEliminarProductoGui);
		miCoordinador.setConsultarmascota(miConsultarMascotaGui);
		miCoordinador.setMiTablaMascotasGui(miTablaMascotasGui);
		miCoordinador.setTablaProductosGui(miTablaProductosGui);
		miCoordinador.setEliminarMascotGui(miEliminarMascotaGui);
		miCoordinador.setMiMascotaDao(miMascotaDao);
		miCoordinador.setPersonaDao(miPersonaDao);
		miCoordinador.setProductoDao(miProductoDao);
		
		
		miVentanaPrincipal.setCoordinador(miCoordinador);
		miRegistrarPersonasGui.setCoordinador(miCoordinador);
		miRegistrarMascotasGui.setCoordinador(miCoordinador);
		miRegistrarProductosGui.setCoordinador(miCoordinador);
		miConsultarPersonaGui.setCoordinador(miCoordinador);
		miConsultarMascotaGui.setMiCoordinador(miCoordinador);
		miConsultarProducto.setCoordinador(miCoordinador);
		miElimminarPersonaGui.setMiCoordinador(miCoordinador);
		miEliminarMascotaGui.setMiCoordinador(miCoordinador);
		miEliminarProductoGui.setCoordinador(miCoordinador);
		miTablaMascotasGui.setCoordinador(miCoordinador);
		miTablaPersonaGui.setCoordinador(miCoordinador);
		miTablaProductosGui.setCoordinador(miCoordinador);
		miPersonaDao.setCoordinador(miCoordinador);
		miMascotaDao.setCoordinador(miCoordinador);
		miProductoDao.setCoordinador(miCoordinador);
		
		miVentanaPrincipal.setVisible(true);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	

}
