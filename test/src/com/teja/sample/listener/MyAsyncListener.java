package com.teja.sample.listener;

import java.io.IOException;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletResponse;

public class MyAsyncListener implements AsyncListener{

	@Override
	public void onComplete(AsyncEvent arg0) throws IOException {
		System.out.println("async completed");
	}

	@Override
	public void onError(AsyncEvent arg0) throws IOException {
		System.out.println("async error");
	}

	@Override
	public void onStartAsync(AsyncEvent arg0) throws IOException {
		System.out.println("async started");
	}

	@Override
	public void onTimeout(AsyncEvent arg0) throws IOException {
		System.out.println("async timeout");
		arg0.getAsyncContext().complete();
		ServletResponse response = arg0.getAsyncContext().getResponse();
		response.getWriter().write("timed out");
	}

}
