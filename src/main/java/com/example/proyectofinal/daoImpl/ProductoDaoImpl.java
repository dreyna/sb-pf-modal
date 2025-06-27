package com.example.proyectofinal.daoImpl;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.proyectofinal.dao.ProductoDao;
import com.example.proyectofinal.entity.Producto;

@Repository
public class ProductoDaoImpl implements ProductoDao {
	private final JdbcTemplate jdbc;

	public ProductoDaoImpl(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	@SuppressWarnings("unused")
	private Producto mapRow(ResultSet rs, int rowNum) throws java.sql.SQLException {
        Producto c = new Producto();
        c.setId(rs.getLong("id"));
        c.setNombre(rs.getString("nombre"));
        c.setPrecio(rs.getDouble("precio"));
        c.setCategoriaId(rs.getLong("categoria_id"));
        return c;
    }
	@Override
	public int create(Producto t) {
		// TODO Auto-generated method stub
		String SQL = "INSERT INTO producto(nombre, precio, categoria_id) VALUES(?,?,?)";
		return jdbc.update(SQL, t.getNombre(), t.getPrecio(), t.getCategoriaId());
	}

	@Override
	public int update(Producto t) {
		// TODO Auto-generated method stub
		String SQL = "UPDATE producto SET nombre=?, precio=?, categoria_id=? WHERE id=?";
		return jdbc.update(SQL, t.getNombre(), t.getPrecio(), t.getCategoriaId(), t.getId());
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		jdbc.update("DELETE FROM producto WHERE id=?", id);
	}

	@Override
	public Producto read(Long id) {
		// TODO Auto-generated method stub
		return jdbc.queryForObject("SELECT * FROM producto WHERE id = ?", this::mapRow, id);
	}

	@Override
	public List<Producto> readAll() {
		// TODO Auto-generated method stub
		return jdbc.query("SELECT * FROM producto", this::mapRow);
	}

}
