package com.valtech.training.registerservice.services;
 
import java.util.List; 
import com.valtech.training.registerservice.vos.UserVO;
 
public interface UserService {
 
	UserVO getUserById(long id);
	UserVO addUserToSubscription(UserVO vo,long id);	
	List<UserVO> getUserBySuubscriptionId(long subId);	
	UserVO signIn(UserVO uvo);
	void deleteUserFromSubscription(long userId);
 
}
 
 