package com.example.proyectofinal.generic;

import java.util.List;

public interface IGeneric<T> {
	  int create(T t);
	  int update(T t);
	  void delete(Long id);
	  T read(Long id);
	  List<T> readAll();
	}