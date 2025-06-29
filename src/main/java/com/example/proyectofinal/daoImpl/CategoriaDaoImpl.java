package com.example.proyectofinal.daoImpl;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.proyectofinal.dao.CategoriaDao;
import com.example.proyectofinal.entity.Categoria;
@Repository
public class CategoriaDaoImpl implements CategoriaDao{
	private final JdbcTemplate jdbc;

	public CategoriaDaoImpl(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	@SuppressWarnings("unused")
	private Categoria mapRow(ResultSet rs, int rowNum) throws java.sql.SQLException {
        Categoria c = new Categoria();
        c.setId(rs.getLong("id"));
        c.setNombre(rs.getString("nombre"));
        return c;
    }
	@Override
	public int create(Categoria t) {
		// TODO Auto-generated method stub
		return jdbc.update("INSERT INTO categoria(nombre) VALUES(?)", t.getNombre());//new Object{}
	}

	@Override
	public int update(Categoria t) {
		// TODO Auto-generated method stub
		return jdbc.update("UPDATE categoria SET nombre=? WHERE id=?", t.getNombre(), t.getId());
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		jdbc.update("DELETE FROM categoria WHERE id=?", id);
	}

	@Override
	public Categoria read(Long id) {
		// TODO Auto-generated method stub
		return jdbc.queryForObject("SELECT * FROM categoria WHERE id = ?", this::mapRow, id);
	}

	@Override
	public List<Categoria> readAll() {
		// TODO Auto-generated method stub
		return jdbc.query("SELECT * FROM categoria", this::mapRow);
	}

}
