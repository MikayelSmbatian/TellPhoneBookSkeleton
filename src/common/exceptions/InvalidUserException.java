package common.exceptions;

/**
 * Created by Family on 04.09.2016.
 */
public class InvalidUserException extends Exception
{
    @Override
    public void printStackTrace()
    {
        super.printStackTrace();
    }
    @Override
    public String getMessage()
    {
        return "INVALID USER";
    }

    InvalidUserException(String msg,Exception e)
    {
        super(msg,e);
    }

    InvalidUserException()
    {

    }
}

