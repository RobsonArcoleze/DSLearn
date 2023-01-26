package br.com.robsonarcoleze.dslearn.entities;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "tb_topic")
public class Topic {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter @NonNull private Long id;
	
	@Getter @Setter @NonNull private String title;
	
	@Column(columnDefinition = "TEXT")
	@Getter @Setter @NonNull private String body;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	@Getter @Setter @NonNull private Instant moment;
	
	@ManyToOne
	@JoinColumn(name = "offer_id")
	@Getter @Setter @NonNull private Offer offer;
	
	@ManyToOne
	@JoinColumn(name = "lesson_id")
	@Getter @Setter @NonNull private Lesson lesson;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	@Getter @Setter @NonNull private User author;
	
	@ManyToMany
	@JoinTable(name = "tb_topic_likes",
	joinColumns = @JoinColumn(name = "topic_id"),
	inverseJoinColumns = @JoinColumn(name = "user_id"))
	@Getter private Set<User> likes = new HashSet<>();
	
}
