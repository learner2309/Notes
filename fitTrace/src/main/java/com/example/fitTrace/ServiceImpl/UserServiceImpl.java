package com.example.fitTrace.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fitTrace.Service.UserService;
import com.example.fitTrace.entity.User;
import com.example.fitTrace.exception.UserNotFoundException;
import com.example.fitTrace.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userrepo;
   
    
	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		Boolean b = userrepo.findAll().stream().anyMatch(i->i.getName().equals(username));
		   if(b)
		   {
			 
			 User user1 =  userrepo.findAll().stream().filter(i->i.getName().equals(username)).findAny().get();
			  if(user1.getPassword().equals(password))
			  {
			 
			  
				return user1;
			  }
			  throw new UserNotFoundException("enter password correctly");
		   }
			
			throw new UserNotFoundException("no user found");
	}

	@Override
	public User register(User user) {
		// TODO Auto-generated method stub
	Boolean b=	userrepo.findAll().stream().anyMatch(i->i.getEmail().equals(user.getEmail()));
		if(b)
	    {
		throw new UserNotFoundException("user already exists with "+user.getEmail());
		}
		return userrepo.save(user);
	}

	@Override
	public List<User> getusers() {
		// TODO Auto-generated method stub
		return userrepo.findAll();
	}

	@Override
	public User getUserById(Long id) throws UserNotFoundException{
		// TODO Auto-generated method stub
		User u = userrepo.getById(id);
			if(!userrepo.existsById(id))	
			{
				throw new UserNotFoundException("user not found");
			}
		 return userrepo.getById(id);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		if(userrepo.existsById(user.getUserId()))
		{
		User oldUser = userrepo.getById(user.getUserId());
	
		if(!(user.getPassword()==null))
		{
			oldUser.setPassword(user.getPassword());
		}
		if(!(user.getName()==null))
		{
			oldUser.setName(user.getName());
		}
		if(!(user.getEmail()==null))
		{
			oldUser.setEmail(user.getEmail());
		}
		if(!(user.getAddress()==null))
		{
			oldUser.setAddress(user.getAddress());
		}
		if(!(user.getPhoneNumber()==null))
		{
			oldUser.setPhoneNumber(user.getPhoneNumber());
		}
		
		return userrepo.save(oldUser);
		}
		throw new UserNotFoundException("user not found");
	}
	
	

}
