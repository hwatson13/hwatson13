package toEat;
public class User {
    // @param name Entered name of the User.
    private String name;
    
    /**
     * Default Constructor for User.
     * @param name
     */
    public User(String name) {
        this.name = name;
    }
    
    /**
     * Retrieves the users' name.
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Changes or sets the users' name.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}

