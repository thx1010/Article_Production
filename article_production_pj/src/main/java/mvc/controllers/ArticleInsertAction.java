package mvc.controllers;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;

import mvc.fx.*;
import mvc.models.*;
import mvc.service.*;

public class ArticleInsertAction extends AbstractController {

	ArticleService articleService = ArticleServiceImpl.getInstance();

	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String subtitle = request.getParameter("subtitle");
		String leadsentence = request.getParameter("leadsentence");
		String divide = request.getParameter("divide");
		String content = request.getParameter("content");
		String photo = request.getParameter("photo");

		ArticleDTO articleDTO = new ArticleDTO();
		articleDTO.setTitle(title);
		articleDTO.setSubtitle(subtitle);
		articleDTO.setLeadsentence(leadsentence);
		articleDTO.setDivide(divide);
		articleDTO.setContent(content);
		//articleDTO.setId(id);
		//articleDTO.setPassword(password);
		//articleDTO.setEmail(email);
		articleDTO.setPhoto(photo);
		System.out.println(articleDTO);
		
		
		ModelAndView mav = new ModelAndView();
		try {
			articleService.insertArticle(articleDTO);
			mav.setViewName("redirect:list");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("/WEB-INF/views/result.jsp");
			mav.addObject("msg", "글 등록에 실패하였습니다.");
			mav.addObject("url", "javascript:history.back();");
		}
		return mav;
	}
	
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
					File currentDirPath=new File("/Users/yebin/Desktop/res");
					DiskFileItemFactory factory = new DiskFileItemFactory();
					factory.setRepository(currentDirPath);
					factory.setSizeThreshold(1024*1024);
					ServletFileUpload upload = new ServletFileUpload(factory);
					try {
						List items = upload.parseRequest(request);
						for(int i = 0; i < items.size(); i++) {
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