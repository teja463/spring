package com.teja.sample.file;

import java.io.IOException;
import java.util.concurrent.ExecutorService;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teja.sample.listener.FileAsyncListener;

/**
 * Servlet implementation class FileProcessingServlet
 */
@WebServlet(urlPatterns="/FileProcessingServlet", asyncSupported=true)
@MultipartConfig
public class FileProcessingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileProcessingServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long start = System.currentTimeMillis();
		
		AsyncContext asyncContext = request.startAsync();
		request.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
		asyncContext.addListener(new FileAsyncListener());
//		asyncContext.setTimeout(1000);
		
		ExecutorService executor = (ExecutorService) request.getServletContext().getAttribute("executor");
		System.out.println(executor);
		executor.execute(new FileProcessingThread(asyncContext));
		System.out.println(executor);
		
		Long end = System.currentTimeMillis();
		System.out.println("Total time: "+(end-start));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
