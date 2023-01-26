package br.com.robsonarcoleze.dslearn.entities.pk;

import java.io.Serializable;

import br.com.robsonarcoleze.dslearn.entities.Offer;
import br.com.robsonarcoleze.dslearn.entities.User;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class EnrollmentPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "user_id")
	 private User user;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "offer_id")
	 private Offer offer;
}
