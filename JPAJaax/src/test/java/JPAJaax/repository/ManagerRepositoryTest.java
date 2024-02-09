package JPAJaax.repository;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import JPAJaax.entity.Manager;

@SpringBootTest
class ManagerRepositoryTest {
	
	@Autowired
	private ManagerRepository managerRepository;

	@Test
	public void findAllManagers() {
		List<Manager> manager = managerRepository.findAll();
		System.out.println("ManagerList = " + manager);
	}

}
