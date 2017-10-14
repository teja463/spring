package com.teja.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teja.sample.listener.MyAsyncListener;

/**
 * Servlet implementation class UploadServlet2
 */
@WebServlet(urlPatterns="/UploadServlet2")
@MultipartConfig
public class UploadServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long start = System.currentTimeMillis();
		processFile(request, response);
		Long end = System.currentTimeMillis();
		System.out.println("Total time: "+(end-start));
	}

	private void processFile(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
		InputStream in = request.getPart("file").getInputStream();
		BufferedReader br = new BufferedReader( new InputStreamReader(in));
		PrintWriter pw = response.getWriter();
		String line = br.readLine();
		while(line!=null){
			pw.write(line+"\n");
			line=br.readLine();
//			response.flushBuffer();
			pw.flush();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		pw.close();
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
