package hello.security.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hello.security.main.entity.BlogEntity;

public interface BlogRepository extends JpaRepository<BlogEntity, Long>{

	BlogEntity findByTitle (String title);
	BlogEntity deleteByTitle(String title);
	BlogEntity findById(long id);
}
