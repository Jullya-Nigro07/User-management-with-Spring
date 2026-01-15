package dio.web.api.service;

import dio.web.api.dto.UserCreateDTO;
import dio.web.api.dto.UserUpdateDTO;
import dio.web.api.handler.BusinessException;
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

    public User create(UserCreateDTO dtoUser) {
        User user = new User();

        user.setName(dtoUser.getName());
        user.setEmail(dtoUser.getEmail());
        user.setPassword(dtoUser.getPassword());

        return repository.save(user);
    }

    public User update(Long id, UserUpdateDTO dtoUser) {
        User existing = repository.findById(id)
                .orElseThrow(() -> new BusinessException("Usuário não encontrado"));

        if (dtoUser.getName() != null)
            existing.setName((dtoUser.getName()));

        if (dtoUser.getEmail() != null)
            existing.setEmail((dtoUser.getEmail()));

        if (dtoUser.getPassword() != null)
            existing.setPassword((dtoUser.getPassword()));

        return repository.save(existing);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new BusinessException("Usuário não encontrado");
        }
        repository.deleteById(id);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new BusinessException("Usuário não encontrado"));
    }
}
