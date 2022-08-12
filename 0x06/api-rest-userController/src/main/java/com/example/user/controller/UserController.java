package controller;

import com.example.user.exception.CPFException;
import com.example.user.exception.UserIdException;
import com.example.user.exception.UserNameException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping("/user-id/{id}")
    public String findUserById(@PathVariable int id) {
        if(id < 100 && id > 0){
            return "You have entered valid ID";
        }else{
            throw new UserIdException(String.valueOf(id));
        }
    }

    @GetMapping("/user-name/{userName}")
    public String findUserByName(@PathVariable String userName) {
        if(userName.length() > 3 && userName.length() < 15 && userName.contains("@")){
            return "You have entered valid USERNAME";
        } else{
            throw new UserNameException(userName);
        }
    }

    @GetMapping("/user-cpf/{cpf}")
    public String findUserByCPF(@PathVariable String cpf) {
        boolean cpfValid = isCPF(cpf);
        if(cpfValid == true){
            return "You have entered valid CPF";
        }else{
            throw new CPFException(cpf);
        }

    }

    public boolean isCPF(String CPF) {
        if(CPF.length() > 4 && CPF.length() < 14){
            return true;
        }else{
            return false;
        }
    }
}
