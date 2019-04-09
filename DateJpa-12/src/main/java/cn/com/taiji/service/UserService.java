//package cn.com.taiji.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import cn.com.taiji.domain.User;
//import cn.com.taiji.domain.UserRepository;
//
//public class UserService {
//	@Autowired
//	private UserRepository userRepo;
//
//	@Transactional(propagation = Propagation.REQUIRED)
//	public void saveUser(User user) {
//		this.userRepo.saveAndFlush(user);
//	}
//}
