package br.com.robsonarcoleze.dslearn.dto;

import java.io.Serializable;

import br.com.robsonarcoleze.dslearn.entities.enums.DeliverStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class DeliverRevisionDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	@Getter @Setter private DeliverStatus status;
	@Getter @Setter private String feedback;
	@Getter @Setter private Integer correctCount;
	
	
	public DeliverRevisionDTO(DeliverStatus status, String feedback, Integer correctCount) {
		this.status = status;
		this.feedback = feedback;
		this.correctCount = correctCount;
	}
	
	
	
	
}
