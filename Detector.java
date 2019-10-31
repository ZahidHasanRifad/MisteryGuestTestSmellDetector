package testSmell.miseryGuest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;

public class Detector {

	private TestSmell testsmell;
	
	public Detector() {
		testsmell = new MiseryGuestSmell(); 	
	}
	
	public static Detector startDetecting() {
		return new Detector();
	}
	
	public String getSmellName() {
		return "Misery Guest";
	}
	
	 public TestFile detectMiseryGuestSmell(TestFile testfile) throws IOException,ParseException {
		 
		 CompilationUnit testFileCompilationUnit = null;
		 FileInputStream testFileInputStream;
		 
		 if(!StringUtils.isEmpty(testfile.getTestFilePath())) {
			 testFileInputStream = new FileInputStream(testfile.getTestFilePath());
			 testFileCompilationUnit = JavaParser.parse(testFileInputStream);
		 }
		 
		 testsmell = new MiseryGuestSmell();
		 try {
		 	testsmell.analysisMiseryGuestSmell(testFileCompilationUnit);
		 }catch(FileNotFoundException e) {
			 testfile.addMiseryGuestSmell(null);
		 }
		 testfile.addMiseryGuestSmell(testsmell);
		 return testfile;
	 }
}
