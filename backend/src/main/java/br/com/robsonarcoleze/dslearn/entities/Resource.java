package br.com.robsonarcoleze.dslearn.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.robsonarcoleze.dslearn.entities.enums.ResourceType;
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
@Table(name = "tb_resource")
public class Resource implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter @NonNull private Long id;
	@Getter @Setter @NonNull private String title;
	
	@Column(columnDefinition = "TEXT")
	@Getter @Setter @NonNull private String description;
	@Getter @Setter @NonNull private Integer position;
	@Getter @Setter @NonNull private String imgUri;
	@Getter @Setter @NonNull private ResourceType type;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "offer_id")
	@Getter @Setter @NonNull private Offer offer;
	
	@OneToMany(mappedBy = "resource")
	@Getter List<Section> sections = new ArrayList<>();
	

}
