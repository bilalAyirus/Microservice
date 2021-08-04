package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudapp.springboot.model.UserMst;
import com.crudapp.springboot.repository.UserMstRepository;

@Service

public class UserMstImpl implements Usermstservice {
	
	@Autowired
	UserMstRepository userMstRepository;

	@Override
	public UserMst checkbyId(Long id) {
		return userMstRepository.findById(id).get();
	}
	
	

}
