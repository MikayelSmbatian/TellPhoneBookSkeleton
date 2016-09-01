package ControlerPack;
import UserClass.*;
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
    private static Controller controle = null;
    private Controller()
    {}
    public Controller  ControlerCreateSingleton()
    {
        if(controle ==  null)
            controle = new Controller();
        return controle;
    }
    static class CreatingControler implements CreatingControllerI
    {
        // creating controller with its private util methods
    }
    static class EditingControler implements  EditingControllerI
    {
        //Editing controller with its private util functions
    }

}
