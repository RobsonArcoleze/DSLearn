package br.com.robsonarcoleze.dslearn.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
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
@Table(name = "tb_reply")
public class Reply implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter @NonNull private Long id;
	
	@Column(columnDefinition = "TEXT")
	@Getter @Setter @NonNull private String body;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	@Getter @Setter @NonNull private Instant moment;
	
	@ManyToOne
	@JoinColumn(name = "topic_id")
	@Getter @Setter @NonNull private Topic topic;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	@Getter @Setter @NonNull private User author;
	
	@ManyToMany
	@JoinTable(name = "tb_reply_likes",
	joinColumns = @JoinColumn(name = "reply_id"),
	inverseJoinColumns = @JoinColumn(name = "user_id"))
	@Getter private Set<User> likes = new HashSet<>();
	
	
}
