package dio.web.api.handler;

//Exceção de negócio (StatusCode: 400)

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BusinessException extends RuntimeException{

    public BusinessException(String message){
        super(message);
    }
}
