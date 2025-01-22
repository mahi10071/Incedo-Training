package Day2;


public class EmailValidator {
    public boolean validate(String email) {
        if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            System.out.println("Invalid email format. Please use abc@domain.com.");
            return false;
        }
        return true;
    }
}