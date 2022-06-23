package Test;

@CustomComponent
public class UserAccountClientComponent {

    @CustomAutowired

    private UserService userService;

    @CustomAutowired
    @CustomQualifier(value = "accountServiceImpl")

    private AccountService accountService;

    public void displayUserAccount() {

        String username = userService.getUserName();

        Long accountNumber = accountService.getAccountNumber(username);

        System.out.println("User Name: " + username + "Account Number: " + accountNumber);

    }

}