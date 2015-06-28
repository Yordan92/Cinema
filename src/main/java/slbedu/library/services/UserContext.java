package slbedu.library.services;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import slbedu.library.dao.UserDAO;
import slbedu.library.model.User;

@SessionScoped
public class UserContext implements Serializable {

	private static final long serialVersionUID = -5185469629320384569L;
	
	@EJB
	private UserDAO userDAO;

	private User currentUser;
	
	public User getCurrentUser() {
		return currentUser;
	}
	
	public void setCurrentUser(User currentUser) {
		currentUser = userDAO.findUserByName(currentUser.getUserName());
		this.currentUser = currentUser;
	}
	
}
