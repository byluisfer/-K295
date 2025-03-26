package ch.scbe.productstore.resources.user;

import org.springframework.web.bind.annotation.*;
import ch.scbe.productstore.resources.user.dto.UserCreateDto;
import ch.scbe.productstore.resources.user.dto.UserShowDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public List<UserShowDto> getAllUsers() {
        return usersService.getAll().stream().map(userMapper::toShowDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserShowDto getUserById(@PathVariable Long id) {
        return userMapper.toShowDto(usersService.getById(id));
    }

    @PostMapping
    public UserShowDto createUser(@RequestBody UserCreateDto dto) {
        Users user = userMapper.toEntity(dto);
        return userMapper.toShowDto(usersService.create(user));
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UserCreateDto dto) {
        Users existingUser = usersService.getById(id);
        userMapper.update(dto, existingUser);
        usersService.update(id, existingUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        usersService.delete(id);
    }
}
