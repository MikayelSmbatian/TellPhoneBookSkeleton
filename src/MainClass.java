import controller.Controller;
import OutPutProperties.OutputProperties;
import REPO.DBHandler;
import common.bean.User;
import common.exceptions.PasswordOverMismatch;
import common.exceptions.UserNotFoundException;

import java.util.Scanner;

public class MainClass
{
    static private final OutputProperties property = new OutputProperties();
    static final Scanner scan = new Scanner(System.in);
    static void handleCommand(String command)
    {
        command = command.toUpperCase();
        switch (command)
        {
            case "SIGN UP":
            {
                Controller.signUp();
                break;
            }
            case "SIGN IN":
            {
                try
                {
                    User user = Controller.signIn();
                    while (user == null)
                    {
                        OutputProperties.printMessage("UserIsNotFound");
                        user = Controller.signIn();
                    }
                    handleSignedInCommand(user);
                }
                catch (PasswordOverMismatch P)
                {
                    return;
                }
                break;
            }
            case "EXIT":
            {
                Controller.exit();
            }
            default:
            {
                //help();
            }
        }
    }
    static void handleSignedInCommand(User user)
    {
        while(true)
        {
            OutputProperties.printMessage("SignedInHANDLE");
            String command = scan.nextLine();
            command = command.toUpperCase();
            switch (command) {
                case "SIGN OUT":
                {
                    DBHandler.serializeUser(user);
                    OutputProperties.printMessage("ChangesHasSaved");
                    OutputProperties.printMessage("GoodBye");
                    return;
                }
                case "FRIENDS": {
                    handleFRIENDCommands(user);
                    break;
                }
                case "ADDRESS BOOK":
                {
                    handleAddressBookCommands(user);
                    break;
                }
            }
        }
    }
    static public void handleFRIENDCommands(User user)
    {
        while (true)
        {
            OutputProperties.printMessage("FRIENDS");
            String command = scan.nextLine();
            command = command.toUpperCase();
            switch (command)
            {
                case "ADD FRIEND":
                {
                    OutputProperties.printMessage("ProvideUserToSendFriendRequest");
                    String friendUsername = scan.nextLine();
                    try {
                        Controller.addFriend(user, friendUsername);
                    } catch (UserNotFoundException e) {
                        OutputProperties.printMessage("UserIsNotFound");
                    }

                    break;
                }
                case "SHOW FRIENDS":
                {
                    Controller.showFriendsList(user);
                    break;
                }
                case "DELETE":
                {
                    OutputProperties.printMessage("ProvideUserToDelete");
                    String friend = scan.nextLine();
                    try {
                        Controller.deleteFriend(user, friend);
                    } catch (UserNotFoundException e) {
                        OutputProperties.printMessage("UserIsNotFound");
                    }
                    break;
                }
                case "RETURN":
                {return;}
                default:
                {}
            }
        }
    }
    static public void handleAddressBookCommands(User user)
    {

        while (true)
        {
            OutputProperties.printMessage("ADDRESSBOOK");
            String command = scan.nextLine();
            command = command.toUpperCase();
            switch (command)
            {
                case "ADD":
                {
                    OutputProperties.printMessage("ProvideAnyNumber");
                    String address = scan.nextLine();
                    Controller.addTelNumber(user, address);
                    break;
                }
                case "SHOW":
                {
                    Controller.showTelNumbers(user);
                    break;
                }
                case "BACK":
                {
                    return;
                }
            }
        }
    }
    public static void main(String [] args)
    {
        while (true)
        {
            OutputProperties.printMessage("HANDLE");
            String command = scan.nextLine();
            handleCommand(command);
        }
    }
}
