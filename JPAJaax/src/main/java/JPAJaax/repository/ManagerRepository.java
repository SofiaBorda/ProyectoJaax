package JPAJaax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import JPAJaax.entity.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long>{

}
