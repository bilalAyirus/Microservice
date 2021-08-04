package com.crudapp.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudapp.springboot.exception.ResourceNotFoundException;
import com.crudapp.springboot.model.Order;
import com.crudapp.springboot.model.UserMst;
import com.crudapp.springboot.repository.UserMstRepository;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value="/api/v1/")
public class UserMstController {
	
	@Autowired
	UserMstRepository userMstRepository;
	
	@GetMapping("/users")
	public List<UserMst> getAllUsers(){
		return userMstRepository.findAll();
	}
	
	@PostMapping("/users")	
	public UserMst createUsers(@RequestBody UserMst userMst) {
		Order order1=new Order();
		order1.setOrderName("pizza");
		order1.setPrice(50);
		
		Order order2=new Order();
		order2.setOrderName("dosa");
		order2.setPrice(60);
		
		Order order3=new Order();
		order3.setOrderName("itli");
		order3.setPrice(80);
		
		List<Order> orderlst=new ArrayList<>();
		orderlst.add(order1);
		orderlst.add(order2);
		orderlst.add(order3);
		
//	userMst.setOrderList(orderlst);
		return userMstRepository.save(userMst);
	}
	
	@GetMapping("users/{id}")
	public Optional<UserMst> getUserById(@PathVariable Long id) {
		System.out.println(id);
		return userMstRepository.findById(id);
	}
	
	@PutMapping("/users/{id}")
    public HttpStatus updateUser(@PathVariable(value = "id") Integer employeeId,
                                                   @RequestBody UserMst employeeDetails) throws ResourceNotFoundException {
        UserMst employee = userMstRepository.getUserbyId(employeeId);

        employee.setName(employeeDetails.getName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setAddress(employeeDetails.getAddress());

        final UserMst updatedEmployee = userMstRepository.save(employee);
        return HttpStatus.OK;
    }
	
	@DeleteMapping("users/{id}")
	public HttpStatus updateUser(@PathVariable Long id){
		userMstRepository.deleteById(id);
		return HttpStatus.OK;
		
		
	}

}
