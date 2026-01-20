package dio.web.api.controller;

import dio.web.api.controller.doc.UserControllerDoc;
import dio.web.api.dto.request.UserCreateDTO;
import dio.web.api.dto.request.UserUpdateDTO;
import dio.web.api.dto.response.UserResponseDTO;
import dio.web.api.model.User;
import dio.web.api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController implements UserControllerDoc {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody @Valid UserCreateDTO dtoUser) {
        User user = service.create(dtoUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PatchMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody @Valid UserUpdateDTO dtoUser) {
        return service.update(id, dtoUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponseDTO> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}
