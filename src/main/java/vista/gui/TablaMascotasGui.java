package vista.gui;

import java.awt.BorderLayout;  
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import com.jefferson.entidades.Mascota;
import controlador.Coordinador;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;

public class TablaMascotasGui extends JFrame implements ActionListener{
	
	private JPanel contentPane = new JPanel();
	private JPanel miPanel;
	private JTable tblMascotas;
	private DefaultTableModel model;
	private DefaultTableModel modelo;
	private JScrollPane scroll;
	private JButton btnListarMascotas;
	private Coordinador miCoordinador;
	private ArrayList<Mascota> listaMascotas;	
	private ArrayList listaDocumentos;
	private JButton btnCancelar;
	
	
	public TablaMascotasGui() {
		
		setBounds(0,0,584,348);
		setLocationRelativeTo(null);
		
		
		miPanel = new JPanel();
		miPanel.setBackground(new Color(0, 153, 204));
		miPanel.setBorder(new EmptyBorder(5,5,5,5));
		miPanel.setLayout(null);
		setContentPane(miPanel);
		
		tblMascotas = new JTable();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 105, 568, 204);
		miPanel.add(scrollPane);
		
		model = new DefaultTableModel();
		model.addColumn("ID Mascota");
		model.addColumn("Color");
		model.addColumn("Nombre");
		model.addColumn("Color");
		model.addColumn("Sexo");
		model.addColumn("Doc Persona");
		tblMascotas.setModel(model);
		
		scrollPane.setViewportView(tblMascotas);
		
		String[] titulos = {"ID Mascota", "Color", "Nombre" , "Color", "Sexo", "Doc Persona"};
		
		modelo = new DefaultTableModel(null, titulos);
		tblMascotas.setModel(modelo);
		
		JLabel lblNewLabel = new JLabel("Listar Mascotas");
		miPanel.setBackground(new Color(153, 255, 204));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(28, 28, 220, 38);
		miPanel.add(lblNewLabel);
		
		btnListarMascotas = new JButton("Ver Macotas Registradas");
		btnListarMascotas.setBounds(290, 32, 158, 38);
		btnListarMascotas.addActionListener(this);
		miPanel.add(btnListarMascotas);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(458, 40, 89, 23);
		miPanel.add(btnCancelar);
	}
	
	public void setCoordinador(Coordinador miCoordinador) {

		this.miCoordinador = miCoordinador;
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnListarMascotas){
			
			mostrarMascotas();
			
		}if(e.getSource()==btnCancelar) {
			dispose();
		}
	}
	
	
	public void mostrarMascotas() {
		
		while(modelo.getRowCount()>0){
            modelo.removeRow(0);
        }
		
		try {

			listaMascotas = miCoordinador.ListaMascotasregistradas();
			System.out.println(listaMascotas);
				
			for (int  m = 0; m<listaMascotas.size() ; m++) {
				
				Object[] registrosMasocatas = {listaMascotas.get(m).getIdMascota(),listaMascotas.get(m).getColorMascota() , listaMascotas.get(m).getNombre()
						, listaMascotas.get(m).getRaza(), listaMascotas.get(m).getSexo(), listaMascotas.get(m).getDuenio().getIdPersona()};
				
				modelo.addRow(registrosMasocatas);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(btnListarMascotas, "Ocurrio un error al listar mascotas");
		}	
	}
	
	
}