package JPAJaax.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import JPAJaax.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	Page<Order> findByDescriptionContaining(String description,Pageable pageable);
}
