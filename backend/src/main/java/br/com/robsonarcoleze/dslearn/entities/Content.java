package br.com.robsonarcoleze.dslearn.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name = "tb_content")
public class Content extends Lesson {
	private static final long serialVersionUID = 1L;

	@Getter @Setter private String textContent;
	@Getter @Setter private String videoUri;
	
	public Content(@NonNull Long id, @NonNull String title, @NonNull Integer position, @NonNull Section section,
			String textContent, String videoUri) {
		super(id, title, position, section);
		this.textContent = textContent;
		this.videoUri = videoUri;
	}
	
	
}
