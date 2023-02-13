package br.com.robsonarcoleze.dslearn.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.robsonarcoleze.dslearn.dto.NotificationDTO;
import br.com.robsonarcoleze.dslearn.services.NotificationService;

@RestController
@RequestMapping(value = "/notifications")
public class NotificationResource {

	@Autowired
	private NotificationService service;
	
	@GetMapping
	public ResponseEntity<Page<NotificationDTO>> notificationsForCurrentUser(
			@RequestParam(name = "unreadOnly", defaultValue = "false") Boolean unreadOnly,
			Pageable pageable){
		Page<NotificationDTO> page = service.notificationsForCurrentUser(unreadOnly ,pageable);
		return ResponseEntity.ok().body(page);
	}
}
