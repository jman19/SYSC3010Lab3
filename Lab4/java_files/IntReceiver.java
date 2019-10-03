
import java.net.*;
import java.nio.*;

public class IntReceiver {

	private final static int PACKETSIZE = 100 ;

	public static void main( String args[] )
	{ 
	      // Check the arguments
	      if( args.length != 1 )
	      {
	         System.out.println( "usage: UDPReceiver port" ) ;
	         return ;
	      }
	      try
	      {
	         // Convert the argument to ensure that is it valid
	         int port = Integer.parseInt( args[0] ) ;

	         // Construct the socket
	         DatagramSocket socket = new DatagramSocket( port ) ;

	         for( ;; )
	         {
                    System.out.println( "Receiving on port " + port + "\n" ) ;
                    DatagramPacket packet = new DatagramPacket( new byte[PACKETSIZE], PACKETSIZE ) ;
	            socket.receive( packet ) ;
                    Integer message;
                    message = ByteBuffer.wrap(packet.getData()).getInt();
                    
	            System.out.println( packet.getAddress() + " " + packet.getPort() + ": " + message + "\n\n") ;
	        }  
	     }
	     catch( Exception e )
	     {
	        System.out.println( e ) ;
	     }
  }
}

