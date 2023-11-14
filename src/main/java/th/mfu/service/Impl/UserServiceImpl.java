package th.mfu.service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import th.mfu.dto.UserDto;
import th.mfu.model.User;
import th.mfu.repository.UserRepository;
import th.mfu.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()) , userDto.getRole(), userDto.getUserName());
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return  user;
    }

    @Override
    public User updateUserInfo(User currentUser, UserDto updateUser) {
        if(updateUser.getUserName() != null){
            userRepository.updateUserName(currentUser.getId(), updateUser.getUserName());
            currentUser.setUserName(updateUser.getUserName());
        }
        return currentUser;
    }

    @Override
    public boolean checkPassword(User currentUser, String currentPassword) {
        return passwordEncoder.matches(currentPassword, currentUser.getPassword());
//        String endcodedCurrentPassword = passwordEncoder.encode(currentPassword);
//        return currentUser.getPassword().equals(endcodedCurrentPassword);
    }

    @Override
    public boolean updatePassword(User currentUser, String currentPassword, String newPassword) {
        int rowsAffected = userRepository.updatePassword(currentUser.getId(), passwordEncoder.encode(currentPassword), passwordEncoder.encode(newPassword));
        currentUser.setPassword(passwordEncoder.encode(newPassword));
        return rowsAffected > 0;
    }
}
