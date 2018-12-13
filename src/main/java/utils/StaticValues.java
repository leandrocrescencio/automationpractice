package utils;

public class StaticValues {
	
	private StaticValues() {
		throw new IllegalStateException("Utility class");
	}

	public static final String PATH_PROJECT = System.getProperty("user.dir");

	public static final String OS = System.getProperty("os.name");

	public static String CLASS = "teste";

}
