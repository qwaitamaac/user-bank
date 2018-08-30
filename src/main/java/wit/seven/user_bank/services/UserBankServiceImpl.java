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
    public String createUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public String updateUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public String deleteUser(Long id) {
        return null;
    }

    @Override
    public List<BankDTO> getBanks() {
        return null;
    }

    @Override
    public String createBank(BankDTO bankDTO) {
        return null;
    }

    @Override
    public String updateBank(BankDTO bankDTO) {
        return null;
    }

    @Override
    public String deleteBank(Long id) {
        return null;
    }
}
