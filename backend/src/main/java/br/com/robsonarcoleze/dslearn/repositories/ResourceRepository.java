package br.com.robsonarcoleze.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.robsonarcoleze.dslearn.entities.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Long>{

}
