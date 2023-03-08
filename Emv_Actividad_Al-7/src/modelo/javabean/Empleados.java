package modelo.javabean;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Objects;



public class Empleados {
	
	private int idEmpl;
	private String nombre;
	private String apellidos;
	private String sexo;
	private String email;
	private String password;
	private double salario;
	private Date fechaIngreso;
	private Date fechaNacimiento;
	// AÑADIMOS ATRIBUTO PARA EL METODO
	
	private Departamentos departamento;
	private Perfiles perfil;
	
	public Empleados() {
		super();
	}
	
	public Empleados(int idEmpl, String nombre, String apellidos, String sexo, String email, String password,
			double salario, Date fechaIngreso, Date fechaNacimiento, Departamentos departamento, Perfiles perfil) {
		super();
		this.idEmpl = idEmpl;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sexo = sexo;
		this.email = email;
		this.password = password;
		this.salario = salario;
		this.fechaIngreso = fechaIngreso;
		this.fechaNacimiento = fechaNacimiento;
		this.departamento = departamento;
		this.perfil = perfil;
	}



	public int getIdEmpl() {
		return idEmpl;
	}

	public void setIdEmpl(int idEmpl) {
		this.idEmpl = idEmpl;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		
		
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Departamentos getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamentos departamento) {
		this.departamento = departamento;
	}

	public Perfiles getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfiles perfil) {
		this.perfil = perfil;
	}



	@Override
	public String toString() {
		return "Empleados [idEmpl=" + idEmpl + ", nombre=" + nombre + ", apellidos=" + apellidos + ", sexo=" + sexo
				+ ", email=" + email + ", password=" + password + ", salario=" + salario + ", fechaIngreso="
				+ fechaIngreso + ", fechaNacimiento=" + fechaNacimiento + ", departamento=" + departamento + ", perfil="
				+ perfil + "]";
	}

	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(departamento, idEmpl, perfil);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleados other = (Empleados) obj;
		return Objects.equals(departamento, other.departamento) && idEmpl == other.idEmpl
				&& Objects.equals(perfil, other.perfil);
	}

	public  double salarioBruto(){
		return  this.salario;	
	}
	
	public void salarioMensual() {
	 int meses= (int) (salarioBruto()/12);
	 System.out.println(meses +"€ de Salario mensual");
	}
	/*
	 * Al poner el sexo como String, usamos el equals.
	 */
	public String literalSexo(){
	Empleados emp = new Empleados();
		
		if(emp.equals("H"))
			return "Hombre";
		else
			return "Mujer";
	}
			
	
	public String obtenerEmail(){
		
	return
	  this.nombre.charAt(0) +
	  this.apellidos.toLowerCase()+"@empleados.com";
	  
	}
	
	public String nombreCompleto() {
		return 
				this.nombre + "  "+ this.apellidos;
		
	}
	
	
	
	
	
	
	
	
	
	

}
