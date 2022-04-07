package vista.gui;

import java.awt.BorderLayout; 
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import com.jefferson.entidades.Mascota;
import controlador.Coordinador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.Color;

public class ConsultarMascotaGui extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdDueno;
	private JTextField txtNombre;
	private JTextField txtraza;
	private JButton btnCancelar;
	private JTextField txtSexo;
	private JTextField txtColor;
	private JTextField txtBusqueda;
	private JLabel lblIdmascota;
	private JButton btnBuscar;
	Mascota miMascota;
	private JButton btnVaciar;
	private JButton btnActualizar;
	private Coordinador miCoordinador;

	/**
	 * Create the dialog.
	 * @param b 
	 * @param miVentanaPrincipal 
	 */
	
	public ConsultarMascotaGui(VentanaPrincipal miVentanaPrincipal, boolean b) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 153, 204));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		iniciarComponentes();
	}

	
	public void setMiCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;	
	}
	
	private void iniciarComponentes() {
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("CONSULTAR MASCOTA");
		lblTitulo.setBackground(Color.WHITE);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblTitulo.setBounds(28, 11, 372, 28);
		contentPanel.add(lblTitulo);
				
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(30, 84, 370, 151);
		contentPanel.add(panel);
		panel.setLayout(null);
		contentPanel.setBackground(new Color(153, 255, 204));
		
		JLabel lblDueno = new JLabel("Id Due\u00F1o:");
		lblDueno.setBounds(204, 11, 71, 21);
		panel.add(lblDueno);
		
		txtIdDueno = new JTextField();
		txtIdDueno.setBounds(274, 11, 86, 20);
		panel.add(txtIdDueno);
		txtIdDueno.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(29, 43, 71, 21);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(93, 43, 86, 20);
		panel.add(txtNombre);
		
		JLabel lblRaza = new JLabel("Raza:");
		lblRaza.setBounds(219, 43, 71, 21);
		panel.add(lblRaza);
		
		txtraza = new JTextField();
		txtraza.setColumns(10);
		txtraza.setBounds(274, 43, 86, 20);
		panel.add(txtraza);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(29, 108, 331, 12);
		panel.add(separator);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(271, 119, 89, 23);
		panel.add(btnCancelar);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(29, 75, 71, 21);
		panel.add(lblSexo);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(219, 76, 71, 21);
		panel.add(lblColor);
		
		txtSexo = new JTextField();
		txtSexo.setBounds(93, 75, 86, 20);
		panel.add(txtSexo);
		txtSexo.setColumns(10);
		
		txtColor = new JTextField();
		txtColor.setBounds(274, 75, 86, 20);
		panel.add(txtColor);
		txtColor.setColumns(10);
		
		btnVaciar = new JButton("Limpiar");
		btnVaciar.setBounds(172, 119, 89, 23);
		btnVaciar.addActionListener(this);
		panel.add(btnVaciar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(73, 119, 89, 23);
		panel.add(btnActualizar);
		btnActualizar.addActionListener(this);
		
		
		txtBusqueda = new JFormattedTextField();
		txtBusqueda.setBounds(219, 53, 86, 20);
		contentPanel.add(txtBusqueda);
		txtBusqueda.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(315, 50, 86, 23);
		btnBuscar.addActionListener(this);
		contentPanel.add(btnBuscar);
		
		lblIdmascota = new JLabel("ID de la Mascota");
		lblIdmascota.setBounds(127, 50, 86, 23);
		contentPanel.add(lblIdmascota);
		
		txtColor.enable(false);
		txtIdDueno.enable(false);
		txtNombre.enable(false);
		txtraza.enable(false);
		txtSexo.enable(false);
		
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBuscar) {
			System.out.println("holaaaaaaaaaaa");
			
			String id = txtBusqueda.getText();
			System.out.println(id);
			long id_mascota= Long.parseLong(id);
			System.out.println(id);
			
			System.out.println(id_mascota);	
			miMascota=miCoordinador.consultarMascota(id_mascota);
			if(miMascota!=null) {	
				txtIdDueno.setText(miMascota.getDuenio().getIdPersona()+"");
				txtNombre.setText(miMascota.getNombre());
				txtraza.setText(miMascota.getRaza());
				txtSexo.setText(miMascota.getSexo());
				txtColor.setText(miMascota.getColorMascota());
				txtColor.enable(true);
				txtNombre.enable(true);
				txtraza.enable(true);
				txtSexo.enable(true);
				txtBusqueda.enable(false);
				
			}else {
				JOptionPane.showMessageDialog(null, "LA MASCOTA NO EXISTE EN EL SISTEMA");
			}
			
			
		}if(e.getSource()==btnVaciar) {
			vaciar();
			txtBusqueda.enable(true);
			
		}if (e.getSource() == btnActualizar) {
			
			Mascota miMascota = new Mascota();
			miMascota.setNombre(txtNombre.getText());
			miMascota.setRaza(txtraza.getText());
			miMascota.setSexo(txtSexo.getText());
			miMascota.setColorMascota(txtColor.getText());
			miMascota.setIdMascota(Long.parseLong(txtBusqueda.getText()));
			
			String confirmacion = miCoordinador.ActualizarMascota(miMascota);
			
			if (confirmacion.equals("ok")) {
				
				JOptionPane.showMessageDialog(null, "Mascota Actualizada con Exito");
				txtColor.enable(false);
				txtIdDueno.enable(false);
				txtNombre.enable(false);
				txtraza.enable(false);
				txtSexo.enable(false);
				txtBusqueda.enable(true);
				
			}else {
				JOptionPane.showMessageDialog(null, "NO SE PUDO ACTUALIZAR LA MASCOTA");
			}
			
		} if (e.getSource() == btnCancelar) {
			
			dispose();
			
		}
	}


	public void vaciar() {
		
		txtBusqueda.setText("");
		txtIdDueno.setText("");
		txtNombre.setText("");
		txtraza.setText("");
		txtSexo.setText("");
		txtColor.setText("");
	}
}
