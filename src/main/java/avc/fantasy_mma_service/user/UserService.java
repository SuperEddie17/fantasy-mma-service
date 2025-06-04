package avc.fantasy_mma_service.user;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto createUser(CreationEditUserDto newUserDto){
        User user = userMapper.toEntity(newUserDto);
        user.setBudget(1000.0);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    public UserDto editUser(CreationEditUserDto editUserDto, Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userMapper.updateUserFromDto(editUserDto, user);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    public void deleteUser(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toDtoList(users);
    }
}
