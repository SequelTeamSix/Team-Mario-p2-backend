package teamup.p2backend.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import teamup.p2backend.model.Event;
import teamup.p2backend.model.User;
import teamup.p2backend.repository.UserRepository;

import java.lang.annotation.*;
import java.util.List;

@Component
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository){this.userRepository = userRepository;}

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(String username1) {
        userRepository.deleteByUsername(username1);
    }

    public User findUserById(int user_id) {return userRepository.findById(user_id);}

    public User findUserByUsername(String username1){return userRepository.findByUsername1(username1);}

    //public User findUserByEmail(String email){
    //    return userRepository.findByEmail(email);
    //}

    //update(patch/put) methods
    public void updateUsername(User user){userRepository.updateByUsername(user.getUsername1(), user.getUser_id1());}

    public void updateUserInfo(User user){userRepository.updateInfo(user.getFullname1(),user.getEmail1(),
            user.getPassword1(), user.getUsername1());}
}
