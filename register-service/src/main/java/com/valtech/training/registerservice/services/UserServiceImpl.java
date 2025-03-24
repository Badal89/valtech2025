package com.valtech.training.registerservice.services;
 
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;
import com.valtech.training.registerservice.repos.SubscriptionRepo;
import com.valtech.training.registerservice.repos.UserRepo;
import com.valtech.training.registerservice.vos.UserVO;
 
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private SubscriptionRepo subRepo;


	public List<UserVO> getAllUser() {

		return UserVO.from(userRepo.findAll());

	}

	public UserVO RegisterUser(UserVO vo) {

		User user = vo.to(subRepo.getReferenceById(vo.subscriptionId()));
		user = userRepo.save(user);
		return UserVO.from(user);

	}
 
	@Override
	public UserVO addUserToSubscription(UserVO vo,long id) {

		Subscription sub =subRepo.getReferenceById(id);
		User user=vo.to(sub);
		return UserVO.from(userRepo.save(user));

	}

	@Override
	public UserVO getUserById(long id) {

		return UserVO.from(userRepo.getReferenceById(id));

	}
 
	@Override
	public List<UserVO> getUserBySuubscriptionId(long subId) {

		return UserVO.from(userRepo.findAllBySubscriptionId(subId));

	}
 
	@Override
	public UserVO signIn(UserVO uvo) {

		Subscription sub = new Subscription();
		sub.setAmount(1000);
		sub.setSubscriptionStart(LocalDate.now());
		sub.setSubscriptionEnd(LocalDate.now().plusYears(1));
		sub.addUser(uvo.to(sub));
		sub= subRepo.save(sub);
		return UserVO.from(userRepo.save(uvo.to(sub)));

	}

	@Override
    public void deleteUserFromSubscription(long userId) {
      
        User user = userRepo.getReferenceById(userId);
        Subscription sub=user.getSubscription();
        sub.removeUser(user);
        userRepo.delete(user);      
       
    }
}

 