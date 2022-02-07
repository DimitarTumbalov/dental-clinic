package uni.fmi.models;
import java.util.*;

/**
 * 
 */
public class Role {
    private int id;
    private String name;
    private Set<User> users;
	
    /**
     * Default constructor
     */
    public Role() {
    }

    /**
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * @param id 
     * @return
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param role 
     * @return
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public Set<User> getUsers() {
        return users;
    }

    /**
     * @param users 
     * @return
     */
    public void setUsers(Set<User> users) {
        this.users = users;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}