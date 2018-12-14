package utils;

public class StaticValues {
	
	private StaticValues() {
		throw new IllegalStateException("Utility class");
	}

	public static final String PATH_PROJECT = System.getProperty("user.dir");

	public static final String OS = System.getProperty("os.name");

	public static final int TIMEOUT = 30;
	
	protected static String CLASS;

	public static String getCLASS() {
		return CLASS;
	}

	public static void setCLASS(String cLASS) {
		CLASS = cLASS;
	}

}
