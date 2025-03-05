package com.valtech.training.restapis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.restapis.entities.Owner;
import com.valtech.training.restapis.entities.Watch;
import com.valtech.training.restapis.repos.OwnerRepo;
import com.valtech.training.restapis.repos.WatchRepo;
import com.valtech.training.restapis.vos.OwnerVO;
import com.valtech.training.restapis.vos.WatchVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OwnerServiceImpl implements OwnerService {
	
	@Autowired
	private OwnerRepo ownerRepo;
	@Autowired
	private WatchRepo watchRepo;
	
	@Override
	public OwnerVO createOwner(OwnerVO owner) {
		return OwnerVO.from(ownerRepo.save(owner.toOwner()));
	}

	@Override
	public List<OwnerVO> getOwners() {
		return OwnerVO.toOwnerVO(ownerRepo.findAll());
	}

	@Override
	public OwnerVO getOwner(long id) {
		return OwnerVO.from(ownerRepo.getReferenceById(id));
	}

	@Override
	public OwnerVO updateOwner(long id, OwnerVO owner) {
		Owner owner1=ownerRepo.getReferenceById(id);
    	owner.updateOwnerFromVO(owner1);
     	return OwnerVO.from(ownerRepo.save(owner1));
	}

	

	@Override
	public List<OwnerVO> getOwnersByName(String name) {
		return OwnerVO.toOwnerVO(ownerRepo.findAllByName(name));
	}

	@Override
	public OwnerVO addWatchesToOwner(long id, List<Long> watches) {
	    Owner owner=ownerRepo.getReferenceById(id);
		watches.stream().forEach(wid->owner.addWatch(watchRepo.getReferenceById(wid)));
		Owner owner1=ownerRepo.save(owner);
		return OwnerVO.from(owner1);
	}
	
	
	
	
	
	

}
