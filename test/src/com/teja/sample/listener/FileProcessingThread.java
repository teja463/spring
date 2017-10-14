package com.teja.sample.listener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileProcessingThread implements Runnable {

	private AsyncContext context;

	public FileProcessingThread(AsyncContext context) {
		this.context = context;
	}

	@Override
	public void run() {
		Long start = System.currentTimeMillis();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		HttpServletResponse response = (HttpServletResponse) context.getResponse();
		PrintWriter pw = null;
		try {
			InputStream in = request.getPart("file").getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			if(response!=null){
				pw = response.getWriter();
				String line = br.readLine();
				while (line != null) {
					pw.write(line + "\n");
					line = br.readLine();
//					response.flushBuffer();
					if(null!=pw)pw.flush();
				}
			}
			System.out.println("calling async complete");
			context.complete();
		} catch (IOException | ServletException e) {
			System.out.println("error");
			e.printStackTrace();
		} finally {
		}
		System.out.println("Total time for file processing: "+(System.currentTimeMillis()-start));
	}

}
