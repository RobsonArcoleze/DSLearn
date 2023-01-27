package br.com.robsonarcoleze.dslearn.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_section")
public class Section implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Long id;
	@Getter @Setter private String title;
	
	@Column(columnDefinition = "TEXT")
	@Getter @Setter private String description;
	
	@Getter @Setter private Integer position;
	@Getter @Setter private String imgUri;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "resource_id")
	@Getter @Setter private Resource resource;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "prerequisite_id")
	@Getter @Setter private Section prerequisite;
}
