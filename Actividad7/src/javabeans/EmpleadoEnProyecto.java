package javabeans;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Objects;

import modelo.dao.AbstractDaoMy8;

public class EmpleadoEnProyecto extends AbstractDaoMy8{

	private int numeroOrden;
	private Proyecto proyecto;
	private Empleado empleado;
	private int horasAsignadas;
	private Date fechaIncorporacion;
	private double precioHora;
	
	//getters y setters
	public int getNumeroOrden() {
		return numeroOrden;
	}
	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public int getHorasAsignadas() {
		return horasAsignadas;
	}
	public void setHorasAsignadas(int horasAsignadas) {
		this.horasAsignadas = horasAsignadas;
	}
	public Date getFechaIncorporacion() {
		return fechaIncorporacion;
	}
	public void setFechaIncorporacion(Date fechaIncorporacion) {
		this.fechaIncorporacion = fechaIncorporacion;
	}
	public double getPrecioHora() {
		return precioHora;
	}
	public void setPrecioHora(double precioHora) {
		this.precioHora = precioHora;
	}
	
	
	//constructor vacío y con todo
	public EmpleadoEnProyecto() {
		super();
	}
	public EmpleadoEnProyecto(int numeroOrden, Proyecto proyecto, Empleado empleado, int horasAsignadas,
			Date fechaIncorporacion, double precioHora) {
		super();
		this.numeroOrden = numeroOrden;
		this.proyecto = proyecto;
		this.empleado = empleado;
		this.horasAsignadas = horasAsignadas;
		this.fechaIncorporacion = fechaIncorporacion;
		this.precioHora = precioHora;
	}
	
	//toString()
	@Override
	public String toString() {
		return "EmpleadosEnProyecto [numeroOrden=" + numeroOrden + ", proyecto=" + proyecto + ", empleado=" + empleado
				+ ", horasAsignadas=" + horasAsignadas + ", fechaIncorporacion=" + fechaIncorporacion
				+ ", precioHora=" + precioHora + "]";
	}
	
	//equals y hashCode()
	@Override
	public int hashCode() {
		return Objects.hash(numeroOrden);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpleadoEnProyecto other = (EmpleadoEnProyecto) obj;
		return numeroOrden == other.numeroOrden;
	}
	
	//métodos propios
	
	public double costeHorasAsignadas() {
		sql = "select (horas_asignadas * precio_hora) as coste_hora from proyecto_con_empleados";
		double coste = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				coste = rs.getDouble("coste_hora");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return coste;
	}
	
	//he decidido sobrecargar el método para que tambien puedas obtener el coste de las horas asignadas según el número de orden
	public double costeHorasAsignadas(int numeroOrden) {
		sql = "select (horas_asignadas * precio_hora) as coste_hora from proyecto_con_empleados where numero_orden = ?";
		double coste = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, numeroOrden);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				coste = rs.getDouble("coste_hora");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return coste;
	}
}
