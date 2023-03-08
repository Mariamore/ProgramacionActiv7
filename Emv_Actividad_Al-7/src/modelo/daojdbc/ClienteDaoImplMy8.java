package modelo.daojdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.dao.ClienteDao;
import modelo.javabean.Clientes;

public class ClienteDaoImplMy8 extends  AbstractDaoMy8 implements ClienteDao{
	

	@Override
	public String eliminarUno(String cif) {
		sql="delete from clientes where cif=?";
		Clientes cliente = null;
		
		try {
			cliente = new Clientes();
			ps = conn.prepareStatement(sql);
			ps.setNString(1, cif);
			ps.executeUpdate();
			filas2= cliente.getCif();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return filas2 ;
		
	}

	@Override
	public String modificarUno(Clientes cliente) {
		
		sql ="update clientes set nombre = ?, apellidos = ?, domicilio = ?, facturacion_anual = ?, numero_empleados = ? where cif = ?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setNString(1, cliente.getNombre());
			ps.setNString(2, cliente.getApellidos());
			ps.setNString(3, cliente.getDomicilio());
			ps.setDouble(4, cliente.getFacturacionAnual());
			ps.setInt(5, cliente.getNumeroEmpleados());
			ps.setNString(6, cliente.getCif());
			
			ps.executeUpdate();
			filas2 = cliente.getCif();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return filas2;
	
	}

	@Override
	public String altaClientes(Clientes cliente) {
		sql="insert into Clientes values (?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setNString(1, cliente.getCif());
			ps.setNString(2, cliente.getNombre());
			ps.setNString(3, cliente.getApellidos());
			ps.setNString(4, cliente.getDomicilio());
			ps.setDouble(5, cliente.getFacturacionAnual());
			ps.setInt(6, cliente.getNumeroEmpleados());
			
			ps.executeUpdate();
			filas2 = cliente.getCif();
			
		} catch (SQLException e) {


			e.printStackTrace();
		}
		
		return filas2;
	
		
	}

	@Override
	public Clientes buscarUno(String cif) {
		
		sql="select * from Clientes where cif=?";
		Clientes cliente = null;
		
		try {
		
			ps = conn.prepareStatement(sql);
			ps.setNString(1, cif);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				cliente = new Clientes();
				
				cliente.setCif(rs.getNString("cif"));
				cliente.setNombre(rs.getNString("nombre"));
				cliente.setApellidos(rs.getNString("apellidos"));
				cliente.setDomicilio(rs.getNString("domicilio"));
				cliente.setFacturacionAnual(rs.getDouble("facturacion_anual"));
				cliente.setNumeroEmpleados(rs.getInt("numero_empleados"));
				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cliente;
	}

	@Override
	public List<Clientes> bucarTodos() {
		sql= "select * from clientes";
		List<Clientes> lista = new ArrayList<>();
		Clientes cliente = null;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
		while(rs.next()) {
			cliente = new Clientes();
			
			cliente.setCif(rs.getNString("cif"));
			cliente.setNombre(rs.getNString("nombre"));
			cliente.setApellidos(rs.getNString("apellidos"));
			cliente.setDomicilio(rs.getNString("domicilio"));
			cliente.setFacturacionAnual(rs.getDouble("facturacion_anual"));
			cliente.setNumeroEmpleados(rs.getInt("numero_empleados"));
			
			lista.add(cliente);
		}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	
	}

	
	
	
	
	
	
	

}
