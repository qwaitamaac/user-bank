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
        userBankService.createUser(user);
        return "Ok";
    }
    @PutMapping(value = "/user")
    public @ResponseBody String updateUser(@RequestBody UserDTO user){
        userBankService.updateUser(user);
        return "Ok";
    }

    @PostMapping(value = "/bank")
    public @ResponseBody String createBank(@RequestBody BankDTO bank){
        userBankService.createBank(bank);
        return "Ok";
    }
    @PutMapping(value = "/bank")
    public @ResponseBody String updateBank(@RequestBody BankDTO bank){
        userBankService.updateBank(bank);
        return "Ok";
    }
    @DeleteMapping(value = "/user/{id}")
    public  @ResponseBody String deleteUser(@PathVariable(value = "id") Long id){
        userBankService.deleteUser(id);
        return "Ok";
    }
    @DeleteMapping(value = "/bank/{id}")
    public @ResponseBody String deleteBank(@PathVariable(value = "id") Long id){
        userBankService.deleteBank(id);
        return "Ok";
    }
}
