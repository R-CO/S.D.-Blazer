package robobuilder1;

public class RBCCommandList {
	RBCCommandList() {
		//
	}
	
	public static byte [] toRBC_RunMotion(byte motion) {
		byte [] temp = {(byte) 0xFF, (byte) 0xFF, (byte) 0xAA, 0x55, (byte) 0xAA, 0x55, 0x37, (byte) 0xBA,
				0x14, (byte) 0xFF, 0x00, 0x00, 0x00, 0x01, motion, motion};
		return temp;
	}
	
	public static final byte [] toRBC_DirectControlMode = {(byte) 0xFF, (byte) 0xFF, (byte) 0xAA, 0x55, (byte) 0xAA, 0x55, 0x37, (byte) 0xBA,
			0x10, (byte) 0xFF, 0x00, 0x00, 0x00, 0x01, 0x01, 0x01};
	
	public static final byte [] fromRBC_DirectControlMode = {-1, -1, -86, 85, -86, 85, 55, -70,
			16, 1, 0, 0, 0, 1, 1, 1};
	
	public static final byte [] toRBC_DirectControlMode_Release = {(byte) 0xFF, (byte) 0xE0, (byte) 0xFB, 0x01, 0x00, 0x1A};
}
