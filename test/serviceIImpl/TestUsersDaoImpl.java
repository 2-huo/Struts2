package serviceIImpl;

import org.junit.Test;

import entity.Users;
import sericeImpl.UsersDaoImpl;
import service.UsersDao;

public class TestUsersDaoImpl {
	@Test
	public void testUserLogin() {
		Users user = new Users(1, "zhangsan", "123456");
		UsersDao userDao = new UsersDaoImpl();
		boolean t = userDao.usersLogin(user);
		System.out.println(t);
	}
}
