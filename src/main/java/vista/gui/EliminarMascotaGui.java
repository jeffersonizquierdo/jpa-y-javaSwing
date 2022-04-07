package vista.gui;

import java.awt.BorderLayout; 
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import com.jefferson.entidades.Mascota;
import controlador.Coordinador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EliminarMascotaGui extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdDueno;
	private JTextField txtNombre;
	private JTextField txtraza;
	private JButton btnCancelar;
	private JTextField txtSexo;
	private JTextField txtColor;
	private JTextField txtBusqueda;
	private Coordinador miCoordinador;
	private JLabel lblIdmascota;
	private JButton btnBuscar;
	Mascota miMascota;
	private JButton btnEliminar;


	public void setMiCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}
	/**
	 * Create the dialog.
	 * @param b 
	 * @param miVentanaPrincipal 
	 */
	public EliminarMascotaGui(VentanaPrincipal miVentanaPrincipal, boolean b) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		iniciarComponentes();
	}

	
	private void iniciarComponentes() {
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("ELIMINAR MASCOTA");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblTitulo.setBounds(28, 11, 372, 28);
		contentPanel.add(lblTitulo);
				
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(30, 84, 370, 151);
		contentPanel.add(panel);
		panel.setLayout(null);
		
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
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(172, 119, 89, 23);
		btnEliminar.addActionListener(this);
		btnEliminar.setVisible(false);
		panel.add(btnEliminar);
		
		txtBusqueda = new JTextField();
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
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBuscar) {
			long idmascotas=Long.parseLong(txtBusqueda.getText());
			miMascota=miCoordinador.consultarMascota(idmascotas);
			if(miMascota!=null) {
				txtIdDueno.setText(miMascota.getDuenio().getIdPersona()+"");
				txtNombre.setText(miMascota.getNombre());
				txtraza.setText(miMascota.getRaza());
				txtSexo.setText(miMascota.getSexo());
				txtColor.setText(miMascota.getColorMascota());
				btnEliminar.setVisible(true);
				
			}else {
				JOptionPane.showMessageDialog(null, "LA MASCOTA NO EXISTE EN EL SISTEMA");
			}
		}else if(e.getSource()==btnEliminar) {
			
			String [] arreglo= {"Si","NO"};
			int opcion=JOptionPane.showOptionDialog(null, "Seguro que desea Eliminar esta Persona", "Confirmacion", 0, JOptionPane.QUESTION_MESSAGE, null, arreglo, "Si");
			if(opcion==0) {
				String respuesta=miCoordinador.EliminarMascota(miMascota);
				if(respuesta.equals("ok")) {
					vaciar();
					JOptionPane.showMessageDialog(null, "Se elimino la mascota correctamente");
				}
				
			}else {
				JOptionPane.showMessageDialog(null,"Se Cancelo el Proceso","ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
			}
								
			}if(e.getSource()==btnCancelar) {
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
