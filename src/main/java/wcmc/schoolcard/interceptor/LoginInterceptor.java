package wcmc.schoolcard.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.util.HSSFColor.TEAL;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import wcmc.schoolcard.dto.Webteacher;
import wcmc.schoolcard.dto.Webxs;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handle, ModelAndView view) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handle) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Webxs webxs = (Webxs)session.getAttribute("xs");
		Webteacher webteacher = (Webteacher)session.getAttribute("teacher");
//		if (webxs != null)
//		{
//			System.out.println("interceptor true");
//			return true;
//		}
//		System.out.println("interceptor false");
		if (webxs == null && webteacher == null) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return false;
		}
		
		return true;
		
	}

}
