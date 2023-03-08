package modelo.javabean;

import java.util.Objects;

public class Perfiles {
	
	private int idPerfil;
	private String nombre;
	private double precioHora;
	
	

	public Perfiles() {
		super();
	}

	
	
	
	public Perfiles(int idPerfil, String nombre, double precioHora) {
		super();
		this.idPerfil = idPerfil;
		this.nombre = nombre;
		this.precioHora = precioHora;
	}




	public int getIdPerfil() {
		return idPerfil;
	}




	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public double getPrecioHora() {
		return precioHora;
	}




	public void setPrecioHora(double precioHora) {
		this.precioHora = precioHora;
	}




	@Override
	public String toString() {
		return "Perfiles [idPerfil=" + idPerfil + ", nombre=" + nombre + ", precioHora=" + precioHora + "]";
	}




	@Override
	public int hashCode() {
		return Objects.hash(idPerfil);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perfiles other = (Perfiles) obj;
		return idPerfil == other.idPerfil;
	}
	
	
}
