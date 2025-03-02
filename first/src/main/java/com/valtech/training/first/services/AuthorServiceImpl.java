package com.valtech.training.first.services;



import com.valtech.training.first.entities.Author;
import com.valtech.training.first.repos.AuthorRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

   

 


	@Override
	public List<Author> findAll() {
		 return authorRepo.findAll();
	}

  
}

