package dio.web.api.service;

import dio.web.api.handler.BusinessException;
import dio.web.api.handler.ResourceNotFoundException;
import dio.web.api.model.User;
import dio.web.api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User save(User user) {
        if (user.getId() != null) {
            throw new BusinessException("Usuário já possui ID");
        }
        return repository.save(user);
    }

    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Usuário não encontrado");
        }
        repository.deleteById(id);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findByUsername(String username) {
        return repository.findByUsernameIgnoreCase(username)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Usuário não encontrado"));
    }
}
