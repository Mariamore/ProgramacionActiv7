package javabeans;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Objects;

import modelo.dao.AbstractDaoMy8;

public class Proyecto extends AbstractDaoMy8{
	private String idProyecto, descripcion;
	private Date fechaInicio, fechaFinPrevisto, fechaFinReal;
	private double ventaPrevisto, costesPrevisto, costeReal;
	private String estado;
	private int jefeProyecto;
	private Cliente cliente;
	
	//getters y setters
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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	//toString()
	@Override
	public String toString() {
		return "Proyecto [idProyecto=" + idProyecto + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio
				+ ", fechaFinPrevisto=" + fechaFinPrevisto + ", fechaFinReal=" + fechaFinReal + ", ventaPrevisto="
				+ ventaPrevisto + ", costesPrevisto=" + costesPrevisto + ", costeReal=" + costeReal + ", estado="
				+ estado + ", JefeProyecto=" + jefeProyecto + ", cliente=" + cliente + "]";
	}
	
	//constructor vacío y con todo
	public Proyecto() {
		super();
	}
	public Proyecto(String idProyecto, String descripcion, Date fechaInicio, Date fechaFinPrevisto, Date fechaFinReal,
			double ventaPrevisto, double costesPrevisto, double costeReal, String estado, int jefeProyecto,
			Cliente cliente) {
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
		this.cliente = cliente;
	}
	
	//equals y hashCode
	@Override
	public int hashCode() {
		return Objects.hash(idProyecto);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proyecto other = (Proyecto) obj;
		return Objects.equals(idProyecto, other.idProyecto);
	}
	
	//métodos propios
	
	public double margenPrevisto() {
		sql = "select (venta_previsto - costes_previsto) as margen_previsto from proyectos where id_proyecto = ?";
		double margen = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, idProyecto);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				margen = rs.getDouble("margen_previsto");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return margen;
	}
	
	public double margenReal() {
		sql = "select (venta_previsto - coste_real) as margen_real from proyectos where id_proyecto = ?";
		double margen = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, idProyecto);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				margen = rs.getDouble("margen_real");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return margen;
	}
	
	public double diferenciaGastos() {
		sql = "select (coste_real - costes_previsto) as dif_gastos from proyectos where id_proyecto = ?";
		double gastos = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, idProyecto);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				gastos = rs.getDouble("dif_gastos");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gastos;
	}
	
	public double diferenciaFinPrevistoReal() {
		sql = "select datediff(fecha_fin_previsto, curdate()) as dias_termino from proyectos where (id_proyecto = ? and estado = 'ACTIVO')";
		double fecha = 0;
	
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, idProyecto);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				fecha= rs.getDouble("dias_termino");
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fecha;
	}
	
}
