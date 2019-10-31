package testSmell.miseryGuest;

import java.io.FileNotFoundException;
import java.util.List;

import com.github.javaparser.ast.CompilationUnit;

public abstract class TestSmell {
	
	public abstract boolean getHasMiseryGuestSmell();
	public abstract void analysisMiseryGuestSmell(CompilationUnit testFile)throws FileNotFoundException;
	public abstract List<MiseryGuestElement> getMiseryGuestElements();

}
