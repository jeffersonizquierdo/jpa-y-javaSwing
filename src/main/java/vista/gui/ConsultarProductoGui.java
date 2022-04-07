package vista.gui;

import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jefferson.entidades.Producto;

import controlador.Coordinador;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.*;

public class ConsultarProductoGui extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textBuscar;
	private JTextField textNombre;
	private JTextField textField;
	private JButton btnBuscar;
	private Coordinador miCoordinador;
	private JLabel lblNewLabel_1;
	private JButton btnActualizar;
	private JButton btnVolver;
	private JButton btnCancelar;

	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}

	public ConsultarProductoGui() {
		setBounds(100, 100, 562, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(153, 255, 204));
		
		textBuscar = new JTextField();
		textBuscar.setBounds(226, 71, 138, 20);
		contentPane.add(textBuscar);
		textBuscar.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(393, 70, 89, 23);
		contentPane.add(btnBuscar);
		btnBuscar.addActionListener(this);
		
		textNombre = new JTextField();
		textNombre.setBounds(118, 143, 138, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(33, 146, 81, 14);
		contentPane.add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("Precio");
		lblNewLabel.setBounds(276, 146, 89, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(364, 143, 118, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(20, 11, 89, 23);
		contentPane.add(btnVolver);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(417, 212, 89, 23);
		contentPane.add(btnCancelar);
		
		lblNewLabel_1 = new JLabel("Ingesa el ID del producto");
		lblNewLabel_1.setBounds(69, 74, 155, 14);
		contentPane.add(lblNewLabel_1);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(214, 212, 128, 23);
		contentPane.add(btnActualizar);
		btnActualizar.addActionListener(this);
		
		textNombre.enable(false);
		textField.enable(false);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBuscar) {
			Long idProucto=(Long.parseLong(textBuscar.getText()));
			Producto miProducto=miCoordinador.ConsultarProducto(idProucto);

			if (miProducto!=null) {
				
				textNombre.setText(miProducto.getNombreProducto());
				textField.setText(miProducto.getPrecioProducto()+"");
				textBuscar.enable(false);
				textNombre.enable(true);
				textField.enable(true);
			}else {
				JOptionPane.showMessageDialog(null, "EL PRODUCTO NO EXISTE EN EL SISTEMA");
			}
			
		}if(e.getSource()==btnActualizar) {
			Producto miproducto=new Producto();
			miproducto.setNombreProducto(textBuscar.getText());
			miproducto.setPrecioProducto(Double.parseDouble(textField.getText()));
			miproducto.setIdProducto(Long.parseLong(textBuscar.getText()));
			
			String confirmacion="";
			miproducto.setNombreProducto(textNombre.getText());
			
			confirmacion=miCoordinador.actualizarProducto(miproducto);
			
			if (confirmacion.equals("ok")) {
				
				JOptionPane.showMessageDialog(null, " Producto modificado con exito ","Confirmación",JOptionPane.INFORMATION_MESSAGE);	
			} else{
				if (confirmacion.equals("Faltan datos")) {
					JOptionPane.showMessageDialog(null, "Debe Ingresar los campos obligatorios","Faltan Datos",JOptionPane.WARNING_MESSAGE);			
				}else{
		            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		
		}if(e.getSource()==btnCancelar) {
			dispose();
		}
		
	}

	
}
