package br.com.robsonarcoleze.dslearn.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "tb_lesson")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Lesson implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter @NonNull private Long id;
	@Getter @Setter @NonNull private String title;
	@Getter @Setter @NonNull private Integer position;
	
	@ManyToOne
	@JoinColumn(name = "section_id")
	@Getter @Setter @NonNull private Section section;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_lessons_done",
	joinColumns = @JoinColumn(name = "lesson_id"),
	inverseJoinColumns = {
			@JoinColumn(name = "user_id"),
			@JoinColumn(name = "offer_id")
			}
	)
	@Getter private Set<Enrollment> enrollmentsDone = new HashSet<>();
}
