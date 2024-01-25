package oops;

public class Exception_Handling {
    public static void main(String[] args) throws CustomException {
        try {
            System.out.println(1 / 0);
        } catch(Exception e) {

            System.out.println("Exception Occurs: " + e.getMessage());
            throw new CustomException("Oops,... error");
        }

    }
}

// Custom Exception
class CustomException extends Exception {
    public CustomException(String errorMessage) {
        super(errorMessage);
    }
}
