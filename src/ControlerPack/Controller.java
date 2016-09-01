package ControlerPack;
import UserClass.*;
interface CreatingControllerI
{
    public static User createUser()
    {
        return null;
    }
    public static boolean creatUserDB()
    {
        //should create a DB folder for User.
        //Return true if folder was created successfully

        return false;
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
    public static boolean addFriend(String username)
    {
        //gets username User from DB
        //checks friendship
        //returns false if already friends
        //throws if such username is not found and informs to the User
        //returns true if everything is ok
        return true;
    }
    public static boolean deleteFriend(String username)
    {
        //gets "User with username" from DB.
        //throws exception if such user is not found in DB
        //checks relation between them.
        //returns false if such user weren't in friendship with Signed-In user.
        //returns true if everything is ok.
        return true;
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
