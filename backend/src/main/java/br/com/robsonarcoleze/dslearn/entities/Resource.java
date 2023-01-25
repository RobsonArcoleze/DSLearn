package br.com.robsonarcoleze.dslearn.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.robsonarcoleze.dslearn.entities.enums.ResourceType;
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
