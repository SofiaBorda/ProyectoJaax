package JPAJaax.repository;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import JPAJaax.entity.Local;
import JPAJaax.entity.Order;

@SpringBootTest
class OrderRepositoryTest {
	@Autowired
	OrderRepository orderRepository;

	@Test
	public void saveOrder() {
		Local local = Local.builder()
				.name("Binco")
				.floor("Four floor")
				.build();
		Order order = Order.builder()
				.description("Binco")
				.price(10.2)
				.local(local)
				.build();
		orderRepository.save(order);
	}
	@Test
	public void findAllOrdersPaging() {
		Pageable firstPageWithThreeRecords = PageRequest.of(0, 2);
		List<Order> orderList = orderRepository.findAll(firstPageWithThreeRecords).getContent();
		long totalElements = orderRepository.findAll(firstPageWithThreeRecords).getTotalElements();
		long totalPages = orderRepository.findAll(firstPageWithThreeRecords).getTotalPages();
		System.out.println("orderList= " + orderList);
		System.out.println("total elementos= " + totalElements);
		System.out.println("total pages= " + totalPages);
	}
	@Test 
	public void findAllOrdersWithSorting() {
		Pageable sortByPrice = PageRequest.of(0, 3, Sort.by("price"));
		Pageable sortByPriceDesc = PageRequest.of(0, 3, Sort.by("price").descending());
		List<Order> orderList = orderRepository.findAll(sortByPrice).getContent();
		List<Order> orderListDesc = orderRepository.findAll(sortByPriceDesc).getContent();
		System.out.println("orderList= " + orderList);
		System.out.println("orderListDesc= " + orderListDesc);
	}
	@Test
	public void findAllOrdersDescripcionContaining() {
		Pageable pageable = PageRequest.of(0, 5);
		List<Order> orderList = orderRepository.findByDescriptionContaining("em", pageable).getContent();
		System.out.println("orderList= " + orderList);
	}

}
