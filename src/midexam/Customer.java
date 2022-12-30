/**
 * 
 */
package midexam;

/**
 * @author HP
 *
 */
public class Customer {
	static int id_num = 0;
	private int id;
	private String first_name;
	private String lasT_name;
	private String location;
	private String username;
	private String password;
	
	public Customer(String first_name, String last_name, String location, String username, String password) {
		id_num = id_num + 1;
		this.id = id_num;
		this.first_name = first_name;
		this.lasT_name = last_name;
		this.location = location;
		this.username = username;
		this.password = password;
	}
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Boolean login(String username, String password) {
		if(this.username.equals(username) && this.password.equals(password))
			return true;
		return false;
	}

	public String toCustomerString() {
		return "Customer [id=" + id + ", first_name=" + first_name + ", lasT_name=" + lasT_name + ", location="
				+ location + ", username=" + username + ", password=" + password + "]";
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLasT_name() {
		return lasT_name;
	}

	public String getLocation() {
		return location;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
