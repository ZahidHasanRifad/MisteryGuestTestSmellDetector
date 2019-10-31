package testSmell.miseryGuest;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class MiseryGuestSmell extends TestSmell{
	
	private List<MiseryGuestElement> miseryGuestList;
	
	public MiseryGuestSmell() {
		// TODO Auto-generated constructor stub
		miseryGuestList = new ArrayList<>();
	}
	
	

	@Override
	public boolean getHasMiseryGuestSmell() {
		// TODO Auto-generated method stub
		return miseryGuestList.stream().filter(x->x.getHasMiseryGuestSmell()).count()>=1;
	}

	@Override
	public void analysisMiseryGuestSmell(CompilationUnit testFile) throws FileNotFoundException {
		// TODO Auto-generated method stub
		MiseryGuestSmell.ClassVisitor classVisitor;
		classVisitor = new MiseryGuestSmell.ClassVisitor();
		classVisitor.visit(testFile, null);
		
	}
	
	private class ClassVisitor extends VoidVisitorAdapter<Void>{
		private List<String> miseryTypes = new ArrayList<>(
				Arrays.asList(
						"File",
						"FileOutputStream",
						"SQLiteOpenHelper",
						"SQLiteDatabase",
						"Cursor",
						"Context",
						"HttpClient",
						"HttpResponse",
						"HttpPost",
						"HttpGet",
						"SoapObject"));
		
		private MethodDeclaration currentMethod = null;
		private int miseryCount = 0;
		TestMethod testMethod;
		
		public void visit(MethodDeclaration md, Void arg) {
			currentMethod = md;
			testMethod = new TestMethod(md.getName());
			
			//System.out.println(testMethod.getName());
			testMethod.setHasMiseryGuestSmell(false);
			super.visit(md,arg);
			//List<Node> s = currentMethod.getChildrenNodes();
			//System.out.println(currentMethod.getName());
			//System.out.println(s.size());
			//List<Node> s1 = s.get(1).getChildrenNodes();
			
			
//			if(s1.size()!=0) {
//				String line = s1.toString();
//				//System.out.println(s1.size());
			//	for(int i=0; i<s1.size(); i++) {
					//System.out.println(s1.get(i).getChildrenNodes());
				//}
				//System.out.println(s1.get(0).getChildrenNodes());
				//if(line.contains("File")) {
					//System.out.println(line);
				//}
				
			//}
			
			
//			if(line.contains("File")) {
//				System.out.println(line);
//			}
			//System.out.println(s);
			//System.out.println(s1.get(0));
			testMethod.setHasMiseryGuestSmell(miseryCount>0);
			
			
			testMethod.addMiseryGuestSmells("Misery Count", String.valueOf(miseryCount));
			if(testMethod.getHasMiseryGuestSmell()) {
				System.out.println("Method Name: "+testMethod.getName());
				//System.out.println(testMethod.getSmellData());
			}
			miseryGuestList.add(testMethod);
			currentMethod = null; 
			miseryCount = 0;
		}
		
		public void visit(VariableDeclarationExpr vd, Void arg) {
			super.visit(vd,arg);
			if(currentMethod != null) {
				for(String VariableType:miseryTypes) {
					//System.out.println(vd.getType().toString()+ " " + VariableType);
					String s = vd.toString();
					String type = vd.getType().toString();
					//System.out.println(vd.toString());
					if(type.equals(VariableType)) {
						if(s.contains(VariableType)) {
//							for(AnnotationExpr annotation: vd.getAnnotations()) {
//								if(annotation.getName().toString().equals("Mock") || annotation.getName().toString().equals("Spy")) {
//									break;
//								}
//							}
							miseryCount++;
							//System.out.println(miseryCount);
						}
					}
					
				}
				//System.out.println(miseryCount);
			}
		}
	}
	
	

	@Override
	public List<MiseryGuestElement> getMiseryGuestElements() {
		// TODO Auto-generated method stub
		return miseryGuestList;
	}
	
	

}
