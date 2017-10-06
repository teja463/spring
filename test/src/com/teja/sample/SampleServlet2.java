package com.teja.sample;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SampleServlet2
 */
@WebServlet("/SampleServlet2")
public class SampleServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SampleServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*StringBuilder builder = new StringBuilder("");
		try {
			LineNumberReader lnr = new LineNumberReader(new FileReader(
					"C:\\AIG\\workspaces\\fnol-next\\demo\\src\\main\\java\\com\\example\\demo\\lorem.txt"));
			int lineNo = 0;
			String line = lnr.readLine();
			while (line != null) {
				lineNo++;
				builder.append(line + "\n");
				line = lnr.readLine();
				if(lineNo%6000==0){
					System.out.println("lineNo: "+lineNo);
					Thread.sleep(5000);
				}
			}
		} catch (IOException | InterruptedException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().write(builder.toString());*/
		
		PrintWriter writer = response.getWriter();
		for(int i=0; i<1000; i++){
			
			writer.write("data: "+i+" "+new Date().toString()+"\n\n");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i+" loop");
		}
		System.out.println("loop done, closing writer");
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
