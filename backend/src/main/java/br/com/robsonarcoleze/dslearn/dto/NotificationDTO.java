package br.com.robsonarcoleze.dslearn.dto;

import java.io.Serializable;
import java.time.Instant;

import br.com.robsonarcoleze.dslearn.entities.Notification;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class NotificationDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	@Getter @Setter private Long id;
	@Getter @Setter private String text;
	@Getter @Setter private Instant moment;
	@Getter @Setter private boolean read;
	@Getter @Setter private String route;
	@Getter @Setter private Long userId;
	
	
	public NotificationDTO(Long id, String text, Instant moment, boolean read, String route, Long userId) {
		this.id = id;
		this.text = text;
		this.moment = moment;
		this.read = read;
		this.route = route;
		this.userId = userId;
	}
	
	public NotificationDTO(Notification entity) {
		id = entity.getId();
		text = entity.getText();
		moment = entity.getMoment();
		read = entity.isRead();
		route = entity.getRoute();
		userId = entity.getUser().getId();
	}
		
	
	
}
