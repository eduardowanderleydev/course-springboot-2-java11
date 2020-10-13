package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;

@RestController 
@RequestMapping(value = "/orders") //fornece o mapeamento entre o caminho da solicitação e o método manipulador.
public class OrderResource {

	@Autowired 
	private OrderService service;
	
	@GetMapping // Notação para mapeamento de solicitações HTTP GET em métodos manipuladores específicos.
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) { // essa anotação vincula o espaço reservado do URI a um parâmetro de método dentro do método manipulador.
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}