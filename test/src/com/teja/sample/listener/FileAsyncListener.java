package com.teja.sample.listener;

import java.io.IOException;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletResponse;

public class FileAsyncListener implements AsyncListener{

	@Override
	public void onComplete(AsyncEvent arg0) throws IOException {
		System.out.println("async completed");
	}

	@Override
	public void onError(AsyncEvent event) throws IOException {
		ServletResponse response = event.getAsyncContext().getResponse();
		response.getWriter().write("Error processing");
	}

	@Override
	public void onStartAsync(AsyncEvent arg0) throws IOException {
		System.out.println("async started");
	}

	@Override
	public void onTimeout(AsyncEvent arg0) throws IOException {
		System.out.println("async timeout.. calling async complete");
		ServletResponse response = arg0.getAsyncContext().getResponse();
		response.getWriter().write("timed out");
		arg0.getAsyncContext().complete();
	}

}
