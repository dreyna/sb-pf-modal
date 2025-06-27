package com.example.proyectofinal.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.proyectofinal.dao.ProductoDao;
import com.example.proyectofinal.entity.Producto;
import com.example.proyectofinal.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{
	private final ProductoDao productoDao;

    public ProductoServiceImpl(ProductoDao productoDao) {
        this.productoDao = productoDao;
    }
	@Override
	public int create(Producto t) {
		// TODO Auto-generated method stub
		return productoDao.create(t);
	}

	@Override
	public int update(Producto t) {
		// TODO Auto-generated method stub
		return productoDao.update(t);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		productoDao.delete(id);
	}

	@Override
	public Producto read(Long id) {
		// TODO Auto-generated method stub
		return productoDao.read(id);
	}

	@Override
	public List<Producto> readAll() {
		// TODO Auto-generated method stub
		return productoDao.readAll();
	}

}
