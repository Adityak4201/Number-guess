import java.io.*;
import java.net.*;
import java.util.Random; 

public class Client {
  public static void main(String args[]) 
  {
	try {
		int max_val, max_guesses, port;
		String ip;
		max_val=Integer.parseInt(args[0]);
		max_guesses=Integer.parseInt(args[1]);
		ip=args[2];
		port=Integer.parseInt(args[3]);
		System.out.println("Connecting to server on port " + port); 

		Socket s = new Socket(ip,port); 
		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
		
		Random rand = new Random(); 
		int n = rand.nextInt(max_val);
		System.out.println(n);
		dout.writeInt(max_val);
		dout.writeInt(max_guesses);
		int guess;
		boolean correct=true;
		for(int i=0;i<max_guesses;i++)
		{
			guess = din.readInt();
			System.out.println("Server guessed as "+guess);
			if(guess<n)
				dout.writeInt(-1);
			else if(guess>n)
				dout.writeInt(1);
			else
			{
				correct=false;
				dout.writeInt(0);
				break;
			}
		}
		if(correct)
			dout.writeInt(n);
		din.close();
		s.close();
		
	}
	catch(IOException e){
		e.printStackTrace();
	}
  }
}