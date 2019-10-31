package testSmell.miseryGuest;

import java.util.ArrayList;
import java.util.List;

public class TestFile {

	private String testFilePath;
	private List<TestSmell> miseryGuestSmells;

	public TestFile(String testFilePath) {

		this.testFilePath = testFilePath;

		this.miseryGuestSmells = new ArrayList<>();

	}

	public String getTestFilePath() {
		return testFilePath;
	}

	public List<TestSmell> getMiseryGuestSmells() {
		return miseryGuestSmells;
	}

	public void addMiseryGuestSmell(TestSmell miseryGuestSmell) {
		miseryGuestSmells.add(miseryGuestSmell);
	}

}
