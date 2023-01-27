package br.com.robsonarcoleze.dslearn.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.robsonarcoleze.dslearn.entities.enums.DeliverStatus;
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
public class Deliver implements Serializable{
	private static final long serialVersionUID = 1L;
	
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
