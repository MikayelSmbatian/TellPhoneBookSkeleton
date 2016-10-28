package common.exceptions;

/**
 * Created by Family on 05.09.2016.
 */
public class PasswordOverMismatch extends InvalidUserException
{
    public PasswordOverMismatch(String msg, Exception e)
    {
        super(msg, e);
    }
    public PasswordOverMismatch()
    {
        super();
    }
    @Override
    public void printStackTrace()
    {
        super.printStackTrace();
    }
}
