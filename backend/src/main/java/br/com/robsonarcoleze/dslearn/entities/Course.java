package br.com.robsonarcoleze.dslearn.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "tb_course")
public class Course implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter @NonNull private Long id;
	@Getter @Setter @NonNull private String name;
	@Getter @Setter @NonNull private String imgUri;
	@Getter @Setter @NonNull private String imgGrayUri;
	
	@OneToMany(mappedBy = "course")
	@Getter private List<Offer> offers = new ArrayList<>();
}
