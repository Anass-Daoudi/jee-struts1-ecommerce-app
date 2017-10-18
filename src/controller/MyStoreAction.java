package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import model.ProductDAOImpl;
import model.User;

public class MyStoreAction extends Action {
	public ActionForward execute(ActionMapping am, ActionForm af, HttpServletRequest request,
			HttpServletResponse response) {
		ProductDAOImpl u = new ProductDAOImpl();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		user.setMyProducts(u.myProducts(user.getId()));
		return am.findForward("myStore");
		/*
		 * ConnectionDB db = new ConnectionDB(); String req =
		 * "select image from store";
		 * 
		 * try { ResultSet rs = db.getStatement().executeQuery(req);
		 * 
		 * while (rs.next()) { InputStream is = rs.getBinaryStream("image");
		 * 
		 * System.out.println(is); }
		 * 
		 * rs.close(); } catch (SQLException e) { e.printStackTrace(); }
		 * db.closeConnection();
		 */
		// add code to generate all my product in list
		// getServletContext().getRequestDispatcher("/mystore.jsp").forward(request,
		// response);
	}
	/*
	 * public void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws IOException, ServletException {
	 * System.out.println("hello"); /* ConnectionDB db = new ConnectionDB();
	 * File file = new File("C:\\Users\\hp\\workspace2\\ecommerce\\pc.jpg");
	 * FileInputStream fis = new FileInputStream(file); String req =
	 * "insert into store (image) values(?)"; try { PreparedStatement ps =
	 * db.getConnection().prepareStatement(req);
	 * 
	 * ps.setBinaryStream(1, fis); ps.executeUpdate(); ps.close(); } catch
	 * (SQLException e) { e.printStackTrace(); } db.closeConnection();
	 * 
	 * add code to generate all categories in list
	 * getServletContext().getRequestDispatcher("/addproduct.jsp").forward(
	 * request, response); }
	 */
}