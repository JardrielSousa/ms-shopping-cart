package com.diocursos.shoppingcart.repository;

import org.springframework.data.repository.CrudRepository;

import com.diocursos.shoppingcart.entities.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer> {

}
