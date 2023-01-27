package br.com.robsonarcoleze.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.robsonarcoleze.dslearn.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
