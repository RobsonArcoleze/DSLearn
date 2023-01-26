package br.com.robsonarcoleze.dslearn.entities;

import java.time.Instant;

import br.com.robsonarcoleze.dslearn.entities.enums.DeliverStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_deliver")
public class Deliver {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter @NonNull private Long id;
	@Getter @Setter @NonNull private String uri;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	@Getter @Setter @NonNull private Instant moment;
	@Getter @Setter @NonNull private DeliverStatus status;
	
	@Column(columnDefinition = "TEXT")
	@Getter @Setter @NonNull private String feedback;
	@Getter @Setter @NonNull private Integer correctCount;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "lesson_id")
	@Getter @Setter @NonNull private Lesson lesson;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "offer_id"),
		@JoinColumn(name = "user_id")
	})
	@Getter @Setter @NonNull private Enrollment enrollment;
}
