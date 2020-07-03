package dsp56k_ghidra;

public class Utils {

	public static int readInt3(byte[] bytes) {
		int data = bytes[2] & 0xff;
		data <<= 8;
		data += bytes[1] & 0xff;
		data <<= 8;
		data += bytes[0] & 0xff;
		
		if ((data & 0x800000) != 0) {
			data = data + 0xFF000000;
		}
		
		return data;
	}

	public static long readInt6(byte[] bytes) {
		long data = bytes[5] & 0xff;
		data <<= 8;
		data += bytes[4] & 0xff;
		data <<= 8;
		data += bytes[3] & 0xff;
		data <<= 8;
		data += bytes[2] & 0xff;
		data <<= 8;
		data += bytes[1] & 0xff;
		data <<= 8;
		data += bytes[0] & 0xff;
		
		
		if ((data & 0x800000000000L) != 0) {
			data = data + 0xFFFF000000000000L;
		}
		
		return data;
	}

	public static long readInt7(byte[] bytes) {
		long data = bytes[6] & 0xff;
		data <<= 8;
		data += bytes[5] & 0xff;
		data <<= 8;
		data += bytes[4] & 0xff;
		data <<= 8;
		data += bytes[3] & 0xff;
		data <<= 8;
		data += bytes[2] & 0xff;
		data <<= 8;
		data += bytes[1] & 0xff;
		data <<= 8;
		data += bytes[0] & 0xff;

		if ((data & 0x80000000000000L) != 0) {
			data = data + 0xFF00000000000000L;
		}
		
		return data;
	}
}
