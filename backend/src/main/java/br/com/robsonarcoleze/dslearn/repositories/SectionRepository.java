package br.com.robsonarcoleze.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.robsonarcoleze.dslearn.entities.Section;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long>{

}
