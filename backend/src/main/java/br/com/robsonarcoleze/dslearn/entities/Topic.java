package br.com.robsonarcoleze.dslearn.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
public class Topic implements Serializable{
	private static final long serialVersionUID = 1L;

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
	
	@ManyToOne
	@JoinColumn(name = "reply_id")
	@Getter @Setter @NonNull private Reply answer;
	
	@OneToMany(mappedBy = "topic")
	@Getter private List<Reply> replies = new ArrayList<>();
	
}
