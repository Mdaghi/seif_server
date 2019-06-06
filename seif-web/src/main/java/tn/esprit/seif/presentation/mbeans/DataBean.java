package tn.esprit.seif.presentation.mbeans;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import tn.esprit.seif.persistence.Role;


@ManagedBean
@ApplicationScoped
public class DataBean {

	public Role[] getRoles()
	{
		return Role.values();
	}

}
