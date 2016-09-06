package UserClass;

import ArtistClass.Artist;
import ControlerPack.Controller;
import REPO.DBHandler;
import UserValidation.UserNotFoundException;
import org.omg.CORBA.UnknownUserException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by Family on 02.09.2016.
 */
public class User implements Serializable
{
    private String username;
    private String password;
    private String usernameDBFolderPath;
    private ArrayList<String> phoneNumberList = new ArrayList<String>();
    private TreeSet<String> friendsList = new TreeSet<String>();
    private TreeSet<Artist> playelist;

    public User() {}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsernameDBFolderPath() {
        return usernameDBFolderPath;
    }

    public String getFriendsList()
    {
        String res = "";
        for(String x : friendsList)
            res += " --> " + x;
        return res;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setPhoneNumberList(ArrayList<String> phoneNumberList) {
        this.phoneNumberList = phoneNumberList;
    }

    public void setFriendsList(TreeSet<String> friendsList) {
        this.friendsList = friendsList;
    }

    public void setUsernameDBFolderPath(String usernameDBFolderPath)
    {
        this.usernameDBFolderPath = usernameDBFolderPath;
    }

    public boolean addToFriendList(String username)
    {
        return this.friendsList.add(username);
    }

    public boolean deleteUserFromFriendList(String username)
    {
       return this.friendsList.remove((String)username);
    }

    public boolean addToPhoneNumberList(String address)
    {
        return this.phoneNumberList.add(address);
    }

    private String getAddressList()
    {
        String res = "";
        for(String x : this.phoneNumberList)
        {
            res += "-> " + x + "\n";
        }
        return res;
    }
    private String getFriendsAddressList()
    {
        String res = "";
        if(this.friendsList.isEmpty())
        {
            return "You have no friends or your friends don't have any number.";
        }
        for(String x : this.friendsList)
        {
            User us = new User();
            try {
                us = DBHandler.getUserFromDB(x);
            } catch (UserNotFoundException e) {
                e.printStackTrace();
            }
            res += us.getAddressList();
        }
        return res;
    }
    public String getAllAddressList()
    {
        return this.getAddressList() + "\n friends' contacts: \n" + this.getFriendsAddressList();
    }
}
