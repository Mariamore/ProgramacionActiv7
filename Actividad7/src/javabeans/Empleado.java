package javabeans;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Objects;

import modelo.dao.AbstractDaoMy8;

public class Empleado extends AbstractDaoMy8{
	private int idEmpl;
	private String nombre, apellidos, genero, email, password;
	private double salario;
	private Date fechaIngreso, fechaNacimiento;
	private Perfil perfil;
	private Departamento dpto;
	
	//getters y setters
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
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	public Departamento getDpto() {
		return dpto;
	}
	public void setDpto(Departamento dpto) {
		this.dpto = dpto;
	}
	
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	//constructor vacío y con todo

	
	public Empleado() {
		super();
	}
	
	
	
	public Empleado(int idEmpl, String nombre, String apellidos, String genero, String email, String password,
			double salario, Date fechaIngreso, Date fechaNacimiento, Perfil perfil, Departamento dpto) {
		super();
		this.idEmpl = idEmpl;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.genero = genero;
		this.email = email;
		this.password = password;
		this.salario = salario;
		this.fechaIngreso = fechaIngreso;
		this.fechaNacimiento = fechaNacimiento;
		this.perfil = perfil;
		this.dpto = dpto;
	}
	//toString()
	@Override
	public String toString() {
		return "Empleado [idEmpl=" + idEmpl + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ ", password=" + password + ", genero=" + genero + ", salario=" + salario + ", fechaIngreso="
				+ fechaIngreso + ", fechaNacimiento=" + fechaNacimiento + ", perfil=" + perfil + ", dpto=" + dpto + "]";
	}
	
	//equals y hashCode
	@Override
	public int hashCode() {
		return Objects.hash(idEmpl);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return idEmpl == other.idEmpl;
	}
	//métodos propios
	
	public double salarioBruto() {
		
		sql = "select salario from empleados where id_empl = ?";
		double salario = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idEmpl);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				
				salario = rs.getDouble("salario");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return salario;
	
	}
	
	public double SalarioMensual(int meses) {
		sql = "select (salario/?) as salario_mensual from empleados where id_empl = ?";
		double salarioMens = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, meses);
			ps.setInt(2, idEmpl);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				salarioMens = rs.getDouble("salario_mensual");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return salarioMens;
	}
	
	public String literalSexo() {
		sql = "select genero from empleados where id_empl = ?";
		String litSexo = null;
		String gen = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, idEmpl);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				gen = rs.getString("genero");
				switch (gen) {
				case "M":
					litSexo = "Mujer";
					break;
				case "H":
					litSexo = "Hombre";
					break;
				default:
					litSexo = "Género incorrecto";
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return litSexo;
		
	}
	
	public String obtenerEmail() {
		sql = "select email from empleados where id_empl = ?";
		String email = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idEmpl);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				email = rs.getString("email");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return email;
	}
	
	public String nombreCompleto() {
		sql = "select concat(nombre, ' ', apellidos) as nombre_apellidos from empleados where id_empl = ?";
		String nombreAp = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idEmpl);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				nombreAp = rs.getString("nombre_apellidos");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nombreAp;
	}
}
