import bean.User;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserTest {

    List<User> userList = null;
    @Before
    public void setup() {
        userList = new ArrayList<User>();
        userList.add(new User("Ed","IT"));
        userList.add(new User("David","IT"));
        userList.add(new User("Mark","Finance"));
        userList.add(new User("Tim","Finance"));
        userList.add(new User("Jim","IT"));
        userList.add(new User("David","IT"));
        userList.add(new User("Bill","Ops"));
    }

    /**
     * Below test case is for Listing 1.
     * The collection manipulation without streams
     */
    @Test
    public void testUserListing1(){
        List<String> userNames = new ArrayList<String> ();
        for(User user : userList){
            if("IT".equals(user.getDepartment())){
                if(!userNames.contains(user.getName())){
                    userNames.add(user.getName());
                }
            }
        }
        assert(!userNames.isEmpty());
        System.out.println("Listing1 "+userNames);
    }

    /**
     * Below test case is for Listing 2.
     * The collection manipulation with streams
     */
    @Test
    public void testUserListing2(){
        List<String> userNames = userList.stream()
                .filter(user -> "IT".equals(user.getDepartment()))
                .map(User::getName)
                .distinct()
                .collect(Collectors.toList());
        assert(!userNames.isEmpty());
        System.out.println("Listing2 "+userNames);
    }

}
