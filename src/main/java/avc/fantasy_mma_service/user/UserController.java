package avc.fantasy_mma_service.user;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @PostMapping("")
    public UserDto createUser(@RequestBody CreationEditUserDto creationEditUserDto) {
        return userService.createUser(creationEditUserDto);
    }

    @PatchMapping("/{id}")
    public UserDto editUser(@RequestBody CreationEditUserDto creationEditUserDto,@PathVariable Long id) {
        return userService.editUser(creationEditUserDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
