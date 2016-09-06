package UserValidation;

/**
 * Created by Family on 04.09.2016.
 */
public class UserAlreadyExistsException extends InvalidUserException
{
    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    @Override
    public String getMessage() {
        return "User already Exists";
    }
}