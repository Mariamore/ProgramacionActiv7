package modelo.javabean;

import java.sql.Date;
import java.util.Objects;

public class ProyectoConEmpleados {
	
	private int numeroOrden;
	private String idProyecto;
	private int idEmpl;
	private int horasAsignadas;
	private Date fechaIncorporación;
	
	private Empleados empleado;
	private Proyectos proyecto;
	
	public ProyectoConEmpleados() {
		super();
	}

	public ProyectoConEmpleados(int numeroOrden, String idProyecto, int idEmpl, int horasAsignadas,
			Date fechaIncorporación, Empleados empleado, Proyectos proyecto) {
		super();
		this.numeroOrden = numeroOrden;
		this.idProyecto = idProyecto;
		this.idEmpl = idEmpl;
		this.horasAsignadas = horasAsignadas;
		this.fechaIncorporación = fechaIncorporación;
		this.empleado = empleado;
		this.proyecto = proyecto;
	}

	public int getNumeroOrden() {
		return numeroOrden;
	}

	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public String getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}

	public int getIdEmpl() {
		return idEmpl;
	}

	public void setIdEmpl(int idEmpl) {
		this.idEmpl = idEmpl;
	}

	public int getHorasAsignadas() {
		return horasAsignadas;
	}

	public void setHorasAsignadas(int horasAsignadas) {
		this.horasAsignadas = horasAsignadas;
	}

	public Date getFechaIncorporación() {
		return fechaIncorporación;
	}

	public void setFechaIncorporación(Date fechaIncorporación) {
		this.fechaIncorporación = fechaIncorporación;
	}

	public Empleados getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
	}

	public Proyectos getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyectos proyecto) {
		this.proyecto = proyecto;
	}

	@Override
	public String toString() {
		return "ProyectoConEmpleados [numeroOrden=" + numeroOrden + ", idProyecto=" + idProyecto + ", idEmpl=" + idEmpl
				+ ", horasAsignadas=" + horasAsignadas + ", fechaIncorporación=" + fechaIncorporación + ", empleado="
				+ empleado + ", proyecto=" + proyecto + "]";
	}
	
	
	
	/*
	 * Metodos propios de la clase
	 * 
	 * costeHorasAsignadas(): double . Horas * precio/hora
	 * Por tanto para el cálculo se usa el precio_hora del perfil asignado al empleado.
	 */
	
	public double costeHorasAsignadas() {
		
		Empleados emp = new Empleados();
		
		return horasAsignadas*emp.getPerfil().getPrecioHora();
				
	}
	
	
	

}
