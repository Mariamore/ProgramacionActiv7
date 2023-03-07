package modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javabeans.Perfil;

public class PerfilDaoImplMy8 extends AbstractDaoMy8 implements PerfilDao{

	@Override
	public int altaPerfil(Perfil perfil) {
		sql = "insert into perfiles values (?, ?)";
		filas = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, perfil.getIdPerfil());
			ps.setString(2, perfil.getNombre());
			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public Perfil buscarUno(int idPerfil) {
		sql = "select * from perfiles where id_perfil = ?";
		Perfil pf = null;
		 try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idPerfil);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				pf = new Perfil();
				pf.setIdPerfil(rs.getInt("id_perfil"));
				pf.setNombre(rs.getString("nombre"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return pf;
	}

	@Override
	public int modificarUno(Perfil perfil) {
		sql = "update perfiles set nombre = ? where id_perfil = ?";
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, perfil.getNombre());
			ps.setInt(2, perfil.getIdPerfil());
			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int eliminarUno(int idPerfil) {
		sql = "delete from perfiles where id_perfil = ?";
		filas = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idPerfil);
			filas = ps.executeUpdate();
			filas = 1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public List<Perfil> buscarTodos() {
		sql = "select * from perfiles";
		List<Perfil> lista = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Perfil pf = new Perfil();
				pf.setIdPerfil(rs.getInt("id_perfil"));
				pf.setNombre(rs.getString("nombre"));
				lista.add(pf);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

}
