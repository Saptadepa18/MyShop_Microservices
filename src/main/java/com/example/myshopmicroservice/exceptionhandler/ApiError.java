package com.example.myshopmicroservice.exceptionhandler;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiError {
	
	private String errorcode;
	private String errorDesc;
	private Date date;

}
