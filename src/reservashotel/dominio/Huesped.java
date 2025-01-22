package reservashotel.dominio;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Huesped {

	private static final String ER_TELEFONO = "";
	private static final String ER_CORREO = "";
	private static final String ER_DNI = "^(\\\\d{8})([A-Z])$";
	public static final String FORMATO_FECHA = "";

	private String nombre;
	private String telefono;
	private String correo;
	private String dni;
	private LocalDate fechaNacimiento;

	public Huesped(String nombre, String dni, String correo, String telefono, LocalDate fechaNacimiento) {

		setNombre(nombre);
		setDni(dni);
		setCorreo(correo);
		setTelefono(telefono);
		setFechaNacimiento(fechaNacimiento);

	}

	public Huesped(Huesped huesped) {

		setNombre(huesped.getNombre());
		setDni(huesped.getDni());
		setCorreo(huesped.getCorreo());
		setTelefono(huesped.getTelefono());
		setFechaNacimiento(huesped.fechaNacimiento);

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private String formateaNombre(String nombre) {

		String[] partes = nombre.trim().split("\\s+"); // coincide con uno o mas espacios en blanco consecutivos
		String cacdenaFormateada = "";

		for (int i = 0; i < partes.length; i++) {
			cacdenaFormateada = cacdenaFormateada + partes[i].substring(0, 1).toUpperCase()
					+ partes[i].substring(1).toLowerCase() + (i < partes.length - 1 ? " " : "");
		}

		return cacdenaFormateada;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDni() {
		return dni;
	}

	private void setDni(String dni) {
		this.dni = dni;
	}

	private boolean comprobarLetraDni(String dni) {

		Pattern pattern = Pattern.compile(ER_DNI);
		Matcher matcher = pattern.matcher(dni);

		if (matcher.matches()) {
			// Obtener el número y la letra del DNI
			int numeroDni = Integer.parseInt(matcher.group(1));
			char letraDni = matcher.group(2).charAt(0);

			// Array con las letras válidas del DNI
			char[] letrasValidas = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S',
					'Q', 'V', 'H', 'L', 'C', 'K', 'E' };

			// Calcular la letra esperada
			char letraEsperada = letrasValidas[numeroDni % 23];

			// Verificar si la letra del DNI es válida
			return letraDni == letraEsperada;
		}

		// Si no coincide con el formato, el DNI no es válido
		return false;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	private void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
