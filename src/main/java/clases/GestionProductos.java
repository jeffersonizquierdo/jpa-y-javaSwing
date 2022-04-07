package clases;

import java.util.ArrayList; 

import javax.swing.JOptionPane;

import com.jefferson.dao.ProductoDao;
import com.jefferson.entidades.Producto;

public class GestionProductos {
	
	ProductoDao miProductoDao = new ProductoDao();
	public void iniciar() {
		
		
		
		
		String menu = "////////////// MENU PRODUCTOS //////////////\n";
		menu += "1. Registrar Productos\n";
		menu += "2. Comprar Productos\n";
		menu += "3. Consultar Productos\n";
		menu += "4. Consultar Lista de Productos\n";
		menu += "5. Actualizar Producto\n";
		menu += "6. Eliminar Producto\n";
		menu += "7. Salir\n\n";
		
		
		int opcion = 0;
		
		while (opcion!=7) {
			
			opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			switch (opcion) {
			case 1: registrarProducto();break;
			case 2: comprarProductos(); break;
			case 3: consultarProducto();break;
			case 4: consultarListaProductos();break;
			case 5: actulizarProductos();break;
			case 6: eliminaarProductos();break;
			case 7: miProductoDao.close();break;

			}
		}
	}
	

	private void registrarProducto() {
		try {
			Producto miProducto = new Producto();
			
			miProducto.setIdProducto(null);
			miProducto.setNombreProducto(JOptionPane.showInputDialog("Ingresa el Nombre del Producto"));
			miProducto.setPrecioProducto(Double.parseDouble(JOptionPane.showInputDialog("Ingresa el precio del Producto")));
			System.out.println(miProductoDao.registrarProducto(miProducto));
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocurrio un erro con los datos Porvor verifique y vuelva a itentar", "Error!", JOptionPane.ERROR_MESSAGE );
		}
	}
	
	
	private void consultarProducto() {

		long idProducto = Long.parseLong(JOptionPane.showInputDialog("Ingresa el id del producto a consultar"));
		
		Producto miProducto = miProductoDao.consultarProducto(idProducto);
		
		if (miProducto!= null) {
			
			System.out.println("Producto encontrado" + miProducto);
						
		}else {
			
			JOptionPane.showMessageDialog(null, "El producto con el id " + idProducto + "no se encuentra en el sistema", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	private void consultarListaProductos() {
		
		System.out.println("           Productos registrados en el sistema ");
		ArrayList<Producto> listaProductos = miProductoDao.consultarListaProductos();
		
		
		for (Producto producto : listaProductos) {
			
			
			System.out.println(producto);
		}
	}
	
	
	private void actulizarProductos() {
		
		Long idPro = Long.parseLong(JOptionPane.showInputDialog("Ingresa el id del producto a actualizar"));
		
		Producto miProducto = miProductoDao.consultarProducto(idPro);
		
		if (miProducto!= null) {
			
			System.out.println(miProducto);
			miProducto.setNombreProducto(JOptionPane.showInputDialog("Ingresa el nuevo nombre del Producto"));
			miProducto.setPrecioProducto(Double.parseDouble(JOptionPane.showInputDialog("Ingresa el nuevo precio del producto")));
			
			System.out.println(miProductoDao.actualizarProducto(miProducto));
		} else {
			
			JOptionPane.showMessageDialog(null, "El producto con id " + idPro + "no existe en el sistema", "Advertencia", JOptionPane.ERROR_MESSAGE);
			
		}
	}
	
	
	
	private void eliminaarProductos() {
		
		Long idPro = Long.parseLong(JOptionPane.showInputDialog("Ingresa el id del producto a eliminar"));
		
		Producto miProducto = miProductoDao.consultarProducto(idPro);
		
		if (miProducto!= null) {
			
			System.out.println(miProducto);
			
			System.out.println(miProductoDao.eliminarProducto(miProducto));
		} else {
			
			JOptionPane.showMessageDialog(null, "El producto con id " + idPro + "no existe en el sistema", "Advertencia", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
	
	
	public void comprarProductos() {
		
		
		PersonasProductos producto;
		
		String opcion = "";
		
		do {
			
			producto = new PersonasProductos();
			producto.setPersonaId(Long.parseLong(JOptionPane.showInputDialog("Ingresa el id de la persona que desea comprar")));
			producto.setProductoId(Long.parseLong(JOptionPane.showInputDialog("Ingrese el codigo del producto a comprar")));
			
			System.out.println(miProductoDao.registrarCompra(producto));
			
			opcion = JOptionPane.showInputDialog("Desea comprar otro producto");
			
			} while (opcion.equals("si"));
	}	

}
