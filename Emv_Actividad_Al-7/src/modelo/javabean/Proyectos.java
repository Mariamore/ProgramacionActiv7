package modelo.javabean;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Proyectos {
	
	private String idProyecto;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFinPrevisto;
	private Date fechaFinReal;
	private double ventaPrevisto;
	private double costesPrevisto;
	private double costeReal;
	private String estado;
	private int jefeProyecto;
	private String cif;
	private Date fechaHoy;
	
	private Empleados empleado;
	private Clientes cliente;
	private Facturas factura;
	
	public Proyectos() {
		super();
	}



	public Proyectos(String idProyecto, String descripcion, Date fechaInicio, Date fechaFinPrevisto, Date fechaFinReal,
			double ventaPrevisto, double costesPrevisto, double costeReal, String estado, int jefeProyecto, String cif,
			Date fechaHoy, Empleados empleado, Clientes cliente, Facturas factura) {
		super();
		this.idProyecto = idProyecto;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFinPrevisto = fechaFinPrevisto;
		this.fechaFinReal = fechaFinReal;
		this.ventaPrevisto = ventaPrevisto;
		this.costesPrevisto = costesPrevisto;
		this.costeReal = costeReal;
		this.estado = estado;
		this.jefeProyecto = jefeProyecto;
		this.cif = cif;
		this.fechaHoy = fechaHoy;
		this.empleado = empleado;
		this.cliente = cliente;
		this.factura = factura;
	}




	public Proyectos(String string, String string2, Date date, Date fechaFinPreNueva, Date fechaFinReNueva, double d,
			double e, int i, String string3, int j, Clientes cli) {
		// TODO Auto-generated constructor stub
	}



	public String getIdProyecto() {
		return idProyecto;
	}


	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Date getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public Date getFechaFinPrevisto() {
		return fechaFinPrevisto;
	}


	public void setFechaFinPrevisto(Date fechaFinPrevisto) {
		this.fechaFinPrevisto = fechaFinPrevisto;
	}


	public Date getFechaFinReal() {
		return fechaFinReal;
	}


	public void setFechaFinReal(Date fechaFinReal) {
		this.fechaFinReal = fechaFinReal;
	}


	public double getVentaPrevisto() {
		return ventaPrevisto;
	}


	public void setVentaPrevisto(double ventaPrevisto) {
		this.ventaPrevisto = ventaPrevisto;
	}


	public double getCostesPrevisto() {
		return costesPrevisto;
	}


	public void setCostesPrevisto(double costesPrevisto) {
		this.costesPrevisto = costesPrevisto;
	}


	public double getCosteReal() {
		return costeReal;
	}


	public void setCosteReal(double costeReal) {
		this.costeReal = costeReal;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public int getJefeProyecto() {
		return jefeProyecto;
	}


	public void setJefeProyecto(int jefeProyecto) {
		this.jefeProyecto = jefeProyecto;
	}


	public String getCif() {
		return cif;
	}


	public void setCif(String cif) {
		this.cif = cif;
	}


	public Empleados getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
	}


	public Clientes getCliente() {
		return cliente;
	}


	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}


	public Facturas getFactura() {
		return factura;
	}


	public void setFactura(Facturas factura) {
		this.factura = factura;
	}


	public Date getFechaHoy() {
		return fechaHoy;
	}


	public void setFechaHoy(Date fechaHoy) {
		this.fechaHoy = fechaHoy;
	}


	@Override
	public String toString() {
		return "Proyectos [idProyecto=" + idProyecto + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio
				+ ", fechaFinPrevisto=" + fechaFinPrevisto + ", fechaFinReal=" + fechaFinReal + ", ventaPrevisto="
				+ ventaPrevisto + ", costesPrevisto=" + costesPrevisto + ", costeReal=" + costeReal + ", estado="
				+ estado + ", jefeProyecto=" + jefeProyecto + ", cif=" + cif + ", fechaHoy=" + fechaHoy + ", empleado="
				+ empleado + ", cliente=" + cliente + ", factura=" + factura + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(cif, cliente, empleado, factura);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proyectos other = (Proyectos) obj;
		return Objects.equals(cif, other.cif) && Objects.equals(cliente, other.cliente)
				&& Objects.equals(empleado, other.empleado) && Objects.equals(factura, other.factura);
	}


	/*
	 * margenPrevisto():double. Importe de venta – coste previsto
		margenReal(): double Importe de venta – gastos reales
		diferenciaGastos(): double. Gasto real – gasto previsto
		diferenciaFinPrevistoReal(): int . Días entre fin previsto y fin real
	 */
	
	/*
	 * Metodos propios de Proyectos
	 */
	
	public double margenPrevisto() {
		return ventaPrevisto-costesPrevisto;
	}

	public double margenReal() {
		return ventaPrevisto-costeReal;
	}
	
	public double diferenciaGastos(){
		return costesPrevisto-costeReal;
		
	}
	
	public void  diferenciaFinPrevistoReal() throws ParseException {
		
		

		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-mm-dd");
		
		long dias = fechaFinPrevisto.getTime()-fechaInicio.getTime(); 
		
		TimeUnit diasTotal = TimeUnit.DAYS;
		
		long tiempoTranscurrido = diasTotal.convert(dias,TimeUnit.MILLISECONDS);
		System.out.println(tiempoTranscurrido);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * Proyectos proye = new Proyectos ();
	
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-mm-dd");
		
		Date fechaFinPrevisto = proye.getFechaFinPrevisto();
		Date fechaInicio= proye.getFechaInicio();
		
		long dias = fechaFinPrevisto.getTime()-fechaInicio.getTime(); 
		
		TimeUnit diasTotal = TimeUnit.DAYS;
		
		long tiempoTranscurrido = diasTotal.convert(dias,TimeUnit.MILLISECONDS);
		System.out.println(tiempoTranscurrido);
		
		*/
		
		 ;
	}
	
	
	
	
	
	
	
	
}
