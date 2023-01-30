package br.com.robsonarcoleze.dslearn.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.robsonarcoleze.dslearn.entities.Notification;
import br.com.robsonarcoleze.dslearn.entities.User;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long>{

	Page<Notification> findByUser(User user, Pageable pageable);
}
