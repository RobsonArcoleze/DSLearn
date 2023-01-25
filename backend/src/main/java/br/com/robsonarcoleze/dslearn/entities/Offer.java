package br.com.robsonarcoleze.dslearn.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_offer")
public class Offer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter @NonNull private Long id;
	@Getter @Setter @NonNull private String edition;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	@Getter @Setter @NonNull private Instant startMoment;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	@Getter @Setter @NonNull private Instant endMoment;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	@Getter @Setter @NonNull private Course course;
	
	@OneToMany(mappedBy = "offer")
	@Getter private List<Resource> resources = new ArrayList<>();
}
