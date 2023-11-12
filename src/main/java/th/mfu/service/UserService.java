package th.mfu.service;

import th.mfu.dto.UserDto;
import th.mfu.model.User;

public interface UserService {
    User save (UserDto userDto);

    User findByEmail(String email);
}
