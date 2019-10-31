package testSmell.miseryGuest;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFile {
	
	public static List<File> getTestfiles(String dirname){
		List<File> f = new ArrayList<File>();
		List<File> resultList = listf(dirname);
		
        for(int i=0; i<resultList.size(); i++) {
        	if(resultList.get(i).getName().endsWith(".java") && (resultList.get(i).getName().contains("Test")||resultList.get(i).getName().contains("test")||resultList.get(i).getName().contains("Tester")
        			||resultList.get(i).getName().contains("tester"))) {
        		f.add(resultList.get(i));
        	}
        }
        
        return f;
	}
	
	public static List<File> listf(String dirname) {
        File directory = new File(dirname);

        List<File> resultList = new ArrayList<File>();
//        List<File> testFilesPath = new ArrayList<File>();

        // get all the files from a directory
        File[] fList = directory.listFiles();
        resultList.addAll(Arrays.asList(fList));
        for (File file : fList) {
            if (file.isFile()) {
                //System.out.println(file.getAbsolutePath());
            } else if (file.isDirectory()) {
            	
                resultList.addAll(listf(file.getAbsolutePath()));
            }
        }
        
        //System.out.println(fList);
        return resultList;
    }  

}
