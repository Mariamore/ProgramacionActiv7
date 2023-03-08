package modelo.javabean;

public class Facturas {

	private String idFacturas;
	private String descripcion;
	private String idProyecto;
	
	public Facturas() {
		super();
	}

	public Facturas(String idFacturas, String descripcion, String idProyecto) {
		super();
		this.idFacturas = idFacturas;
		this.descripcion = descripcion;
		this.idProyecto = idProyecto;
	}

	public String getIdFacturas() {
		return idFacturas;
	}

	public void setIdFacturas(String idFacturas) {
		this.idFacturas = idFacturas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}

	@Override
	public String toString() {
		return "Facturas [idFacturas=" + idFacturas + ", descripcion=" + descripcion + ", idProyecto=" + idProyecto
				+ "]";
	}
	
	
	
	
	
}
