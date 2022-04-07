package vista.gui;

import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.jefferson.entidades.Producto;

import controlador.Coordinador;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;

public class TablaProductosGui extends JFrame implements ActionListener{
	
	private Coordinador miCoordinador;
	private JPanel contentPane = new JPanel();
	private JPanel miPanel;
	private DefaultTableModel model;
	private DefaultTableModel modelo;
	private JScrollPane scroll;
	private JTable tblProductos;
	private JButton btnListaProductos;
	private ArrayList<Producto> listaProductos = new ArrayList<Producto>();
	private JButton btnCancelar;
	
	
	public TablaProductosGui() {
		
		setBounds(0,0,512,379);
		setLocationRelativeTo(null);
		
		miPanel = new JPanel();
		miPanel.setBackground(new Color(153, 255, 204));
		miPanel.setBorder(new EmptyBorder(5,5,5,5));
		miPanel.setLayout(null);
		setContentPane(miPanel);
		
		tblProductos = new JTable();
		
		scroll = new JScrollPane();
		scroll.setBounds(21, 104, 438, 204);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		miPanel.add(scroll);
		
		
		
		model = new DefaultTableModel();
		model.addColumn("ID Producto");
		model.addColumn("Nombre");
		model.addColumn("Precio");
		tblProductos.setModel(model);
		
		scroll.setViewportView(tblProductos);
		
		String[] titulos = {"ID Producto","Nombre", "Precio"};
		
		modelo= new DefaultTableModel(null, titulos);
		tblProductos.setModel(modelo);
		
		
		JLabel lblNewLabel = new JLabel("Listar Productos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(21, 29, 199, 35);
		miPanel.add(lblNewLabel);
		
		btnListaProductos = new JButton("Ver Productos");
		btnListaProductos.setBounds(256, 35, 105, 35);
		miPanel.add(btnListaProductos);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(370, 41, 89, 23);
		btnCancelar.addActionListener(this);
		miPanel.add(btnCancelar);
		btnListaProductos.addActionListener(this);
		
		
		
	}
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
		
	}


	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == btnListaProductos) {
			
			mostrarProductos();	
		}if(e.getSource()==btnCancelar) {
			dispose();
		}
	}


	private void mostrarProductos() {
		
		limpiar();

		listaProductos = miCoordinador.ListarProductos() ;
		
		for (int n = 0;  n<listaProductos.size(); n++) {
			
			Object[] registros = { listaProductos.get(n).getIdProducto(), listaProductos.get(n).getNombreProducto(), listaProductos.get(n).getPrecioProducto()};
			
			modelo.addRow(registros);
			
			
		}
	}
	
	public void limpiar () {
		
		while(modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}
	}


	
}
