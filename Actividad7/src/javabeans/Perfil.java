package javabeans;

import java.util.Objects;

public class Perfil {
	private int idPerfil;
	private String nombre;

	
	//setters y getters
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
	
	
	//constructor vacío y con todo
	public Perfil(int idPerfil, String nombre) {
		super();
		this.idPerfil = idPerfil;
		this.nombre = nombre;
	
	}
	public Perfil() {
		super();
	}
	
	//toString()
	@Override
	public String toString() {
		return "Perfil [idPerfil=" + idPerfil + ", nombre=" + nombre + "]";
	}
	
	//equals y hashCode
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
		Perfil other = (Perfil) obj;
		return idPerfil == other.idPerfil;
	}
	
	
}
