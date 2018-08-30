package wit.seven.user_bank.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wit.seven.user_bank.dao.model.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank , Long> {
}
