package com.ualbany.daneeats.repository;

import com.ualbany.daneeats.model.Order;
import com.ualbany.daneeats.model.OrderStatus;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {
	public List<Order> findByStatus(OrderStatus status);
	public List<Order> findByCustomerId(Long id);
	public List<Order> findByCustomerIdAndStatus(Long id, OrderStatus status);
	public List<Order> findByAgentId(Long id);
	
	@Modifying(clearAutomatically = true)
	@Query("select o from Order o where o.agent.id = ?1 and o.status in (?2)")
	public List<Order> findAllByAgentIdAndStatus(Long id, OrderStatus... status);
	
	@Modifying(clearAutomatically = true)
	@Query("update Order o set o.status = ?2 where o.id = ?1")
	int updateOrderStatus(Long id, OrderStatus status);
}
