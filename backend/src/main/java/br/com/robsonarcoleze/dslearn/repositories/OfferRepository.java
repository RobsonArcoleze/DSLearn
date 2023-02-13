package br.com.robsonarcoleze.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.robsonarcoleze.dslearn.entities.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long>{

}
