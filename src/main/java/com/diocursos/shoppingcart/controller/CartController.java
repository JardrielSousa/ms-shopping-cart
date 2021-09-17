package com.diocursos.shoppingcart.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diocursos.shoppingcart.entities.Cart;
import com.diocursos.shoppingcart.entities.Item;
import com.diocursos.shoppingcart.repository.CartRepository;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartRepository shoppingCartRepository;
	
	@PostMapping(value = "/{id}")
	public Cart addItem(@PathVariable Integer id, @RequestBody Item item) {
		Optional<Cart> savedCart = shoppingCartRepository.findById(id);
		Cart cart;
		if(savedCart.equals(Optional.empty())) {
			cart = new Cart(id);
		}else {
			cart = savedCart.get();
		}
		cart.getItems().add(item);
		return shoppingCartRepository.save(cart);
	}
	@GetMapping("/")
	public Iterable<Cart> findAll(){
		return shoppingCartRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Cart> findById(@PathVariable Integer id){
		return shoppingCartRepository.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void clear(@PathVariable Integer id) {
		shoppingCartRepository.deleteById(id);
	}
}
