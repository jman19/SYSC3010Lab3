import java.net.*;
import java.util.Scanner;
import java.util.Random;
import java.io.*;


public class IntSender {

	public static void main(String[] args) 
   {
	      // Check the arguments
	      if( args.length != 3 )
	      {
	         System.out.println( "usage: java UDPSender host port" ) ;
	         return ;
	      }
	      DatagramSocket socket = null ;
	      try
	      {
	         // Convert the arguments first, to ensure that they are valid
	         InetAddress host = InetAddress.getByName( args[0] ) ;
	         int port         = Integer.parseInt( args[1] ) ;
                 int messages = Integer.parseInt( args[2]);
	         socket = new DatagramSocket() ;
     
	         Scanner in;
	         in = new Scanner (System.in);
                 
                 Random rand = new Random();
                 int message;
                 
                 boolean quit = false;
                 
	         for(int i = 0 ; i < messages ; i++)
	         {
	        		// System.out.println("Enter text to be sent, ENTER to quit ");
	        		 message = rand.nextInt(100);
	        		 ByteArrayOutputStream bos = new ByteArrayOutputStream();
                                 DataOutputStream dos = new DataOutputStream(bos);
                                 dos.writeInt(message);
                                 dos.flush();
	        		 byte[] data = bos.toByteArray();
                                 
                                 
	        		 DatagramPacket packet = new DatagramPacket( data, data.length, host, port ) ;
	        		 socket.send( packet ) ;
	         } 
	         //System.out.println ("Closing down");
	      }
	      catch( Exception e )
	      {
	         System.out.println( e ) ;
	      }
	      finally
	      {
	         if( socket != null )
	            socket.close() ;
      }
   }
}

