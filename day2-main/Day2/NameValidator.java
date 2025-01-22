package Day2;

public class NameValidator {


    public boolean validate(String name) {
        if (!name.matches("[a-zA-Z0-9]+")) {
            System.out.println("Invalid name. It must be alphanumeric.");
            return false;
        }
        return true;
    }
}