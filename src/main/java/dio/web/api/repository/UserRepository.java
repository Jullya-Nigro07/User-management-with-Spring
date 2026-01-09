package dio.web.api.repository;

import dio.web.api.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    public void save(User user) {
        if (user.getId() == null)
            System.out.println("SAVE - Recebendo o user na camada de repositório");
        else
            System.out.println("UPDATE - Recebendo o user na camada de repositório ");
        System.out.println(user);
    }

    public void deleteById(Integer id) {
        System.out.printf("DELETE/id - Recebendo o id: %d para excluir um user", id);
        System.out.println(id);
    }

    public List<User> findAll() {
        System.out.println("LIST - Listando os users do sistema");
        List<User> users = new ArrayList<>();
        users.add(new User("Jullya", "123456789"));
        users.add(new User("Fernando", "123456789"));
        users.add(new User("Camylla", "123456789"));
        return users;
    }

    public User findById(Integer id){
        System.out.printf("FIND/id - Recebendo o id: %d para logar", id);
        return new User("Jesus", "relacionamento");
    }

    public User findByUsername(String username){
        System.out.printf("FIND/username - Recebendo o username: %s para logar", username);
        return new User("Jeová", "obediencia");
    }
}
