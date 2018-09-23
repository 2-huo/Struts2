package action;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;
import sericeImpl.UsersDaoImpl;
import service.UsersDao;

public class UsersAction extends SuperAction implements ModelDriven<Users>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users user = new Users();
	public  String login() {
		UsersDao userDao = new UsersDaoImpl();
		if(userDao.usersLogin(user)) {
			session.setAttribute("loginUserName",user.getUsername());
			return "login_success";
		}else {
			return "login_failure";
		}
		
	}
	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}
		

}
