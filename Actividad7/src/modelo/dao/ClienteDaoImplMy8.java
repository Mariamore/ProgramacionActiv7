package modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javabeans.Cliente;

public class ClienteDaoImplMy8 extends AbstractDaoMy8 implements ClienteDao  {

	@Override
	public int altaCliente(Cliente cliente) {
		sql = "insert into clientes values (?, ?, ?, ?, ?, ?)";
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cliente.getCif());
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getApellidos());
			ps.setString(4, cliente.getDomicilio());
			ps.setDouble(5, cliente.getFacturacionAnual());
			ps.setInt(6, cliente.getNumeroEmpleados());
			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public Cliente buscarUno(String cif) {
		sql = "select * from clientes where cif = ?";
		Cliente cl = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cif);
			rs = ps.executeQuery();
			if (rs.next()) {
				cl = new Cliente();
				crearObjetoCuenta(cl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cl;
	}

	@Override
	public int modificarUno(Cliente cliente) {
		sql ="update clientes set nombre = ?, apellidos = ?, domicilio = ?, facturacion_anual = ?, numero_empleados = ? where cif = ?";
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellidos());
			ps.setString(3, cliente.getDomicilio());
			ps.setDouble(4, cliente.getFacturacionAnual());
			ps.setInt(5, cliente.getNumeroEmpleados());
			ps.setString(6, cliente.getCif());
			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int eliminarUno(String cif) {
		sql = "delete from clientes where cif = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cif);
			filas = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public List<Cliente> buscarTodos() {
		sql = "select * from clientes";
		List<Cliente> lista = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Cliente cl = new Cliente();
				crearObjetoCuenta(cl);
				lista.add(cl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	private void crearObjetoCuenta(Cliente cl) throws SQLException {
		cl.setCif(rs.getString("cif"));
		cl.setNombre(rs.getString("nombre"));
		cl.setApellidos(rs.getString("apellidos"));
		cl.setDomicilio(rs.getString("domicilio"));
		cl.setFacturacionAnual(rs.getDouble("facturacion_anual"));
		cl.setNumeroEmpleados(rs.getInt("numero_empleados"));
	}

}
