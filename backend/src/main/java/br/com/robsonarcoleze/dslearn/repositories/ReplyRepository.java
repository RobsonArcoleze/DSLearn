package br.com.robsonarcoleze.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.robsonarcoleze.dslearn.entities.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long>{

}
