package wit.seven.user_bank.services;

import wit.seven.user_bank.dao.model.Bank;
import wit.seven.user_bank.dao.model.User;
import wit.seven.user_bank.dto.BankDTO;
import wit.seven.user_bank.dto.UserDTO;

import java.util.List;

public interface UserBankService {
    public List<UserDTO> getUsers();
    public void createUser(UserDTO userDTO);
    public void updateUser(UserDTO userDTO);
    public void deleteUser(Long id);

    public List<BankDTO> getBanks();
    public void createBank(BankDTO bankDTO);
    public void updateBank(BankDTO bankDTO);
    public void deleteBank(Long id);
}
