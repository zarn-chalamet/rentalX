package th.mfu.service;

import th.mfu.dto.UserDto;
import th.mfu.model.User;

public interface UserService {
    User save (UserDto userDto);

    User findByEmail(String email);

    User updateUserInfo(User currentUser, UserDto updateUser);

    boolean checkPassword(User currentUser, String currentPassword);

    boolean updatePassword(User currentUser,String currentPassword, String newPassword);

}
