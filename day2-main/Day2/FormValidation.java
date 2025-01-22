
package Day2;

import java.util.Scanner;

// Main class for integrating validation classes and handling user input
public class FormValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create instances of validation classes
        NameValidator nameValidator = new NameValidator();
        EmailValidator emailValidator = new EmailValidator();
        DOBValidator dobValidator = new DOBValidator();
        UserValidator userValidator = new UserValidator();

        // Get user input for each field
        System.out.print("Enter Name (Alphanumeric): ");
        String name = sc.nextLine();
        if (!nameValidator.validate(name)) {
            return; // Exit if validation fails
        }

        System.out.print("Enter Email (abc@domain.com): ");
        String email = sc.nextLine();
        if (!emailValidator.validate(email)) {
            return; // Exit if validation fails
        }

        System.out.print("Enter Date of Birth (DD MM YY): ");
        String dob = sc.nextLine();
        if (!dobValidator.validate(dob)) {
            return; // Exit if validation fails
        }

        // All fields validated successfully
        userValidator.displayValidUserMessage();
    }
}