package hello.security.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hello.security.main.entity.BlogEntity;
import hello.security.main.entity.RestEntity;
import hello.security.main.repository.BlogRepository;
import hello.security.main.repository.EntityRepository;
import jakarta.transaction.Transactional;

@Service
public class ServiceClass implements UserDetailsService {
	
	@Autowired
	private EntityRepository repo;
	
	@Autowired
	private BlogRepository blogRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		RestEntity re = repo.findByEmail(username);
		
		return org.springframework.security.core.userdetails.User
			    .withUsername(re.getEmail())
			    .password(re.getPassword())
			    .authorities(
			        re.getRoles().stream()
			            .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
			            .toList()
			    )
			    .accountExpired(false)
			    .accountLocked(false)
			    .credentialsExpired(false)
			    .disabled(false)   // VERY IMPORTANT
			    .build();    
	}
	  @Transactional
	void deleteBlog(String title) {
		blogRepo.deleteByTitle(title);
	}
	  @Transactional
	  BlogEntity addBlog(BlogEntity blog) {
		  return blogRepo.save(blog);
	  }
	  @Transactional
	  BlogEntity editBlog(BlogEntity blog) {
		  return blogRepo.save(blog);
	  }


}
