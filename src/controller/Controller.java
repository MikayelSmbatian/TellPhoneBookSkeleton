package controller;
import OutPutProperties.OutputProperties;
import REPO.DBHandler;
import common.exceptions.PasswordOverMismatch;
import common.exceptions.UserAlreadyExistsException;
import common.exceptions.UserNotFoundException;
import common.bean.User;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;



interface CreatingControllerI
{
    public static User createUser()
    {
        return null;
    }
    public static String creatingHELP()
    {
        return null;
    }

}
interface EditingControllerI
{
    public static User signIn(String username)
    {
        //Handles with signing in steps
        //Returns User reference if such User exists in DB
        //Otherwise throws exception or returns null
        return null;
    }
    public static boolean addFriend(User us,String usernameFriend)
    {
        //gets username User from DB
        //checks friendship
        //returns false if already friends
        //throws if such username is not found and informs to the User
        //returns true if everything is ok
        return true;
    }
    public static boolean deleteFriend(User us,String usernameFriend)
    {
        //gets "User with username" from DB.
        //throws exception if such user is not found in DB
        //checks relation between them.
        //returns false if such user weren't in friendship with Signed-In user.
        //returns true if everything is ok.
        return true;
    }
    public static void showTelNumbers(User user)
    {
        //checks if user exists in DB
        //shows tel numbers
    }
    public static void showFriends(User user)
    {
        //checks if user exists in DB
        //shows friends
    }
    public static boolean addTelNumber(User user, String telNumber)
    {
        //returns false if telNumber is already in List
        //graceful exception if user not found
        //returns true if already is ok
        return false;
    }
    public static String editingHELP()
    {
        //
        return null;
    }
    public static void signOut()
    {
        //returns from Editing Controller to the base controller
        //saves changes
    }
}

/** Singleton class(because I couldn't make it static) which handles control options
 * Has Editing Controller
 * Has Creating Controller
 * Has basic control options
 */
public class Controller
{
    static final Scanner scan = new Scanner(System.in);
    private static Controller control = null;
    OutputProperties property = new OutputProperties();
    public Controller()
    {
        ControllerCreateSingleton();
    }
    private Controller  ControllerCreateSingleton()
    {
        if(control ==  null)
            control = new Controller();
        return control;
    }
    static public void signUp()
    {
        User user = Util.createUser();
        try
        {
            DBHandler.createNewUserDBFolder(user);
        }
        catch (UserAlreadyExistsException e)
        {
            OutputProperties.printMessage("UserAlreadyExists");
            signUp();
        }

    }
    static public User signIn() throws PasswordOverMismatch
    {
        //username
        OutputProperties.printMessage("ProvideYourUsername");
        String username = scan.nextLine();
        User user = null;
        try
        {
            user = DBHandler.getUserFromDB(username);
        }
        catch (UserNotFoundException e)
        {
            return null;
        }
        //password
        int mismatchCount = 0;
        OutputProperties.printMessage("ProvideYourPassword");
        String password = scan.nextLine();
        while(!password.equals(user.getPassword())) {
            ++mismatchCount;
            OutputProperties.printMessage("IncorrectPassword");
            password = scan.nextLine();
            if (mismatchCount > 2)
                throw new PasswordOverMismatch();
        }
        return user;
    }
    static public void signOut()
    {}
    static public void addFriend(User user, String username) throws UserNotFoundException
    {
        User friend = DBHandler.getUserFromDB(username);
        if(friend.addToFriendList(user.getUsername())) {
            OutputProperties.printMessage("UserWasSuccessfullyAdded");
            DBHandler.serializeUser(friend);
        }
        else OutputProperties.printMessage("UserIsAlreadyInYourFriendList");

    }
    static public void showFriendsList(User user)
    {
        String list = user.getFriendsList();
        if(list.isEmpty())
            OutputProperties.printMessage("YouHaveNoFriends");
        System.out.println(list);
    }
    static public void deleteFriend(User user,String friendUsername) throws UserNotFoundException
    {
        if(user.deleteUserFromFriendList(friendUsername))
        {
            System.out.println("User " + friendUsername + " Is Removed From Your Friend List.");
            DBHandler.serializeUser(user);
        }
        else
        {
            System.out.println(friendUsername + " is not your friend.");
        }

    }
    static public void showTelNumbers(User user)
    {
        System.out.println(user.getAllAddressList());
    }

    static public void addTelNumber(User user, String address)
    {
        user.addToPhoneNumberList(address);
        OutputProperties.printMessage("AddressBeenAdded");
    }
    static public void exit()
    {
        OutputProperties.printMessage("SeeYouLater");

        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        System.exit(0);
    }
    static class Util
    {
        static User createUser()
        {
            User user = new User();
            OutputProperties.printMessage("ProvideYourUsername");
            user.setUsername(scan.nextLine());
            OutputProperties.printMessage("ProvideYourPassword");
            user.setPassword(scan.nextLine());
            user.setUsernameDBFolderPath(user.getUsername() + "DataBase.txt");
            user.setFriendsList(new TreeSet<>());
            user.setPhoneNumberList(new ArrayList<>());
            return user;
        }
    }
}



