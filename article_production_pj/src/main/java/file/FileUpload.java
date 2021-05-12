package file;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;

@WebServlet("/upload.do")
@MultipartConfig
public class FileUpload extends HttpServlet{
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
			String encoding = "utf-8";
			//업로드할 파일 정보 저장
			File currentDirPath=new File("/Users/yebin/Desktop");
			
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//파일 경로 생성
			factory.setRepository(currentDirPath);
			//최대 업로드 가능한 파일 크기 지정
			factory.setSizeThreshold(1024*1024);
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				//request 객체에서 매개 변수 리스트로 가져
				List items = upload.parseRequest(request);
				for(int i = 0; i < items.size(); i++) {
					//업로드된 항목을 가져옴
					FileItem fileItem = (FileItem) items.get(i);
					if(fileItem.isFormField()) {
						System.out.println(fileItem.getFieldName()+ "=" + fileItem.getString(encoding));
					}else {
						System.out.println("매개변수 이름 : " + fileItem.getFieldName());
						System.out.println("파일 이름 : " + fileItem.getName());
						System.out.println("파일 크기 : " + fileItem.getSize() + "bytes");
						if(fileItem.getSize() > 0) {
							int idx = fileItem.getName().lastIndexOf("\\");
							if(idx == -1) {
								idx = fileItem.getName().lastIndexOf("/");
							}
							//업로드한 파일 이름 가져옴
							String fileName = fileItem.getName().substring(idx + 1);
							File uploadFile = new File(currentDirPath + "\\" + fileName);
							fileItem.write(uploadFile);
						}
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}
