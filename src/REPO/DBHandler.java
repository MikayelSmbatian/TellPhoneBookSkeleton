package REPO;
import UserClass.User;
import UserValidation.*;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;

/**
 * Created by Family on 04.09.2016.
 */
public class DBHandler implements Serializable
{
    static public void createNewUserDBFolder(User user) throws UserAlreadyExistsException
    {
        // Creates a DB for User
        boolean isNewFileMade = false;
        File f = new File(user.getUsernameDBFolderPath());
        try
        {
            isNewFileMade = f.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
        if(!isNewFileMade)
            throw new UserAlreadyExistsException();
        DBHandler.serializeUser(user);
    }
    static public void serializeUser(User user)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(user.getUsernameDBFolderPath());
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(user);
            oos.flush();
            oos.close();
        }
        catch (Throwable t)
        {
            t.printStackTrace();
        }
    }
    static public User getUserFromDB(String username) throws UserNotFoundException
    {
        User user = new User();
        try
        {
            File f = new File(username + "DataBase.txt");
            if(!f.exists())
                throw new UserNotFoundException();
            FileInputStream fis = new FileInputStream(username + "DataBase.txt");
            ObjectInputStream oin = new ObjectInputStream(fis);
            user = (User) oin.readObject();
        }
        catch (IOException | ClassNotFoundException ioe)
        {
            ioe.printStackTrace();
        }
        return user;
    }

}
