package io.github.rafaelsilva91.springsocial.dto;

import java.io.Serializable;
import java.util.Date;

import io.github.rafaelsilva91.springsocial.entities.Comment;
import io.github.rafaelsilva91.springsocial.entities.User;

public class CommentDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String text;
	private Date date;
	private User author;
	
	public CommentDTO(){
		super();
	
	}
	
	public CommentDTO(Comment obj) {
		id = obj.getId();
		text = obj.getText();
		date = obj.getDate();
		author = obj.getAuthor();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
		
}
