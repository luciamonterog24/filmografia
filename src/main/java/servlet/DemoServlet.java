package servlet;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/demoArticulo")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String DRIVER_BD = "com.mysql.jdbc.Driver";
	String RUTA_BD = "jdbc:mysql://localhost:3306/cine?useSSL=false";
	String USER_BD = "root";
	String PASS_BD = "";
	
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	public Connection getDBConnection() {
		
		try {
			Class.forName(DRIVER_BD);
		}catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			conn = DriverManager.getConnection(RUTA_BD, USER_BD, PASS_BD);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return conn;
		
	}
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Hola Servlet..");
		String action = request.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {
			case "mostrarPeliculas":
				mostrarPeliculas(request,response);
				break;
			case "mostrarPeliculaDirector":
				mostrarPeliculaDirector(request,response);
				break;
			case "login":
				login(request,response);
				break;
			default:
				break;
			}			
		} catch (SQLException e) {
			e.getStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet..");
		doGet(request, response);
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		ArrayList<Pelicula> peliculas = new ArrayList<>();
		
		conn = getDBConnection();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from pelicula");
			while (rs.next()) {
				Pelicula pelicula = new Pelicula();
				System.out.println(rs.getString(2));
				pelicula.setTitulo(rs.getString(2));;
				System.out.println(pelicula.getTitulo());
				pelicula.setDirector(rs.getString(1));
				System.out.println(pelicula.getDirector());
				pelicula.setFecha(rs.getString(3));
				System.out.println(pelicula.getFecha());
				
				peliculas.add(pelicula);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("peliculas", peliculas);
		RequestDispatcher dispatcher= request.getRequestDispatcher("/vista/mostrarPeliculas.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void mostrarPeliculas (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		
		ArrayList<Pelicula> peliculas = new ArrayList<>();
		
		conn = getDBConnection();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from pelicula");
			while (rs.next()) {
				Pelicula pelicula = new Pelicula();
				System.out.println(rs.getString(2));
				pelicula.setTitulo(rs.getString(2));;
				System.out.println(pelicula.getTitulo());
				pelicula.setDirector(rs.getString(1));
				System.out.println(pelicula.getDirector());
				pelicula.setFecha(rs.getString(3));
				System.out.println(pelicula.getFecha());
				
				peliculas.add(pelicula);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("peliculas", peliculas);
		RequestDispatcher dispatcher= request.getRequestDispatcher("/vista/mostrarPeliculas.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarPeliculaDirector(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		String director = request.getParameter("director");
		
		System.out.println(director);
		
		ArrayList<Pelicula> peliculas = new ArrayList<>();
		
		conn = getDBConnection();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from pelicula where director=" + "'" + director + "'");
			while (rs.next()) {
				Pelicula pelicula = new Pelicula();
				pelicula.setTitulo(rs.getString(2));;
				System.out.println(pelicula.getTitulo());
				pelicula.setDirector(rs.getString(1));
				System.out.println(pelicula.getDirector());
				pelicula.setFecha(rs.getString(3));
				System.out.println(pelicula.getFecha());
				
				peliculas.add(pelicula);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("peliculas", peliculas);
		RequestDispatcher dispatcher= request.getRequestDispatcher("/vista/mostrarPeliculas.jsp");
		dispatcher.forward(request, response);
		
	}
	
}
