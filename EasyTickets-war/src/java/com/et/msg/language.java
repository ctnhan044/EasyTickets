package com.et.msg;

import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class language {

	private String locale = "en";

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String changeLocale(String locale){
		// Change the locale attribute
		this.locale = locale;
		// Change the locale of the view
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(this.locale));
		return "";
	}
}