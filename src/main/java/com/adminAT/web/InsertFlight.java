package com.adminAT.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adminAT.bean.Flight;
import com.adminAT.dao.FlightDao;

/**
 * Servlet implementation class InsertFlight
 */
@WebServlet(urlPatterns = {"/insert"})
public class InsertFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = 0;
		String departure_city = null,arrival_city = null,start_time = null,end_time = null, departure_time = null,arrival_time = null;
		int cost = 0,stops = 0;
//		if(!request.getRequestURI().equals("/insert")) {
//			id = Integer.parseInt(request.getParameter("id"));
//		}
		
			departure_city = request.getParameter("departure_city");
			arrival_city = request.getParameter("arrival_city");
			cost = Integer.parseInt(request.getParameter("cost"));
			start_time = request.getParameter("start_time");
			end_time = request.getParameter("end_time");
			departure_time = request.getParameter("departure_time");
			arrival_time = request.getParameter("arrival_time");
			stops = Integer.parseInt(request.getParameter("stops"));
		
		Connection conn = (Connection)request.getServletContext().getAttribute("conn");
		FlightDao flightDao = (FlightDao) getServletContext().getAttribute("FlightDao");
		
			Flight newFlight = new Flight(departure_city, arrival_city, cost, start_time, end_time,departure_time,arrival_time, stops );
			try {
				flightDao.insertFlight(newFlight,conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		response.sendRedirect("listadmin");
	}

}
