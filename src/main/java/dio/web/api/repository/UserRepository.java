package dio.web.api.repository;

import dio.web.api.handler.BusinessException;
import dio.web.api.handler.ResourceNotFoundException;
import dio.web.api.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    public void save(User user) {
        if (user.getLogin() == null)
            throw new BusinessException("O campo de login é obrigatório");

        if (user.getPassword() == null)
            throw new BusinessException("O campo de passwork é obrigatório");

        if (user.getId() == null)
            System.out.println("SAVE - Salvando um novo usuário");
        else
            System.out.println("UPDATE - Atualizando usuário");

        System.out.println(user);
    }

    public void deleteById(Integer id) {
        if (id == null)
            throw new BusinessException("Este ID não foi encontrado");

        System.out.printf("DELETE - id: %d%n", id);
    }

    public List<User> findAll() {
        System.out.println("LIST - Listando os users do sistema");
        List<User> users = new ArrayList<>();
        return users;
    }

    public User findByUsername(String username){
        if (username.equalsIgnoreCase("jullya"))
            throw new ResourceNotFoundException("Usuário não encontrado");

        return new User(username, "123");
    }
}