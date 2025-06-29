package com.example.proyectofinal.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.proyectofinal.entity.Producto;
import com.example.proyectofinal.service.CategoriaService;
import com.example.proyectofinal.service.ProductoService;


@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	private final ProductoService productoService;
	private final CategoriaService categoriaService;
	
    public ProductoController(ProductoService productoService, CategoriaService categoriaService) {
        this.productoService = productoService;
        this.categoriaService = categoriaService;
    }
    
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("productos", productoService.readAll());
        model.addAttribute("producto", new Producto()); // ← ¡ESTO ES OBLIGATORIO!
        model.addAttribute("categorias", categoriaService.readAll());
        return "productos/index";
    }
   

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", categoriaService.readAll());
        return "productos/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Producto producto) {
    	System.out.println("Producto a guardar: " + producto.getNombre() + " / " + producto.getPrecio() + " / " + producto.getCategoriaId());
        if (producto.getId() == null) {
        	productoService.create(producto);
        } else {
        	productoService.update(producto);
        }
        return "redirect:/productos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Producto producto = productoService.read(id);
        model.addAttribute("producto", producto);
        model.addAttribute("productos", productoService.read(id));
        return "productos/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
    	productoService.delete(id);
        return "redirect:/productos";
    }
}
