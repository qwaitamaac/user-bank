package wit.seven.user_bank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wit.seven.user_bank.dao.model.Bank;
import wit.seven.user_bank.dao.model.User;
import wit.seven.user_bank.dao.repository.BankRepository;
import wit.seven.user_bank.dao.repository.UserRepository;
import wit.seven.user_bank.dto.BankDTO;
import wit.seven.user_bank.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserBankServiceImpl implements UserBankService {
    @Autowired
    private UserRepository userRepository;
    private BankRepository bankRepository;

    public UserBankServiceImpl(UserRepository userRepository, BankRepository bankRepository) {
        this.userRepository = userRepository;
        this.bankRepository = bankRepository;
    }
    @Override
    public List<UserDTO> getUsers() {
        List<UserDTO> userDTOs = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for (User user : users) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setUserName(user.getUserName());
            userDTO.setFullName(user.getFullName());
            userDTO.setAge(user.getAge());
            userDTO.setGender(user.isGender());
            for (Bank bank : user.getBanks()) {
                BankDTO bankDTO = new BankDTO();
                bankDTO.setId(bank.getId());
                bankDTO.setName(bank.getBankName());
                bankDTO.setAccount(bank.getBankAccount());
                userDTO.getBanks().add(bankDTO);
            }
            userDTOs.add(userDTO);
        }
        return userDTOs;
    }

    @Override
    public void createUser(UserDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setFullName(userDTO.getFullName());
        user.setAge(userDTO.getAge());
        user.setGender(userDTO.getGender());
        userRepository.save(user);
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        Optional<User> userOptional = userRepository.findById(userDTO.getId());
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setUserName(userDTO.getUserName());
            user.setFullName(userDTO.getFullName());
            user.setAge(userDTO.getAge());
            user.setGender(userDTO.getGender());
            userRepository.save(user);
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<BankDTO> getBanks() {
        List<BankDTO> bankDTOs = new ArrayList<>();
        List<Bank> banks = bankRepository.findAll();
        for (Bank bank: banks) {
            BankDTO bankDTO = new BankDTO();
            bankDTO.setId(bank.getId());
            bankDTO.setName(bank.getBankName());
            bankDTO.setAccount(bank.getBankAccount());

            UserDTO userDTO = new UserDTO();
            userDTO.setId(bank.getUser().getId());
            userDTO.setUserName(bank.getUser().getUserName());
            userDTO.setFullName(bank.getUser().getFullName());
            userDTO.setAge(bank.getUser().getAge());
            userDTO.setGender(bank.getUser().isGender());

            bankDTO.setUser(userDTO);

            bankDTOs.add(bankDTO);
        }
        return bankDTOs;
    }

    @Override
    public void createBank(BankDTO bankDTO) {
        Bank bank = new Bank();
        bank.setBankName(bankDTO.getName());
        bank.setBankAccount(bankDTO.getAccount());

        Optional<User> userOptional = userRepository.findById(bankDTO.getId());
        if(userOptional.isPresent()){
            bank.setUser(userOptional.get());
            bankRepository.save(bank);
        }
    }

    @Override
    public void updateBank(BankDTO bankDTO) {
        Optional<Bank> bankOptional = bankRepository.findById(bankDTO.getId());
        if(bankOptional.isPresent()){
            Bank bank = bankOptional.get();
            bank.setBankName(bankDTO.getName());
            bank.setBankAccount(bankDTO.getAccount());
            if(!bank.getUser().getId().equals(bankDTO.getUser().getId())){
                Optional<User> userOptional = userRepository.findById(bankDTO.getUser().getId());
                if(userOptional.isPresent()){
                    bank.setUser(userOptional.get());
                }
            }
            bankRepository.save(bank);
        }
    }

    @Override
    public void deleteBank(Long id) {
        bankRepository.deleteById(id);
    }
}
