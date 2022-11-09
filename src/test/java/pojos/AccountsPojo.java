package pojos;

public class AccountsPojo {
 /*
“accounts”: [
    {
            “id”: 107250,
            “description”: “New Account_6thGenQA_01",
            “balance”: 11190,
            “accountType”: “CHECKING”,
            “accountStatusType”: “ACTIVE”,
            “createDate”: “2021-11-24T23:00:00Z”,
            “closedDate”: “2022-11-24T23:00:00Z”,
            “employee”: null,
            “accountlogs”: null
    }*/
    private String description;
    private Integer balance;
    private String accountType;
    private String accountStatusType;
    private String createDate;
    private String closedDate;
    private Object employee;
    private Object accountlogs;

    public AccountsPojo(String description, Integer balance, String accountType, String accountStatusType, String createDate, String closedDate, Object employee, Object accountlogs) {
        this.description = description;
        this.balance = balance;
        this.accountType = accountType;
        this.accountStatusType = accountStatusType;
        this.createDate = createDate;
        this.closedDate = closedDate;
        this.employee = employee;
        this.accountlogs = accountlogs;
    }

    public AccountsPojo() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountStatusType() {
        return accountStatusType;
    }

    public void setAccountStatusType(String accountStatusType) {
        this.accountStatusType = accountStatusType;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(String closedDate) {
        this.closedDate = closedDate;
    }

    public Object getEmployee() {
        return employee;
    }

    public void setEmployee(Object employee) {
        this.employee = employee;
    }

    public Object getAccountlogs() {
        return accountlogs;
    }

    public void setAccountlogs(Object accountlogs) {
        this.accountlogs = accountlogs;
    }

    @Override
    public String toString() {
        return "AccountsPojo{" +
                "description='" + description + '\'' +
                ", balance=" + balance +
                ", accountType='" + accountType + '\'' +
                ", accountStatusType='" + accountStatusType + '\'' +
                ", createDate='" + createDate + '\'' +
                ", closedDate='" + closedDate + '\'' +
                ", employee=" + employee +
                ", accountlogs=" + accountlogs +
                '}';
    }
}
