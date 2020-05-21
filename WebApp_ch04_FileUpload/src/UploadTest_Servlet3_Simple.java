import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;

@WebServlet("/uploadServlet3_simple.do")
@MultipartConfig
public class UploadTest_Servlet3_Simple extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		req.getPart("upfile1").write(getServletContext().getRealPath("/images_uploaded")+"/file.gif");

	}
}