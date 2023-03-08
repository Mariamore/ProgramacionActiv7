package modelo.daojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.dao.DepartamentosDao;
import modelo.javabean.Departamentos;


public class DepartamentosDaoImplMy8 extends AbstractDaoMy8 implements DepartamentosDao {
	
	@Override
	public int eliminarUno(int idDepar) {
		sql="delete from departamentos where id_depar=?";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, idDepar);
			filas = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return filas;
	}
	@Override
	public int modificarUno(Departamentos departamento) {
		
		sql="update departamentos set nombre=?, direccion=?	where id_depar=?";
	
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setNString(1, departamento.getNombre());
			ps.setNString(2, departamento.getDireccion());
			ps.setInt(3, departamento.getIdDepar());
			filas = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return filas;
	}
	@Override
	public int altaDepartamentos(Departamentos departamento) {
		
		sql = "insert into departamentos values (?,?,?)";
		
		
		try {
		
			ps = conn.prepareStatement(sql);
			ps.setInt(1, departamento.getIdDepar());
			ps.setNString(2, departamento.getNombre());
			ps.setNString(3, departamento.getDireccion());
			filas = ps.executeUpdate();
					
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return filas;
	}
	@Override
	public Departamentos buscarUno(int idDepar) {
		
		sql="select * from departamentos where id_depar=? ";
		Departamentos depar = null;
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, idDepar);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				depar = new Departamentos();
				depar.setIdDepar(rs.getInt("id_depar"));
				depar.setNombre(rs.getNString("nombre"));
				depar.setDireccion(rs.getNString("direccion"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return depar;	
	}
	
	
	
	
	@Override
	public List<Departamentos> bucarTodos() {
		
		sql="select * from Departamentos";
		
		List<Departamentos> lista = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
		while(rs.next()) {
			Departamentos dp =new Departamentos();
			dp.setIdDepar(rs.getInt("id_depar"));
			dp.setNombre(rs.getNString("nombre"));
			dp.setDireccion(rs.getNString("direccion"));
			lista.add(dp);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

}
