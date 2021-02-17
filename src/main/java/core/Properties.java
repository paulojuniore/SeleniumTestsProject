package core;

public class Properties {
	
	public static boolean CLOSE_BROWSER = false;
	
	public static Browsers browser = Browsers.CHROME;
	
	public static ExecutionType EXECUTION_TYPE = ExecutionType.GRID;

	public enum Browsers {
		CHROME,
		FIREFOX
	}
	
	public enum ExecutionType {
		LOCAL,
		GRID
	}

}
