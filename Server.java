import java.net.*;
import java.io.*;
import java.util.Random; 

public class Server
{ 
  public static void main(String[] args)
  {
	try {
		int serverPort = 4020;
		ServerSocket ss = new ServerSocket(serverPort);
		InetAddress ip = InetAddress.getLocalHost();
		System.out.println("Server's current IP address : " + ip +", Port: "+serverPort);
		System.out.println("Waiting for client on port " + ss.getLocalPort() + "..."); 
		
		Socket s = ss.accept();
		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
		
		Random rand = new Random(); 
		int high=din.readInt();
		System.out.println("Client sent maximum value as "+high);
		int low=0,res,n;
		boolean correct=true;
		int max_guesses=din.readInt();
		System.out.println("Client sent maximum guesses as "+max_guesses+"\n");
		for(int i=0;i<max_guesses;i++)
		{
			if(correct)
			{
				n=rand.nextInt(high-low) + low;
				System.out.println("Attempt "+ (i+1) +": guessed number is "+n);
				dout.writeInt(n);
				res=din.readInt();
				System.out.println("Client sent "+res);
				if(res==0)
				{
					System.out.println("Correct guess");
					correct=false;
					break;
				}
				else if(res==1)
					high=n;
				else if(res==-1)
					low=n;
			}
			System.out.println("\n");
		}
		if(correct)
		{
			res=din.readInt();
			System.out.println("Correct value sent by client is "+res);
		}
		din.close();
		s.close();
		ss.close();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
  }
}