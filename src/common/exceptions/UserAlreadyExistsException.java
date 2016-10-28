package common.exceptions;

/**
 * Created by Family on 04.09.2016.
 */
public class UserAlreadyExistsException extends InvalidUserException
{
    public UserAlreadyExistsException(String msg, Exception e) {
        super(msg, e);
    }
    public UserAlreadyExistsException()
    {}
    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    @Override
    public String getMessage() {
        return "User already Exists";
    }
}