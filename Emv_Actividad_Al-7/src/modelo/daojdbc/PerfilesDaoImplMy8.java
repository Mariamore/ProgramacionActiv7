package modelo.daojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.dao.PerfilesDao;
import modelo.javabean.Perfiles;

public class PerfilesDaoImplMy8 extends AbstractDaoMy8 implements PerfilesDao{
	
	
	@Override
	public int eliminarUno(int idPerfil) {
		
		sql="delete from perfiles where id_perfil=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idPerfil);
			filas=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return filas;
	}

	@Override
	public int modificarUno(Perfiles perfil) { //REVISARRRRRRR!!!!
		
		sql="update perfiles set nombre=? where id_perfil=?";
		filas=0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setNString(1, perfil.getNombre());
			ps.setInt(2, perfil.getIdPerfil());
			//ps.setDouble(3, perfil.getPrecioHora());
			filas=ps.executeUpdate();
			filas=1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}

	
	
	
	@Override
	public int altaEmpleados(Perfiles perfil) { ////CAMBIARLO PONE ALTA EMPLEADOS
		
		sql="insert into perfiles values (?,?,?)";
		filas=0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, perfil.getIdPerfil());
			ps.setNString(2, perfil.getNombre());
			ps.setDouble(3, perfil.getPrecioHora());
			
			filas = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return filas;
	}

	
	
	
	
	@Override
	public Perfiles buscarUno(int idPerfil) {
		sql="Select * from perfiles where id_perfil=?";
		Perfiles perfil = null; //devuelve nulo para los atributos
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idPerfil);
			rs = ps.executeQuery();
			
		if(rs.next()) {
			perfil = new Perfiles();
			 
			perfil.setIdPerfil(rs.getInt("id_perfil"));
			perfil.setNombre(rs.getNString("nombre"));
			perfil.setPrecioHora(rs.getDouble("precio_hora"));
			
		}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return perfil;
		
	
	}
	
	
	
	
	@Override
	public List<Perfiles> bucarTodos() {
		sql= "select * from Perfiles";
		List<Perfiles> lista = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
		while(rs.next()) {
			Perfiles pl =new Perfiles();
			pl.setIdPerfil(rs.getInt("id_perfil"));
			pl.setNombre(rs.getNString("nombre"));
			pl.setPrecioHora(rs.getDouble("precio_hora"));
			lista.add(pl);
		}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

}
