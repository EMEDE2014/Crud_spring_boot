package com.dev.dscatalog.services;

import java.util.List;
import java.util.Optional;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.dscatalog.dto.CategoryDTO;
import com.dev.dscatalog.entities.Category;
import com.dev.dscatalog.repositories.CategoryRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repository;
	
		@Transactional(readOnly = true)
		public List<CategoryDTO> findAll(){
			
			List<Category> list = repository.findAll();
			
		return  list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
		}
		
		@Transactional(readOnly = true)
		public CategoryDTO findById(Long id){
			
		Optional<Category> obj = repository.findById(id);
		Category entity = obj.orElseThrow(() -> new EntityNotFoundException("Nao foi encotrado"));
		return  new CategoryDTO(entity);
		}
}
