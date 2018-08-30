package wit.seven.user_bank.dto;

import java.util.List;

public class UserDTO {
    private Long id;
    private String userName;
    private String fullName;
    private Integer age;
    private Boolean gender;
    private List<BankDTO> banks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public List<BankDTO> getBanks() {
        return banks;
    }

    public void setBanks(List<BankDTO> banks) {
        this.banks = banks;
    }
}
