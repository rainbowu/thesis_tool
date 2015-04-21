package com.line.decrypt;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/update")

public class UpdateDate extends HttpServlet{
	private static final long serialVersionUID = 1L;
	   
    public UpdateDate() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Decryption decipher = new Decryption();
	    
		HashMap<String, Object> map = new HashMap<String,Object>();
		boolean isValid = false;
		String enigma = request.getParameter("enigma");
		String android_id = request.getParameter("android_id");
		String type = request.getParameter("table_type");
		
		String decryped_word = null;
		if(enigma != null && enigma.trim().length() != 0 ){
			isValid = true;
			map.put("enigma", enigma);
		}
		map.put("isValid", isValid);
		
		
		try {
			
			decryped_word = decipher.decrypt_aes(enigma , android_id , type);
			System.out.print(decryped_word);
			
			
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		map.put("decryped_word", decryped_word);
		
		Writeable(response,map);
	}

	private void Writeable(HttpServletResponse response,
			HashMap<String, Object> map) throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(new Gson().toJson(map));
		
	}

}
