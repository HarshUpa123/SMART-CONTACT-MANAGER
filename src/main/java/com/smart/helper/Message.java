package com.smart.helper;

import lombok.Data;

@Data

public class Message {

	public Message(String content, String type) {
		super();
		this.content = content;
		this.type = type;
	}
	private String content;
	private String type;
	
}
