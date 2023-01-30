package br.com.robsonarcoleze.dslearn.resources.exceptions;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class OAuthCustomError implements Serializable{
	private static final long serialVersionUID = 1L;

	@Getter @Setter private String error;
	
	@JsonProperty("error_description	")
	@Getter @Setter private String  errorDescription;
}
