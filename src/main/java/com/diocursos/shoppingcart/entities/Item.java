package com.diocursos.shoppingcart.entities;

import org.springframework.data.redis.core.RedisHash;

import lombok.Builder;
import lombok.Data;

@RedisHash("item")
@Data
@Builder
public class Item {
	private Integer productId;
	private Integer amount;
	
}
