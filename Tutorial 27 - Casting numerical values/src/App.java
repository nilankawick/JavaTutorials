
public class App {
	
	public static void main(String[] args) {
		
		System.out.println("Byte - "+Byte.MAX_VALUE +" - "+Byte.MIN_VALUE);
		System.out.println("Double - "+Double.MAX_VALUE +" - "+Double.MIN_VALUE);
		System.out.println("short - "+Short.MAX_VALUE+" - "+Short.MIN_VALUE);
		System.out.println("long - "+Long.MAX_VALUE+" - "+Long.MIN_VALUE);
		System.out.println("Integer - "+Integer.MAX_VALUE+" - "+Integer.MIN_VALUE);
		
		int x = -2147483648;
		
		System.out.println("x = "+x);
		
		int intVal = 23121982;
		long longVal = 9223372036854775807L;
		short shortVal = 3333;
		byte byteVal = 127;
		
		float floatVal = 2312.1982f;
		double doubleVal = 2312.1982;
		
		
		
		System.out.println();
		
		intVal = (int) longVal;
		
		System.out.println(intVal);
		
		System.out.println(floatVal);
		System.out.println(doubleVal);
		
		doubleVal = shortVal;
		
		System.out.println(doubleVal);
		
		intVal = (int) floatVal;
		
		System.out.println(intVal);
		
	}

}
