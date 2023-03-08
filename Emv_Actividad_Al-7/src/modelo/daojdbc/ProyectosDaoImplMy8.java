package modelo.daojdbc;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.dao.ClienteDao;
import modelo.dao.EmpleadosDao;
import modelo.dao.FacturasDao;
import modelo.dao.ProyectosDao;
import modelo.javabean.Clientes;
import modelo.javabean.Departamentos;
import modelo.javabean.Proyectos;

public class ProyectosDaoImplMy8 extends AbstractDaoMy8 implements ProyectosDao{

	
	ClienteDao clao = new ClienteDaoImplMy8();
	
	@Override
	public String eliminarUno(String idProyecto) {
		sql="delete from proyectos where id_proyecto=?";
		Proyectos proyecto = null;
		
		try {
			proyecto = new Proyectos();
			ps = conn.prepareStatement(sql);
			ps.setNString(1, idProyecto);
			ps.executeUpdate();
			filas2= proyecto.getIdProyecto();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return filas2 ;
	}

	
	
	
	
	@Override
	public int modificarUno(Proyectos proyecto) {
		
		sql = "update proyectos set descripcion = ?, fecha_inicio = ?, fecha_fin_previsto = ?, "
				+ " fecha_fin_real = ?, venta_previsto = ?, costes_previsto = ?, coste_real = ?, estado = ?, "
				+ " jefe_proyecto = ?, cif = ?,  where id_proyecto = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setNString(1, proyecto.getDescripcion());
			ps.setDate(2, proyecto.getFechaInicio());
			ps.setDate(3, proyecto.getFechaFinPrevisto());
			ps.setDate(4, proyecto.getFechaFinReal());
			ps.setDouble(5, proyecto.getVentaPrevisto());
			ps.setDouble(6, proyecto.getCostesPrevisto());
			ps.setDouble(7, proyecto.getCosteReal());
			ps.setNString(8, proyecto.getEstado());
			ps.setInt(9, proyecto.getJefeProyecto());
			ps.setNString(10, proyecto.getCliente().getCif());
			ps.setNString(11, proyecto.getIdProyecto());
		
			filas= ps.executeUpdate();
			filas=1;
			
	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filas;	
	}
	
	
	
	
	
	
	@Override
	public int altaProyectos(Proyectos proyecto) {
		
		    sql = "insert into Proyectos values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return filas;
		}



	

	
	
	

	@Override
	public Proyectos buscarUno(String idProyecto) {
		
		sql="select * from proyectos where id_proyecto=? ";
		Proyectos proyecto = null;
		EmpleadosDao empao = new EmpleadosDaoImplMy8();
		ClienteDao clao = new ClienteDaoImplMy8();
		FacturasDao fao = new FacturasDaoImplMy8();
		
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setNString(1, idProyecto);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				proyecto = new Proyectos();
				proyecto.setIdProyecto(rs.getNString("id_proyecto"));
				proyecto.setDescripcion(rs.getNString("descripcion"));
				proyecto.setFechaInicio(rs.getDate("fecha_inicio"));
				proyecto.setFechaFinPrevisto(rs.getDate("fecha_fin_previsto"));
				proyecto.setFechaFinReal(rs.getDate("fecha_fin_real"));
				proyecto.setVentaPrevisto(rs.getDouble("venta_previsto"));
				proyecto.setCostesPrevisto(rs.getDouble("costes_previsto"));
				proyecto.setCosteReal(rs.getDouble("coste_real"));
				proyecto.setEstado(rs.getNString("estado"));
				proyecto.setJefeProyecto(rs.getInt("jefe_proyecto"));
				proyecto.setCif(rs.getNString("cif"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return proyecto;
	}

	
	
	
	
	@Override
	public List<Proyectos> bucarTodos() {
	
		sql="select * from proyectos";
		
		List<Proyectos> lista = new ArrayList<>();
		EmpleadosDao empao = new EmpleadosDaoImplMy8();
		ClienteDao clao = new ClienteDaoImplMy8();
		FacturasDao fao = new FacturasDaoImplMy8();
		
		try {
			ps= conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Proyectos proyecto = new Proyectos();
		
				proyecto.setIdProyecto(rs.getNString("id_proyecto"));
				proyecto.setDescripcion(rs.getNString("descripcion"));
				proyecto.setFechaInicio(rs.getDate("fecha_inicio"));
				proyecto.setFechaFinPrevisto(rs.getDate("fecha_fin_previsto"));
				proyecto.setFechaFinReal(rs.getDate("fecha_fin_real"));
				proyecto.setVentaPrevisto(rs.getDouble("venta_previsto"));
				proyecto.setCostesPrevisto(rs.getDouble("costes_previsto"));
				proyecto.setCosteReal(rs.getDouble("coste_real"));
				proyecto.setEstado(rs.getNString("estado"));
				proyecto.setJefeProyecto(rs.getInt("jefe_proyecto"));
				proyecto.setCif(rs.getNString("cif"));
				
				//proyecto.setEmpleado(empao.buscarUno(rs.getInt("id_empl")));
				//proyecto.setCliente(clao.buscarUno(rs.getNString("cif")));
				//proyecto.setFactura(fao.buscarUno(rs.getNString("id_factura")));
				
				lista.add(proyecto);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}

	
	
	
	@Override
	public List<Proyectos> proyectosByEstado(String estado) {
		
		sql="select * from proyectos where estado=?";
		List<Proyectos> lista = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, estado);
			rs= ps.executeQuery();
			
			while(rs.next()) {
				
				Proyectos proyecto = new Proyectos();
				proyecto.setIdProyecto(rs.getNString("id_proyecto"));
				proyecto.setDescripcion(rs.getNString("descripcion"));
				proyecto.setFechaInicio(rs.getDate("fecha_inicio"));
				proyecto.setFechaFinPrevisto(rs.getDate("fecha_fin_previsto"));
				proyecto.setFechaFinReal(rs.getDate("fecha_fin_real"));
				proyecto.setVentaPrevisto(rs.getDouble("venta_previsto"));
				proyecto.setCostesPrevisto(rs.getDouble("costes_previsto"));
				proyecto.setCosteReal(rs.getDouble("coste_real"));
				proyecto.setEstado(rs.getNString("estado"));
				proyecto.setJefeProyecto(rs.getInt("jefe_proyecto"));
				proyecto.setCif(rs.getNString("cif"));
				
				//proyecto.setEmpleado(empao.buscarUno(rs.getInt("id_empl")));
				//proyecto.setCliente(clao.buscarUno(rs.getNString("cif")));
				//proyecto.setFactura(fao.buscarUno(rs.getNString("id_factura")));
				
				lista.add(proyecto);	
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	
	
	
	
	@Override
	public List<Proyectos> proyectosByClientes(String cif) {
	
		sql="select * from proyectos where cif=?";
		List<Proyectos> lista = new ArrayList<>();
	
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setNString(1, cif);
			rs= ps.executeQuery();
			
			while(rs.next()) {
				Proyectos proyecto = new Proyectos();
				proyecto.setIdProyecto(rs.getNString("id_proyecto"));
				proyecto.setDescripcion(rs.getNString("descripcion"));
				proyecto.setFechaInicio(rs.getDate("fecha_inicio"));
				proyecto.setFechaFinPrevisto(rs.getDate("fecha_fin_previsto"));
				proyecto.setFechaFinReal(rs.getDate("fecha_fin_real"));
				proyecto.setVentaPrevisto(rs.getDouble("venta_previsto"));
				proyecto.setCostesPrevisto(rs.getDouble("costes_previsto"));
				proyecto.setCosteReal(rs.getDouble("coste_real"));
				proyecto.setEstado(rs.getNString("estado"));
				proyecto.setJefeProyecto(rs.getInt("jefe_proyecto"));
				proyecto.setCif(rs.getNString("cif"));
				
				//proyecto.setEmpleado(empao.buscarUno(rs.getInt("id_empl")));
				//proyecto.setCliente(clao.buscarUno(rs.getNString("cif")));
				//proyecto.setFactura(fao.buscarUno(rs.getNString("id_factura")));
				
				lista.add(proyecto);	
			}	
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	
	
	
	
	@Override
	public List<Proyectos> proyectosByJefeProyectoAndByEstado(int jefeProyecto,String estado) {
		
		sql="select * from proyectos where jefe_proyecto=? and estado=? ";
		List<Proyectos> lista = new ArrayList<>();
		
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, jefeProyecto);
			ps.setString(2, estado);
			rs= ps.executeQuery();
			
			while(rs.next()) {
				Proyectos proyecto = new Proyectos();
				proyecto.setIdProyecto(rs.getNString("id_proyecto"));
				proyecto.setDescripcion(rs.getNString("descripcion"));
				proyecto.setFechaInicio(rs.getDate("fecha_inicio"));
				proyecto.setFechaFinPrevisto(rs.getDate("fecha_fin_previsto"));
				proyecto.setFechaFinReal(rs.getDate("fecha_fin_real"));
				proyecto.setVentaPrevisto(rs.getDouble("venta_previsto"));
				proyecto.setCostesPrevisto(rs.getDouble("costes_previsto"));
				proyecto.setCosteReal(rs.getDouble("coste_real"));
				proyecto.setEstado(rs.getNString("estado"));
				proyecto.setJefeProyecto(rs.getInt("jefe_proyecto"));
				proyecto.setCif(rs.getNString("cif"));
				
				//proyecto.setEmpleado(empao.buscarUno(rs.getInt("id_empl")));
				//proyecto.setCliente(clao.buscarUno(rs.getNString("cif")));
				//proyecto.setFactura(fao.buscarUno(rs.getNString("id_factura")));
				
				lista.add(proyecto);	
			}	
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

		
	
	
		
	
	@Override
	public double importesVentaProyectosTerminados() {

		sql="select venta_previsto from proyectos where estado='TERMINADO'";
		
		Double suma =0.0; //Creamos variable sdouble suma porque  es tipo de dato q nos devuelva la BBDD
		try {
			ps=conn.prepareStatement(sql);
			rs =ps.executeQuery();
			if(rs.next()) {
				
				suma=rs.getDouble("venta_previsto");
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return suma;
	
	}
		
		
	
	@Override
	public double margenBrutoProyectosTerminados() {
		
		//Diferencia suma Importes venta y gastos reales.
		
		sql="select sum(venta_previsto) as suma, sum(coste_real) as resta from proyectos where estado='TERMINADO'";
		
		double suma=0.0;
		double resta=0.0;
		
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				suma = rs.getDouble("suma");
				resta = rs.getDouble("resta");	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return suma-resta;
	}
	
	
	
	
	
	@Override
	public int diasATerminoProyectoTerminados(String idProyecto) {
		
		return 0;
		
	}
}
