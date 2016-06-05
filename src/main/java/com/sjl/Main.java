package com.sjl;

public class Main
{
	public static void main(String... anArgs) throws Exception
    {
        new Main().start();
    }
	
	private WebServer server;
    
    public Main()
    {
    	String portString = (String) System.getProperty("port");
    	int portNumber = 8000;
    	try{
    		portNumber = Integer.valueOf(portString);
    	}catch(Exception e ){
    		
    	}
        server = new WebServer(portNumber);        
    }
    
    public void start() throws Exception
    {
        server.start();        
        server.join();
    }
}
