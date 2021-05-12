package mvc.fx;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(
	urlPatterns = {"/article/*"},
	loadOnStartup = 10)
public class DispatcherServlet extends HttpServlet {
	
	private Map<String, AbstractController> controllerMap = new HashMap<>();
	@Override
	public void init() throws ServletException {
		
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream(this.getClass().getResource("dispatcher-servlet.properties").getPath()));
			for(Object oKey : prop.keySet()) {
				String key = ((String)oKey).trim();
				Class<?> className = null;
				try {
					className = Class.forName(prop.getProperty(key).trim());
					controllerMap.put(key, (AbstractController) className.getConstructor().newInstance());
					System.out.println("🧡 loaded : " + className + " 🧡");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("💔 error : " + className + " 💔");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String action = requestURI.substring(contextPath.length());
		//System.out.println(action);
		
		AbstractController controller = controllerMap.get(action);
		ModelAndView mav = controller.handleRquestInternal(request, response);
		
		if (mav != null) {
			
			String viewName = mav.getViewName();
			if (viewName.startsWith("redirect:")) {
				response.sendRedirect(viewName.substring(9));
			} else {
				Map<String, Object> model = mav.getModel();
				for(String key : model.keySet()) {
					request.setAttribute(key, model.get(key));
				}				
				RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
				dispatcher.forward(request, response);
			}
		} else {
			System.out.println("RequestDispatcher에서 길을 잃었다네~");
		}
	}
}