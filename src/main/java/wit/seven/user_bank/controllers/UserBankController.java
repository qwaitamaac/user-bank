package wit.seven.user_bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wit.seven.user_bank.dao.model.Bank;
import wit.seven.user_bank.dao.model.User;
import wit.seven.user_bank.dto.BankDTO;
import wit.seven.user_bank.dto.UserDTO;
import wit.seven.user_bank.services.UserBankService;

import java.util.List;

@Controller
public class UserBankController {
    @Autowired
    private UserBankService userBankService;

    @GetMapping(value = "/user")
    public @ResponseBody List<UserDTO> getUser(){
        return userBankService.getUsers();
    }
    @GetMapping(value = "/bank")
    public @ResponseBody List<BankDTO> getBank(){
        return userBankService.getBanks();
    }

    @PostMapping(value = "/user")
    public @ResponseBody String createUser(@RequestBody UserDTO user){
        return userBankService.createUser(user);
    }
    @PutMapping(value = "/user")
    public @ResponseBody String updateUser(@RequestBody UserDTO user){
        return userBankService.updateUser(user);
    }

    @PostMapping(value = "/bank")
    public @ResponseBody String createBank(@RequestBody BankDTO bank){
        return userBankService.createBank(bank);
    }
    @PutMapping(value = "/bank")
    public @ResponseBody String updateBank(@RequestBody BankDTO bank){
        return  userBankService.updateBank(bank);
    }
    @DeleteMapping(value = "/user/{id}")
    public  @ResponseBody String deleteUser(@PathVariable(value = "id") Long id){
        return userBankService.deleteUser(id);
    }
    @DeleteMapping(value = "/bank/{id}")
    public @ResponseBody String deleteBank(@PathVariable(value = "id") Long id){
        return userBankService.deleteBank(id);
    }
}
