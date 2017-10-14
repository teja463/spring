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
 * Servlet implementation class UploadServlet
 */
@WebServlet(urlPatterns="/UploadServlet", asyncSupported=true)
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long start = System.currentTimeMillis();
		
		AsyncContext async = request.startAsync();
		async.setTimeout(1500);
		async.addListener(new MyAsyncListener());
		async.start(new Runnable(){

			@Override
			public void run() {
				try {
					System.out.println("Processing by :"+Thread.currentThread().getName());
					Long start = System.currentTimeMillis();
					processFile(request, response);
					Long end = System.currentTimeMillis();
					System.out.println("Total file processing time: "+(end-start));
					async.complete();
				} catch (IOException | ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		
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
			if(response!=null)response.flushBuffer();
//			pw.flush();
			/*try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
