package br.com.robsonarcoleze.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.robsonarcoleze.dslearn.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String username);

}
