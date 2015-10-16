package com.onlinemarketplace.datamanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinemarketplace.dataentity.domain.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
