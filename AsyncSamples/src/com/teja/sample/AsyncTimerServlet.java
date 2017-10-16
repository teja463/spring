package com.teja.sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SampleServlet3
 */
@WebServlet("/AsyncTimerServlet")
public class AsyncTimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AsyncTimerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/event-stream");
		response.setCharacterEncoding("UTF-8");
		System.out.println("Buffer size"+response.getBufferSize());
		PrintWriter writer = response.getWriter();
		for (int i = 0; i < 1000; i++) {

			try {
				writer.write("data: " + i + " " + new Date().toString() + "\n\n");
				response.flushBuffer();
				Thread.sleep(100);
			} catch (/*IOException |*/ InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i + " loop");
		}
		System.out.println("loop done, closing writer");
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
