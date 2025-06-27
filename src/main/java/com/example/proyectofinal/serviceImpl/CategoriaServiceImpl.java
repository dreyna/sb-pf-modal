package com.example.proyectofinal.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.proyectofinal.dao.CategoriaDao;
import com.example.proyectofinal.entity.Categoria;
import com.example.proyectofinal.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	private final CategoriaDao categoriaDao;

    public CategoriaServiceImpl(CategoriaDao categoriaDao) {
        this.categoriaDao = categoriaDao;
    }
	
	@Override
	public int create(Categoria t) {
		// TODO Auto-generated method stub
		return categoriaDao.create(t);
	}

	@Override
	public int update(Categoria t) {
		// TODO Auto-generated method stub
		return categoriaDao.update(t);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		categoriaDao.delete(id);
	}

	@Override
	public Categoria read(Long id) {
		// TODO Auto-generated method stub
		return categoriaDao.read(id);
	}

	@Override
	public List<Categoria> readAll() {
		return categoriaDao.readAll();
	}

}
