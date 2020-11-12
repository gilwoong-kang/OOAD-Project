package store;

import entity.User;

public interface AccessStore {
	public User retrieve(String userNumber);
	public String create(User user);
	public String update(User user);
	public String delete(User user);
}
