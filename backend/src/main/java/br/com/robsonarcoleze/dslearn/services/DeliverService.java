package br.com.robsonarcoleze.dslearn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.robsonarcoleze.dslearn.dto.DeliverRevisionDTO;
import br.com.robsonarcoleze.dslearn.entities.Deliver;
import br.com.robsonarcoleze.dslearn.repositories.DeliverRepository;

@Service
public class DeliverService {

	@Autowired
	private DeliverRepository repository;
	
	@Transactional
	public void saveRevision(Long id, DeliverRevisionDTO dto) {
		Deliver deliver = repository.getReferenceById(id);
		deliver.setStatus(dto.getStatus());
		deliver.setFeedback(dto.getFeedback());
		deliver.setCorrectCount(dto.getCorrectCount());
		repository.save(deliver);
		
	}
}
