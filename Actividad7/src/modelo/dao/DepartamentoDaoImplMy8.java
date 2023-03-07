package modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javabeans.Departamento;

public class DepartamentoDaoImplMy8 extends AbstractDaoMy8 implements DepartamentoDao {

	@Override
	public int altaDepartamento(Departamento dpto) {
		sql = "insert into departamentos values (?, ?, ?)";
		filas = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dpto.getIdDepar());
			ps.setString(2, dpto.getNombre());
			ps.setString(3, dpto.getDireccion());
			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public Departamento buscarUno(int idDepar) {
		sql = "select * from departamentos where id_depar = ?";
		Departamento dp = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idDepar);
			rs = ps.executeQuery();
			if (rs.next()) {
				dp = new Departamento();
				crearObjetoDpto(dp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dp;
	}

	@Override
	public int modificarUno(Departamento dpto) {
		sql = "update departamentos set nombre = ?, direccion = ? where id_depar = ?";
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dpto.getNombre());
			ps.setString(2, dpto.getDireccion());
			ps.setInt(3, dpto.getIdDepar());
			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	
	}

	@Override
	public int eliminarUno(int idDepar) {
		sql = "delete from departamentos where id_depar = ?";
		filas = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idDepar);
			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public List<Departamento> buscarTodos() {
		sql = "select * from departamentos";
		List<Departamento> lista = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Departamento dp = new Departamento();
				crearObjetoDpto(dp);
				lista.add(dp);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	private void crearObjetoDpto(Departamento dp) throws SQLException {
		dp.setIdDepar(rs.getInt("id_depar"));
		dp.setNombre(rs.getString("nombre"));
		dp.setDireccion(rs.getString("direccion"));
	}

}
