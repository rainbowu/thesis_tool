package com.line.decrypt;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.nio.cs.US_ASCII;

import com.google.gson.Gson;
import com.sun.corba.se.spi.ior.Writeable;
import com.sun.xml.internal.xsom.impl.scd.Iterators.Map;
/**
 * Servlet implementation class UpdateDate
 */
@WebServlet("/update")
public class UpdateDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("enigma"));
		HashMap<String, Object> map = new HashMap<String,Object>();
		boolean isValid = false;
		String enigma = request.getParameter("enigma");
		if(enigma != null && enigma.trim().length() != 0 ){
			isValid = true;
			map.put("enigma", enigma);
		}
		map.put("isValid", isValid);
		Writeable(response,map);
	}

	private void Writeable(HttpServletResponse response,
			HashMap<String, Object> map) throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(new Gson().toJson(map));
		
	}

}
