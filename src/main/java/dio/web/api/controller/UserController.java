package dio.web.api.controller;

import dio.web.api.controller.doc.UserControllerDoc;
import dio.web.api.dto.UserCreateDTO;
import dio.web.api.dto.UserUpdateDTO;
import dio.web.api.model.User;
import dio.web.api.service.UserService;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody UserCreateDTO dtoUser) {
        return service.create(dtoUser);
    }

    @PatchMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody UserUpdateDTO dtoUser) {
        return service.update(id, dtoUser);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping
    public List<User> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return service.findById(id);
    }
}
