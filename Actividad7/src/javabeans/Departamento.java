package javabeans;

import java.util.Objects;

public class Departamento {
	
	private int idDepar;
	private String nombre, direccion;
	
//getter and setter	
	public int getIdDepar() {
		return idDepar;
	}
	public void setIdDepar(int idDepar) {
		this.idDepar = idDepar;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
// constructor vacío y con todo
	public Departamento(int idDepar, String nombre, String direccion) {
		super();
		this.idDepar = idDepar;
		this.nombre = nombre;
		this.direccion = direccion;
	}
	public Departamento() {
		super();
	}
	
	//toString()
	
	@Override
	public String toString() {
		return "Departamento [idDepar=" + idDepar + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}
	
	//equals y hashCode
	@Override
	public int hashCode() {
		return Objects.hash(idDepar);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return idDepar == other.idDepar;
	}
	
	
}
