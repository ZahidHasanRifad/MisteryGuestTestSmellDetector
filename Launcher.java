package testSmell.miseryGuest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.github.javaparser.ParseException;

public class Launcher {

	public static void main(String[] args) throws IOException, ParseException {
		
		List<File> files = new ArrayList<File>();
		
		String projectDir1 = "C:\\Users\\Hp\\Downloads\\batterylogger";
		String projectDir2 = "D:\\egit-master";
		String projectDir3 = "D:\\EquationSolverTest-master";
		
		files = ReadFile.getTestfiles(projectDir2);
		
		
		for(int i = 0; i<files.size(); i++) {
			String testFilePath = files.get(i).getAbsolutePath();
			String testClassName = files.get(i).getName();
			//String sourceFilePath = "C:\\Users\\Hp\\Downloads\\batterylogger\\src\\main\\java\\com\\gmail\\walles\\johan\\batterylogger\\SystemState.java";
			System.out.println("Testing test class  "+testClassName);
			Detector smellDetector = Detector.startDetecting();
			
			TestFile testfile = new TestFile(testFilePath);
			//OutputWriter result = OutputWriter.createResultsWriter();
			
			//result.writeColumnName(names);
			
			TestFile tempFile = smellDetector.detectMiseryGuestSmell(testfile);
			//values = new ArrayList<>();
		
			//System.out.println("start");
			
			
			for(TestSmell smell : tempFile.getMiseryGuestSmells()) {
				if(smell.getHasMiseryGuestSmell()) {
					System.out.println("Contain Mistery Guest smell");
					System.out.println("Status: "+String.valueOf(smell.getHasMiseryGuestSmell()));
				}
				else {
					System.out.println("Doesn't contain Mistery Guest smell");
					System.out.println("Status: "+String.valueOf(smell.getHasMiseryGuestSmell()));
				}//System.out.println(String.valueOf(smell.getHasMiseryGuestSmell()));
			}
			System.out.println();
		}
		
		
		//result.writeLine(values);
	}

}
