package com.valtech.training.restapis.services;

import java.util.List;

import com.valtech.training.restapis.vos.OwnerVO;


public interface OwnerService {
  
	List<OwnerVO> getOwners();

	OwnerVO getOwner(long id);

	OwnerVO updateOwner(long id, OwnerVO owner);

	OwnerVO createOwner(OwnerVO owner);

	List<OwnerVO> getOwnersByName(String name);

	OwnerVO addWatchesToOwner(long id, List<Long> watches);

}