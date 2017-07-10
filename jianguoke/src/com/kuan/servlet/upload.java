package com.kuan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jspsmart.upload.SmartUpload;

public class upload extends HttpServlet {
	

	
	private static final long serialVersionUID=1L;
	/**
	 * @WebServlet("/upload")
		@MultipartConfig(location="D:\\")
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		SmartUpload smartUpload = new SmartUpload();
		String msg=null;
		//out.print(msg);  
        try {  
            smartUpload.initialize(this.getServletConfig(), request, response); 
            smartUpload.upload();  
            msg=smartUpload.getRequest().getParameter("msg");
            System.out.println(smartUpload.getFiles().getCount());
            com.jspsmart.upload.File smartFile = smartUpload.getFiles().getFile(0);  
            if (!smartFile.isMissing()) {  
                String saveFileName =getServletContext().getRealPath("/")+ "images\\" + smartFile.getFileName();  
                System.out.println(saveFileName);
                //chuandaoshujuku saveFileName
                //saveFileName
                //json返回 
                //smartFile.saveAs(saveFileName, smartUpload.SAVE_VIRTUAL);  
                smartFile.saveAs(saveFileName, SmartUpload.SAVE_PHYSICAL);
                out.print("ok:" + saveFileName+ ", msg:" + smartUpload.getRequest().getParameter("msg"));
            } else {  
                out.print("missing...");  
            }  
        } catch (Exception e) {  
        	out.print(e+","+msg);  
        } 
		out.flush();
		out.close();
	}
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doGet(request, response);
	}
}
