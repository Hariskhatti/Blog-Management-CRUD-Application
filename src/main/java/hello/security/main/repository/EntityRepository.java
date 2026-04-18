package hello.security.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hello.security.main.entity.RestEntity;
@Repository
public interface EntityRepository extends JpaRepository<RestEntity, Long>{
	RestEntity findByEmail(String username);
	RestEntity findByEmailAndPassword(String email, String password);
}



