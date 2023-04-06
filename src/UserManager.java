
public class UserManager {
	private User[] users = new User[0];
	private int counter = 0;

	public void addUser(User user) {
		reInitializeArray();
		users[counter] = user;
		counter++;
		System.out.println("Kullanıcı eklendi");
	}

	private void reInitializeArray() {
		User[] newUser = new User[users.length + 1];
		System.arraycopy(users, 0, newUser, 0, users.length);
		users = newUser;
	}

	public void removeUser(String id) {
		for (int i = 0; i < counter; i++) {
			if (users[i].getId().equals(id)) {
				User[] newUser = new User[users.length - 1];
				System.arraycopy(users, 0, newUser, 0, i);
				System.arraycopy(users, i + 1, newUser, i, users.length - i - 1);
				counter--;
				System.out.println("Kullanıcı silindi.");
				users = newUser;
			} else
				System.out.println("Kullanıcı bulunamadı");
			break;
		}
	}

	public User searchUser(String id) {
		for (int i = 0; i < counter; i++) {
			if (users[i].getId().equals(id)) {
				return users[i];
			}
		}
		return null;
	}

	public void listUsers() {
		for (int i = 0; i < counter; i++) {
			System.out.println(users[i].toString());
		}
	}

	public int userLogin(String name, String password) {
		for (int i = 0; i < counter; i++) {
			if (users[i].getName().equals(name) && users[i].getPassword().equals(password)) {
				return 0;
			}
		}
		return -1;
	}

}
