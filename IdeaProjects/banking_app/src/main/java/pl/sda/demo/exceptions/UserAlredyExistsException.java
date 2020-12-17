package pl.sda.demo.exceptions;

public class UserAlredyExistsException extends RuntimeException{

    public UserAlredyExistsException(String message) {
       super(message);
    }
}
