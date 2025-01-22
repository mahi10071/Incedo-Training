package Day2;

public class DOBValidator {


    public boolean validate(String dob) {
        if (!dob.matches("^\\d{2} \\d{2} \\d{2}$")) {
            System.out.println("Invalid DOB. It must be in DD MM YY format.");
            return false;
        }
        return true;
    }
}
