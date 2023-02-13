package br.com.robsonarcoleze.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.robsonarcoleze.dslearn.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
