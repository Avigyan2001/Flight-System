package com.adminAT.web;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adminAT.bean.Flight;
import com.adminAT.dao.FlightDao;

/**
 * Servlet implementation class ListFlight
 */
@WebServlet(urlPatterns = {"/list", "/filtercitytime", "/filtertime"})
public class ListFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		Connection conn = (Connection) getServletContext().getAttribute("conn");
		FlightDao flightDao = (FlightDao) getServletContext().getAttribute("FlightDao");
		List<Flight> listFlight;
		if(request.getRequestURI().equals("/list")) {
			listFlight = flightDao.selectAllFlights(conn);
			request.setAttribute("uriType", "listFlight");
		}
		else if (request.getRequestURI().equals("/filtercitytime")) {
		    String departure_city = request.getParameter("departure_city");
			String arrival_city = request.getParameter("arrival_city");	
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			String minCost = request.getParameter("minCost");
			String maxCost = request.getParameter("maxCost");
			listFlight = flightDao.filterFlightCityTime(departure_city,arrival_city,startTime,endTime,minCost,maxCost,conn);
			request.setAttribute("uriType", "listFlightCity");
		}
		else {
			listFlight = flightDao.filterFlight(conn);
			request.setAttribute("uriType", "listFlightTime");
		}
		request.setAttribute("listFlight", listFlight);
		RequestDispatcher dispatcher = request.getRequestDispatcher("FlightListUser.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
