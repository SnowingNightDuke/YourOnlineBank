package yob.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("titleController")
@RequestScoped
public class TitleController {
	private String title;
	public TitleController() {
		super();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@PostConstruct
	public void init() {
		this.title = "Banking Enterprise Application";
	}
}