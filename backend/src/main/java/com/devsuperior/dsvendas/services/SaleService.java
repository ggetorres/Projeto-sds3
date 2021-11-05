package com.devsuperior.dsvendas.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepositories;
import com.devsuperior.dsvendas.repositories.SellerRepositories;

@Service
public class SaleService {

	@Autowired
	private SaleRepositories repository;
	
	@Autowired
	private SellerRepositories sellerrepository;

	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageble) {
		sellerrepository.findAll();
		Page<Sale> result = repository.findAll(pageble);
		return result.map(x -> new SaleDTO(x));
		
	}
	
	@Transactional(readOnly = true)
	public 	List<SaleSumDTO> amountGroupBySeller(){
		return repository.amountGroupBySeller();
	}
	
	
	@Transactional(readOnly = true)
	public 	List<SaleSuccessDTO> successGroupBySeller(){
		return repository.successGroupBySeller();
	}
}
