package exception;

import com.example.user.exception.CPFException;
import exception.UserErrorResponse;
import com.example.user.exception.UserIdException;
import exception.UserNameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionService {

    @ExceptionHandler(CPFException.class)
    ResponseEntity<CPFException> handleException(CPFException err){
        UserErrorResponse uer =new UserErrorResponse();
        uer.setStatus(HttpStatus.NOT_FOUND.value());
        uer.setMessage("You have entered CPF "+err.getMessage()+" invalid.");
        return new ResponseEntity(uer,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserIdException.class)
    ResponseEntity<UserIdException> handleException(UserIdException err){
        UserErrorResponse uer =new UserErrorResponse();
        uer.setStatus(HttpStatus.NOT_FOUND.value());
        uer.setMessage("You have entered ID "+err.getMessage()+" invalid.");
        return new ResponseEntity(uer,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNameException.class)
    ResponseEntity<UserNameException> handleException(UserNameException err){
        UserErrorResponse uer =new UserErrorResponse();
        uer.setStatus(HttpStatus.NOT_FOUND.value());
        uer.setMessage("You have entered ID "+err.getMessage()+" invalid.");
        return new ResponseEntity(uer,HttpStatus.NOT_FOUND);
    }
}
