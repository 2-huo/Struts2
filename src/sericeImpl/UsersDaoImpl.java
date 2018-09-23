package sericeImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.Users;
import service.UsersDao;

public class UsersDaoImpl implements UsersDao{

	@Override
	public boolean usersLogin(Users user) {
		Transaction tx = null;
		String hql = "";
	 try {
		 Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
		 tx = session.beginTransaction();
		 hql="select * from USERS where USERNAME=? and PASSWORD=?";
		 Query query = session.createSQLQuery(hql);
		 query.setParameter(0, user.getUsername());
		 query.setParameter(1, user.getPassword());
		 List list = query.list();
		 tx.commit();
		 if(list.size()>0) {
			 return true;
		 }else {
			 return false;
		 }
		
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}finally{
		if(tx!=null) {
			
			tx=null;
		}
	}
	}
	

}
