package dio.web.api.service;

import dio.web.api.dto.request.UserCreateDTO;
import dio.web.api.dto.request.UserUpdateDTO;
import dio.web.api.dto.response.UserResponseDTO;
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

    public User create(UserCreateDTO dtoUser) {

        if (repository.existsByEmail(dtoUser.email())) {
            throw new BusinessException("Email already registered");
        }
        User user = new User(
                dtoUser.name(),
                dtoUser.email(),
                dtoUser.password());

        return repository.save(user);
    }

    public User update(Long id, UserUpdateDTO dtoUser) {
        User existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        if (dtoUser.name() != null)
            existing.setName(dtoUser.name());

        if (dtoUser.email() != null)
            existing.setEmail(dtoUser.email());

        if (dtoUser.password() != null)
            existing.setPassword(dtoUser.password());

        return repository.save(existing);
    }

    public UserResponseDTO delete(Long id){
        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        UserResponseDTO response = new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );

        repository.delete(user);

        return response;
    }

    public List<UserResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(user -> new UserResponseDTO(
                        user.getId(),
                        user.getName(),
                        user.getEmail()
                ))
                .toList();
    }

    public UserResponseDTO findById(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
