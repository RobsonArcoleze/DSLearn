package br.com.robsonarcoleze.dslearn.entities;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name = "tb_task")
public class Task extends Lesson {
	private static final long serialVersionUID = 1L;

	@Column(columnDefinition = "TEXT")
	@Getter @Setter private String description;
	@Getter @Setter private Integer questionCount; 
	@Getter @Setter private Integer approvalCount;
	@Getter @Setter private Double weight;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	@Getter @Setter private Instant dueDate;

	public Task(@NonNull Long id, @NonNull String title, @NonNull Integer position, @NonNull Section section,
			String description, Integer questionCount, Integer approvalCount, Double weight, Instant dueDate) {
		super(id, title, position, section);
		this.description = description;
		this.questionCount = questionCount;
		this.approvalCount = approvalCount;
		this.weight = weight;
		this.dueDate = dueDate;
	}
	
	
}
