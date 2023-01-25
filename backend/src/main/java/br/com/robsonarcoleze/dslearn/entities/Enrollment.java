package br.com.robsonarcoleze.dslearn.entities;

import java.io.Serializable;
import java.time.Instant;

import br.com.robsonarcoleze.dslearn.entities.pk.EnrollmentPK;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Entity
@Table(name = "tb_enrollment")
public class Enrollment implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private EnrollmentPK id = new EnrollmentPK();
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	@Getter @Setter private Instant enrollMoment;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	@Getter @Setter private Instant refundMoment;
	@Getter @Setter private boolean available;
	@Getter @Setter private boolean onlyUpdate;
	
	
	public Enrollment(User user, Offer offer, Instant enrollMoment, Instant refundMoment, boolean available,
			boolean onlyUpdate) {
		id.setUser(user);
		id.setOffer(offer);
		this.enrollMoment = enrollMoment;
		this.refundMoment = refundMoment;
		this.available = available;
		this.onlyUpdate = onlyUpdate;
	}
	
	

	public User getStudent() {
		return id.getUser();
	}
	
	public void setStudent(User user) {
		id.setUser(user);
	}
	
	public Offer getOffer() {
		return id.getOffer();
	}
	
	public void setOffer(Offer offer) {
		id.setOffer(offer);
	}
}
