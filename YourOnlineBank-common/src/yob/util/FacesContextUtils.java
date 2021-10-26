package yob.util;

import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesContextUtils {
	public static <T> T getManagedBean(String managedBeanName) {
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		return ((T)
				FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(elContext, null, managedBeanName));
	}
	public static <T> T getParameter(String key) {
		return (T)
				FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().
				get(key);
	}
	public static void showMessage(String msg) {

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
	}
}