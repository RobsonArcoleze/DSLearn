package br.com.robsonarcoleze.dslearn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.robsonarcoleze.dslearn.dto.NotificationDTO;
import br.com.robsonarcoleze.dslearn.entities.Notification;
import br.com.robsonarcoleze.dslearn.entities.User;
import br.com.robsonarcoleze.dslearn.repositories.NotificationRepository;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository repository;
	
	@Autowired
	private AuthService authService;
	
	public Page<NotificationDTO> notificationsForCurrentUser(Pageable pageable){
			User user = authService.authenticated();
			Page<Notification> page = repository.findByUser(user, pageable);
			return page.map(x -> new NotificationDTO(x));
	}
}
