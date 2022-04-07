package vista.gui;

import java.awt.BorderLayout; 
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jefferson.entidades.Producto;

import controlador.Coordinador;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class EliminarProductoGui extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textNombreBuscar;
	private JTextField textNombre;
	private JTextField textPrecio;
	private Coordinador micoordinador;
	private JButton btnEliminar;
	private JButton btnBuscar;
	Producto miProducto;
	private JButton btnCancelar;


	public EliminarProductoGui() {
		
		setBounds(100, 100, 477, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb = new JLabel("Nombre");
		lb.setBounds(139, 52, 46, 14);
		contentPane.add(lb);
		
		textNombreBuscar = new JTextField();
		textNombreBuscar.setBounds(218, 49, 106, 20);
		contentPane.add(textNombreBuscar);
		textNombreBuscar.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(334, 48, 89, 23);
		contentPane.add(btnBuscar);
		btnBuscar.addActionListener(this);
		
		textNombre = new JTextField();
		textNombre.setBounds(76, 132, 86, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(30, 135, 46, 14);
		contentPane.add(lblNewLabel);
		
		textPrecio = new JTextField();
		textPrecio.setBounds(218, 132, 86, 20);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Precio");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(172, 135, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(227, 212, 89, 23);
		contentPane.add(btnEliminar);
		btnEliminar.setVisible(false);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(339, 212, 89, 23);
		btnCancelar.addActionListener(this);
		contentPane.add(btnCancelar);
		
		JLabel lblEliminar = new JLabel("Eliminar Producto");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEliminar.setBounds(113, 11, 264, 27);
		contentPane.add(lblEliminar);
		btnEliminar.addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBuscar) {
			
			Long idProducto=Long.parseLong(textNombreBuscar.getText());
			miProducto=micoordinador.ConsultarProducto(idProducto);

			if (miProducto!=null) {
				
				textNombre.setText(miProducto.getNombreProducto());
				textPrecio.setText(miProducto.getPrecioProducto()+"");
				btnEliminar.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "NO se pudo realizar la busqueda","ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
			}

		}if (e.getSource()==btnEliminar) {
			
			String [] arreglo= {"Si","NO"};
			int opcion=JOptionPane.showOptionDialog(null, "Seguro que desea Eliminar este producto 	", "Confirmacion", 0, JOptionPane.QUESTION_MESSAGE, null, arreglo, "Si");
			if(opcion==0) {
				String respuesta=micoordinador.EliminarProducto(miProducto);
				
				if(respuesta.equals("ok") ) {
					
					JOptionPane.showMessageDialog(null, "Se elimino corretamente","ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
				}
				
			}else {
				JOptionPane.showMessageDialog(null,"Se Cancelo el Proceso","ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
			}
			}if(e.getSource()==btnCancelar) {
				dispose();
			}
		}



	public void setCoordinador(Coordinador miCoordinador) {
		this.micoordinador=miCoordinador;
		
	}
}
