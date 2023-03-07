package modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javabeans.Proyecto;

public class ProyectoDaoImplMy8 extends AbstractDaoMy8 implements ProyectoDao {
	
	
	private ClienteDao cDao;
	
	public ProyectoDaoImplMy8() {
		
		cDao = new ClienteDaoImplMy8();
	}

	@Override
	public int altaProyecto(Proyecto proyecto) {
		sql = "insert into proyectos values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		filas = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, proyecto.getIdProyecto());
			ps.setString(2, proyecto.getDescripcion());
			ps.setDate(3, proyecto.getFechaInicio());
			ps.setDate(4, proyecto.getFechaFinPrevisto());
			ps.setDate(5, proyecto.getFechaFinReal());
			ps.setDouble(6, proyecto.getVentaPrevisto());
			ps.setDouble(7, proyecto.getCostesPrevisto());
			ps.setDouble(8, proyecto.getCosteReal());
			ps.setString(9, proyecto.getEstado());
			ps.setInt(10, proyecto.getJefeProyecto());
			ps.setString(11, proyecto.getCliente().getCif());
			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public Proyecto buscarUno(String idProyecto) {
		sql = "select * from proyectos where id_proyecto = ?";
		Proyecto proy = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, idProyecto);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				proy = new Proyecto();
				crearObjetoProyecto(proy);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return proy;
	}

	@Override
	public int modificarUno(Proyecto proyecto) {
		sql = "update proyectos set descripcion = ?, fecha_inicio = ?, fecha_fin_previsto = ?, "
				+ " fecha_fin_real = ?, venta_previsto = ?, costes_previsto = ?, coste_real = ?, estado = ?, "
				+ " jefe_proyecto = ?, cif = ? where id_proyecto = ?";
		filas = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, proyecto.getDescripcion());
			ps.setDate(2, proyecto.getFechaInicio());
			ps.setDate(3, proyecto.getFechaFinPrevisto());
			ps.setDate(4, proyecto.getFechaFinReal());
			ps.setDouble(5, proyecto.getVentaPrevisto());
			ps.setDouble(6, proyecto.getCostesPrevisto());
			ps.setDouble(7, proyecto.getCosteReal());
			ps.setString(8, proyecto.getEstado());
			ps.setInt(9, proyecto.getJefeProyecto());
			ps.setString(10, proyecto.getCliente().getCif());
			ps.setString(11, proyecto.getIdProyecto());
			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int eliminarUno(String idProyecto) {
		sql = "delete from proyectos where id_proyecto = ?";
		filas = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, idProyecto);
			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public List<Proyecto> buscarTodos() {
		sql = "select * from proyectos";
		List<Proyecto> lista = new ArrayList<>();
		Proyecto proy = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				proy = new Proyecto();
				crearObjetoProyecto(proy);
				lista.add(proy);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public List<Proyecto> proyectosByEstado(String estado) {
		sql = "select * from proyectos where estado = ?";
		List<Proyecto> lista = new ArrayList<>();
		Proyecto proy = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, estado);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				proy = new Proyecto();
				crearObjetoProyecto(proy);
				lista.add(proy);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public List<Proyecto> proyectosByCliente(String cif) {
		sql = "select * from proyectos where cif = ?";
		List<Proyecto> lista = new ArrayList<>();
		Proyecto proy = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cif);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				proy = new Proyecto();
				crearObjetoProyecto(proy);
				lista.add(proy);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	@Override
	public List<Proyecto> proyectosByJefeProyectoAndByEstado(int jefeProyecto, String estado) {
		sql = "select * from proyectos where jefe_proyecto = ? and estado = ?";
		List<Proyecto> lista = new ArrayList<>();
		Proyecto proy = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, jefeProyecto);
			ps.setString(2, estado);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				proy = new Proyecto();
				crearObjetoProyecto(proy);
				lista.add(proy);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	} 
	 
	@Override
	public double importesVentaProyectosTerminados() {
		sql = "select sum(venta_previsto) from proyectos where estado = 'TERMINADO'";
		double suma = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				suma = rs.getDouble(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return suma;
	}

	@Override
	public double margenBrutoProyectosTerminados() {
		sql = "select sum(venta_previsto - coste_real) as margen_bruto from proyectos where estado = 'TERMINADO'";
		double suma = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				suma = rs.getDouble("margen_bruto");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return suma;
	}

	@Override
	public int diasATerminoProyectoActivo(String idProyecto) {
		sql = "select datediff(fecha_fin_previsto, curdate()) as dias_termino from proyectos where (id_proyecto = ? and estado = 'ACTIVO')";
		int dia = 0;
		 
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, idProyecto);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				dia = rs.getInt("dias_termino");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dia;
	}

	
	private void crearObjetoProyecto(Proyecto proy) throws SQLException {
		proy.setIdProyecto(rs.getString("id_proyecto"));
		proy.setDescripcion(rs.getString("descripcion"));
		proy.setFechaInicio(rs.getDate("fecha_inicio"));
		proy.setFechaFinPrevisto(rs.getDate("fecha_fin_previsto"));
		proy.setFechaFinReal(rs.getDate("fecha_fin_real"));
		proy.setVentaPrevisto(rs.getDouble("venta_previsto"));
		proy.setCostesPrevisto(rs.getDouble("costes_previsto"));
		proy.setCosteReal(rs.getDouble("coste_real"));
		proy.setEstado(rs.getString("estado"));
		proy.setJefeProyecto(rs.getInt("jefe_proyecto"));
		proy.setCliente(cDao.buscarUno(rs.getString("cif")));
	}

	
}
