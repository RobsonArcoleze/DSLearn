package br.com.robsonarcoleze.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.robsonarcoleze.dslearn.entities.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long>{

}
