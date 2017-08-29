package com.bigdata2017.web.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtil {
	public static void forward(
		String path, 
		HttpServletRequest request,
		HttpServletResponse response) 
		throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher( path );
		rd.forward( request, response );
	}
	
	public static void redirect(
		String url, 
		HttpServletRequest request, 
		HttpServletResponse response)
		throws ServletException, IOException {
		
		response.sendRedirect( url );
	}
	
	public static String checkNullParam(String s, String value) {
		return s != null ? s : value;
	}

	public static int checkNullParam(String s, int value) {
		return s != null ? checkIntParam(s, value) : value;
	}

	public static long checkNullParam(String s, long value) {
		return s != null ? checkLongParam(s, value) : value;
	}

	public static int checkIntParam(String s, int value) {
		return (s != null && s.matches("\\d+")) ? Integer.parseInt(s) : value;
	}

	public static long checkLongParam(String s, long value) {
		return (s != null && s.matches("\\d+")) ? Long.parseLong(s) : value;
	}	
}
