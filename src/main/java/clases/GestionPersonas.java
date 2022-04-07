package clases;

import java.time.LocalDate; 
import java.util.List;

import javax.swing.JOptionPane;

import com.jefferson.dao.PersonaDao;
import com.jefferson.entidades.Mascota;
import com.jefferson.entidades.Nacimiento;
import com.jefferson.entidades.Persona;

public class GestionPersonas {

	
	PersonaDao miPersonaDao = new PersonaDao();
	
	

	public void iniciar() {

		String menu = "////////////// MENU PERSONAS //////////////\n";
		menu += "1. Registrar Persona\n";
		menu += "2. Consultar Persona\n";
		menu += "3. Consultar Lista de Persona\n";
		menu += "4. Actualizar Persona\n";
		menu += "5. Eliminar Persona\n";
		menu += "6. Salir\n\n";
		
		int opcion = 0;
		
		while (opcion!=7) {
			
			opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			switch (opcion) {
			case 1: registrarPersona();break;
			case 2: consultarPersona();break;
			case 3: consultarListaPersonas();break;
			case 4: actulizarPersona();break;
			case 5: eliminaarPersona();break;
			case 6: miPersonaDao.close();break;

			}
		}
	}

	private void registrarPersona() {
		
		Persona miPersona = new Persona();
		miPersona.setIdPersona(Long.parseLong(JOptionPane.showInputDialog("Ingresa el documento")));
		miPersona.setNombre(JOptionPane.showInputDialog("Ingerse el Nombre de la persona"));
		miPersona.setTelefono(JOptionPane.showInputDialog("Ingrese el telefono de la ´persona"));
		miPersona.setProfesion(JOptionPane.showInputDialog("Ingresa la profesion de la persona"));
		miPersona.setTipo(Integer.parseInt(JOptionPane.showInputDialog("Ingresa el tipo de persona (1 o 2) ")));
		miPersona.setNacimiento(registrarDatosNacimiento());
		
		String  opcion = "";
		
		opcion = JOptionPane.showInputDialog("Desea Registrar una Mascota, ingresa si o no");
		
		if (opcion.equals("si")) {
			
			
			Mascota miMascota = new Mascota();
			miMascota.setIdMascota(null);
			miMascota.setNombre(JOptionPane.showInputDialog("Ingerse el Nombre de la mascota"));
			miMascota.setRaza(JOptionPane.showInputDialog("Ingresa la Raza de la mascota"));
			miMascota.setSexo(JOptionPane.showInputDialog("Ingrese el Sexo de la Mascota"));
			miMascota.setColorMascota(JOptionPane.showInputDialog("Ingresa el color de la Mascota"));
			miMascota.setDuenio(miPersona);
			
			miPersona.getListaMascotas().add(miMascota);
			
		} else {
			
			System.out.println(miPersonaDao.registrarPersona(miPersona));
		}		
	}

	
	private Nacimiento registrarDatosNacimiento() {
		
		int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de nacimiento"));
		int mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes de nacimiento"));
		int dia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dia de nacimiento"));
		
		Nacimiento miNacimiento = new Nacimiento();
		miNacimiento.setFechaNacimiento(LocalDate.of(anio, mes, dia));
		miNacimiento.setCiudadNacimiento(JOptionPane.showInputDialog("Ingresa la ciudad de nacimiento"));
		miNacimiento.setDepartamentoNacimiento(JOptionPane.showInputDialog("Ingresa el departamento de nacimiento"));
		miNacimiento.setPaisNacimiento(JOptionPane.showInputDialog("Ingresa el pais de nacimiento"));
		
		
		return miNacimiento;
	}
	
	
	private void consultarPersona() {
		
		long idPersona = Long.parseLong(JOptionPane.showInputDialog("Ingrese el Documento de la Persona a Buscar"));
		Persona miPersona = miPersonaDao.consultarPersona(idPersona);
		
		if (miPersona!=null) {
			
			System.out.println(miPersona + "\n");
			
		}else {
			
			JOptionPane.showMessageDialog(null, "La Persona con el Docummento " + idPersona + ", No existe en el sistema \n");
		}			
	}
	
	
	private void consultarListaPersonas() {


		System.out.println("///////////////// Persona Registradas //////////////");
		List<Persona> listaPersonas = miPersonaDao.consultarListaPersonas();
		
		for (Persona persona : listaPersonas) {
						
			System.out.println(persona);
		}
		
	}
	
	
	private void actulizarPersona() {
		
		long idPersona = Long.parseLong(JOptionPane.showInputDialog("Ingrese el Documento de la Persona a Actualizar"));
		Persona miPersona = miPersonaDao.consultarPersona(idPersona);
		
		if (miPersona!= null) {
			
			System.out.println(miPersona);
			
			miPersona.setNombre(JOptionPane.showInputDialog("Modifica tu nombre"));
			miPersona.setProfesion("Modifica tu telefono");
			miPersona.setProfesion(JOptionPane.showInputDialog("Actualiza tu Profesion o Profesiones"));
			System.out.println(miPersonaDao.actualizarPersona(miPersona) + "\n");
			
			
		}else {
			
			JOptionPane.showMessageDialog(null, "La persona con Documento " + idPersona + " no existe en el sistema");
		}
	}
	
	private void eliminaarPersona() {


		long idPersona = Long.parseLong(JOptionPane.showInputDialog("Ingrese el Documento de la Persona que desea eliminar"));
		Persona miPersona = miPersonaDao.consultarPersona(idPersona);
		
		if (miPersona!= null) {
			
			System.out.println(miPersona);
			System.out.println(miPersonaDao.eliminarPersona(miPersona));
			
		}  else {
			
			JOptionPane.showMessageDialog(null, "La persona con Documento " + idPersona + " no existe en el sistema");
		}
	}
	
	
	
}
