package testSmell.miseryGuest;

import java.util.HashMap;
import java.util.Map;

public class TestMethod extends MiseryGuestElement{
	
	private String methodName;
	private boolean hasMiseryGuestSmell;
	private Map<String, String> miseryGuestSmells;
	
	public TestMethod(String methodName) {
		// TODO Auto-generated constructor stub
		this.methodName = methodName;
		miseryGuestSmells = new HashMap<String, String>();
	}
	
	public void setHasMiseryGuestSmell(boolean b) {
		hasMiseryGuestSmell = b;
	}
	@Override
	public boolean getHasMiseryGuestSmell() {
		return hasMiseryGuestSmell;
	}
	
	public void addMiseryGuestSmells(String smellName, String value) {
		miseryGuestSmells.putIfAbsent(smellName, value);
	}

	@Override
	public Map<String, String> getSmellData() {
		// TODO Auto-generated method stub
		return miseryGuestSmells;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return methodName;
	}
	

}
