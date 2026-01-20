package dio.web.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record UserUpdateDTO (
        String name,

        @Email(message = "Invalid email format")
        String email,

        @Size(min = 8, message = "The password must be at least 8 characters")
        String password) {
}

