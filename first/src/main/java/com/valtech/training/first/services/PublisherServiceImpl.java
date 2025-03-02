package com.valtech.training.first.services;

import com.valtech.training.first.entities.Publisher;
import com.valtech.training.first.repos.PublisherRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepo publisherRepo;

	@Override
	public List<Publisher> findAll() {
		return publisherRepo.findAll();
	}

    
}
