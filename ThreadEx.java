package com.threads.producerapp;

public class ThreadEx {

	public static void handleUserRequest() {
	
		System.out.println("starting thread : " + Thread.currentThread());
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("ending thread : " + Thread.currentThread());
		
	}
	
	public static void main (String[] args) {
		
		
		for (int i = 0; i <= 1000; i++)  {
			new Thread(() -> handleUserRequest()).start();
		}
		
	}
