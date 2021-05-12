package file;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;


public class FileDownload extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
				doHandle(request, response);
			}
			
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
				doHandle(request, response);
			}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			String file_repo="/Users/yebin/Desktop";
			//매개변수로 전송된 파일 이름 가져옴
			String fileName = (String)request.getParameter("fileName");
			System.out.println("fileName="+fileName);
			//response에서 outputstream 객체 가져옴
			OutputStream out = response.getOutputStream();
			String downFile=file_repo+"/"+fileName;
			File f = new File(downFile);
			response.setHeader("Cache-Control", "no-cache");
			response.addHeader("Content-diposition", "attachment; fileName="+fileName);
			
			FileInputStream in = new FileInputStream(f);
			byte[] buffer = new byte[1024*8];
			while(true) {
				int count=in.read(buffer);
				if(count==-1)
					break;
				out.write(buffer,0,count);
			}
			in.close();
			out.close();
			}
}
