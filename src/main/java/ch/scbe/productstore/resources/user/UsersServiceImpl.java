package ch.scbe.productstore.resources.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    public Users create(Users user) {
        return this.usersRepository.save(user);
    }

    public Users getById(Long id) {
        return this.usersRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with the id " + id + " not found"));
    }

    public List<Users> getAll() {
        return (List<Users>) this.usersRepository.findAll();
    }

    public Users update(Long id, Users user) {
        Users users = this.usersRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with the id " + id + " not found"));
        users.setUsername(user.getUsername());
        users.setPassword(user.getPassword());
        return usersRepository.save(users);
    }

    public void delete(Long id) {
        usersRepository.deleteById(id);
    }
}
