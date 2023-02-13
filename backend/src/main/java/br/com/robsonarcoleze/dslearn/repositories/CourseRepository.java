package br.com.robsonarcoleze.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.robsonarcoleze.dslearn.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
