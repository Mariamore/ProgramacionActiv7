package modelo.daojdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.dao.FacturasDao;
import modelo.javabean.Facturas;

public class FacturasDaoImplMy8 extends  AbstractDaoMy8 implements FacturasDao {

	@Override
	public String eliminarUno(String idFactura) {
		sql="delete from facturas where id_factura=?";
		Facturas factura = null;
		try {
			factura = new Facturas();
			ps = conn.prepareStatement(sql);
			ps.setNString(1, idFactura);
			ps.executeUpdate();
			filas2= factura.getIdFacturas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return filas2 ;
	}
	
	

	@Override
	public String modificarUno(Facturas factura) {
	sql= "update facturas set descripcion=?, id_proyecto=? where id_proyecto=?";
	
		try {
			ps = conn.prepareStatement(sql);;
			ps.setNString(1, factura.getDescripcion());
			ps.setNString(2, factura.getIdProyecto());
			ps.setNString(3, factura.getIdFacturas());
			ps.executeUpdate();
			filas2 = factura.getIdFacturas();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return filas2;
				
	}
		
	

	@Override
	public String altaFacturas(Facturas factura) {
		sql="insert into facturas values (?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setNString(1, factura.getIdFacturas());
			ps.setNString(2, factura.getDescripcion());
			ps.setNString(3, factura.getIdProyecto());
			ps.executeUpdate();
			filas2 = factura.getIdFacturas();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return filas2;
	
	}

	@Override
	public Facturas buscarUno(String idFactura) {
		
		sql="select * from facturas where id_factura=?";
		Facturas factura = null;
		
		try {
		
			ps = conn.prepareStatement(sql);
			ps.setNString(1, idFactura);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				factura = new Facturas();
				
				factura.setIdFacturas(rs.getNString("id_factura"));
				factura.setDescripcion(rs.getNString("descripcion"));
				factura.setIdProyecto(rs.getNString("id_proyecto"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return factura;

	}

	@Override
	public List<Facturas> bucarTodos() {
		sql= "select * from facturas";
		List<Facturas> lista = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
		while(rs.next()) {
			Facturas fc =new Facturas();
			fc.setIdFacturas(rs.getNString("id_factura"));
			fc.setDescripcion(rs.getNString("descripcion"));
			fc.setIdProyecto(rs.getNString("id_proyecto"));;
			lista.add(fc);
		}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
		
	}
	
	
	
	
	
	
	
	
	
	

}
