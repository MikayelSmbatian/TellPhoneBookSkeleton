package common.exceptions;

/**
 * Created by Family on 04.09.2016.
 */
public class UserNotFoundException extends InvalidUserException
{
    UserNotFoundException(String msg, Exception e)
    {
        super(msg, e);
    }
    public UserNotFoundException()
    {}
    @Override
    public String getMessage() {
        return "User not found ";
    }
}

