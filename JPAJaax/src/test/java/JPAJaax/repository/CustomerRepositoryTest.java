package JPAJaax.repository;


import JPAJaax.entity.Address;
import JPAJaax.entity.Customer;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;




@SpringBootTest
class CustomerRepositoryTest {
	
	@Autowired
	CustomerRepository customerRepository;

	 @Test
	 public void saveCustomer(){
	        Customer customer = Customer.builder()
	                .firstName("Jaax")
	                .lastName("Team")
	                .email("jaax@ejemplo.com")
	                .build();

	        customerRepository.save(customer);
	 }
	@Test
	public void saveCustomerWithAddressEmbbeded() {
		Address address = Address.builder()
				.city("Quito")
				.mainStreet("Av. 56")
				.secondaryStreet("Atahualpa")
				.build();
				
		Customer customer = Customer.builder()
                .firstName("Jaax")
                .lastName("Team")
                .email("jaax@ejemploo.com")
                .address(address)
                .build();

        customerRepository.save(customer);
	}
	@Test
	public void findCustomerByFirstName() {
		Customer customer=customerRepository.findByFirstName("Jaax").get();
		System.out.println("customer por nombre= " + customer);
	}
	
	@Test
	public void findAllCustomers() {
		List<Customer> customer = customerRepository.findAll();
		System.out.println("Todos los customers= " + customer);
	}
	@Test
	public void findAllCustomersFirstNameContaining() {
		List<Customer> customerList = customerRepository.findByFirstNameContaining("Ja");
		System.out.println("CustomerList por contenido del nombre = " + customerList);
	}
	@Test
	public void findAllCustomersLastNameNotNull() {
		List<Customer> customerList = customerRepository.findByLastNameNotNull();
		System.out.println("customerList por apellido not null = " + customerList);
	}
	@Test
	public void findAllCustomerByAddressCity() {
		List<Customer> customerList = customerRepository.findByAddress_city("Quito");
		System.out.println("Customer por ciudad = " + customerList);
	}
	@Test
	public void getCustomerByEmailAddres() {
		Customer customer = customerRepository.getCustomerByEmailAddres("jaax@ejemplo.com");
		System.out.println("Customer por email = " + customer);
	}
	@Test
	public void getCustomerFirstNameByEmailAddress() {
		String customer = customerRepository.getCustomerFirstNameByEmailAddress("jaax@ejemplo.com");
		System.out.println("Customer por correo" + customer);
	}
	@Test
	public void getCustomerByEmailAddressNative() {
		Customer customer = customerRepository.getCustomerByEmailAddressNative("jaax@ejemplo.com");
		System.out.println("Cliente= " +  customer);
	}
	@Test
	public void getCustomerByEmailAddressNativeNamedParam() {
		Customer customer = customerRepository.getCustomerByEmailAddressNativeNamedParam("jaax@ejemplo.com");
		System.out.println("Cliente= " +  customer);
	}
	@Test
	public void updateCustomerNameByEmail() {
		customerRepository.updateCustomerNameByEmail("Guido", "jaax@ejemplo.com");
	}
}
