package com.base;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BaseAPI {

	static RequestSpecification given;
	static Response post;
	static ResponseBody body;

	public static void given() {
		try {
			given = RestAssured.given();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addHeader(String key, String value) {
		try {
			given = given.header(key, value);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void AddBody(File file) {
		try {
			given = given.body(file);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void AddBody(Object obj) {
		try {
			given = given.body(obj);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void AddBody(String value) {
		try {
			given = given.body(value);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void when() {
		try {
			given = given.when();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void AddMethodType(String methodType,String url) {
		try {
			switch (methodType) {
			case "Post":
				post = given.post(url);
				break;

			case "put":
				post = given.put(url);
				break;

			case "get":
				post = given.get(url);
				break;

			case "delete":
				post = given.delete(url);
				break;

			default:
				System.out.println("Invalid Method type");
				break;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static Object getBody(String key) {	
		String string = null; 
		
		try{
		body = post.getBody();
		JsonPath jsonPath = body.jsonPath();
		string = jsonPath.getString(key);
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return string;        
	}

	public static int getStatusCode() {
		int statusCode = post.getStatusCode();
		return statusCode;


	}


}
