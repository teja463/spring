package com.teja.sample;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SampleServlet
 */
@WebServlet("/SampleServlet")
public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SampleServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/event-stream");	
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		try {

			LineNumberReader lnr = new LineNumberReader(new FileReader(
					"C:\\AIG\\workspaces\\fnol-next\\demo\\src\\main\\java\\com\\example\\demo\\lorem.txt"));
			int lineNo = 0;
			String line = lnr.readLine();
			while (line != null) {
				lineNo++;
 				line = lnr.readLine() + "\n";
				writer.write(line);
				// writer.write(line);
				line = lnr.readLine();
//				os.flush();
				if(lineNo%6000==0){
					System.out.println("lineNo: "+lineNo);
					Thread.sleep(5000);
				}
			}

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		writer.close();
		System.out.println("closed");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
