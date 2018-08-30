package wit.seven.user_bank.services;

import wit.seven.user_bank.dao.model.Bank;
import wit.seven.user_bank.dao.model.User;
import wit.seven.user_bank.dto.BankDTO;
import wit.seven.user_bank.dto.UserDTO;

import java.util.List;

public interface UserBankService {
    public List<UserDTO> getUsers();
    public String createUser(UserDTO userDTO);
    public String updateUser(UserDTO userDTO);
    public String deleteUser(Long id);

    public List<BankDTO> getBanks();
    public String createBank(BankDTO bankDTO);
    public String updateBank(BankDTO bankDTO);
    public String deleteBank(Long id);
}
