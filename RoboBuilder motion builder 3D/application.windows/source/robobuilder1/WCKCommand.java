package robobuilder1;

public class WCKCommand {
	public static byte [] positionMove(int torq, int ID, int position) {
		byte [] packet = new byte [4];
		
		packet[0] = -1; // 0xFF 
		packet[1] = (byte) (torq << 5);
		packet[1] |= (byte) ID;
		packet[2] = (byte) position;
		packet[3] = (byte) ((packet[1] ^ packet[2]) & (byte) 0x7F);
		
		return packet;
	}
	
	public static byte [] passiveWCK(int ID) {
		byte [] packet = new byte [4];
		
		packet[0] = -1; // 0xFF
		packet[1] = (byte) (6 << 5);
		packet[1] |= (byte) ID;
		packet[2] = 16;
		packet[3] = (byte) ((packet[1] ^ packet[2]) & (byte) 0x7F);
		
		return packet;
	}
}
