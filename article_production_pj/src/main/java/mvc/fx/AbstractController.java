package mvc.fx;

import javax.servlet.http.*;

public abstract class AbstractController {
	public abstract ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response);
}