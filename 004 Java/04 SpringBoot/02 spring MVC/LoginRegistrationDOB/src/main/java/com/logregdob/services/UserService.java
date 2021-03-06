package com.logregdob.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import com.logregdob.models.LoginUser;
import com.logregdob.models.User;
import com.logregdob.repositories.UserRepository;


@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    public List<User> allUsers(){
		return userRepo.findAll();
	}
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {

        // Reject if email is taken (present in database)
        Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
        if(potentialUser.isPresent()) {
            result.rejectValue("email", "Exist", "This email already exist!");
        }
        //Birthday Validation should be at least 13 years old
        LocalDate currentDate = LocalDate.now();
            int age = Period.between(newUser.getBirthday(), currentDate).getYears();
            if ( age < 13) {
                result.rejectValue("birthday", "Compare", "At least 13 years old ");
        }

        if (!newUser.getUserName().matches("[a-zA-Z]+")) {
            result.rejectValue("userName", "expression", "Username must contain characters only");
        }
        // Reject if password doesn't match confirmation
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
        }
        if (result.hasErrors()) {
             return null;
        }else {
            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashed);
            return userRepo.save(newUser);
        }
        // Hash and set password, save user to database

        }

    public User login(LoginUser newLoginObject, BindingResult result) {
    	Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
    	if(potentialUser.isEmpty()) {
    	    result.rejectValue("email", "notExist", "Register First!");
    	    return null;
    	}
        // Reject if password doesn't match confirmation
    	else if(!BCrypt.checkpw(newLoginObject.getPassword(), potentialUser.get().getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	    return null;
    	}
        // Return null if result has errors
    	else {
    		User logUser = potentialUser.get();
    		return logUser;
    	}
    	
    }
    
    public User newUser(User newUser) {
    		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    		newUser.setPassword(hashed);
            return userRepo.save(newUser);

    	
        }
}
