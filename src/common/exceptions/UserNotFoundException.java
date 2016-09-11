package common.exceptions;

/**
 * Created by Family on 04.09.2016.
 */
public class UserNotFoundException extends InvalidUserException
{
    @Override
    public String getMessage() {
        return "User not found ";
    }
}

