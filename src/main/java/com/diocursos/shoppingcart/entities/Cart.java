package com.diocursos.shoppingcart.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@RedisHash("cart")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	private Integer id;
	private List<Item> items;
	
	public List<Item> getItems(){
		if(items == null) {
			items = new ArrayList<>();
		}
		return items;
	}

	public Cart(Integer id) {
		this.id = id;
	}
	
	
}
