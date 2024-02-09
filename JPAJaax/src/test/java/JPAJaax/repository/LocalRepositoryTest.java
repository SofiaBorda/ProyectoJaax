package JPAJaax.repository;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import JPAJaax.entity.Customer;
import JPAJaax.entity.Local;
import JPAJaax.entity.Manager;
import JPAJaax.entity.Order;

@SpringBootTest
class LocalRepositoryTest {
	@Autowired
	private LocalRepository localRepository;


	@Test
	public void saveLocal() {
		Manager manager = Manager.builder()
				.firstName("Juan")
				.lastName("Perez")
				.build();
				
		Local local = Local.builder()
				.name("PetShop")
				.floor("Second Floor")
				.manager(manager)
				.build();
		localRepository.save(local);
	}
	/*@Test
	public void findAllLocals() {
		List<Local> localList = localRepository.findAll();
		System.out.println("LicalList= " + localList);
	}*/
	@Test
	public void saveLocalWithOrders() {
		
		Manager manager = Manager.builder()
				.firstName("Juana")
				.lastName("Rodriguez")
				.build();
		
		Order order = Order.builder()
				.description("Pelicula")
				.price(6.50)
				.build();
		
		Order order2 = Order.builder()
				.description("Pelicula2")
				.price(8.50)
				.build();
		
		Local local = Local.builder()
				.name("Cinema")
				.floor("Thrid floor")
				.manager(manager)
				//.orderList(List.of(order,order2))
				.build();
		localRepository.save(local);
	}
	@Test
	public void findAllLocalsWithOrders() {
		List<Local> localList = localRepository.findAll();
		System.out.println("Locales con order= " + localList);
	}
	@Test 
	public void saveLocalWithCustomer() {
		Customer customer = Customer.builder()
				.firstName("Laura")
				.lastName("Borda")
				.email("laura@gmail.com")
				.build();
		Customer customer2 = Customer.builder()
				.firstName("Carl")
				.lastName("Jhonson")
				.email("carl@gmail.com")
				.build();
		
		Local local = Local.builder()
						.name("Local")
						.floor("First floor")
						.customerList(List.of(customer,customer2))
						.build();
		localRepository.save(local);
	}
	@Test
	public void findCustomersByLocal() {
		Local local = localRepository.findById(1L).get();
		List<Customer> customerList = local.getCustomerList();
		System.out.println("CustomerList= " + customerList);
	}
}
