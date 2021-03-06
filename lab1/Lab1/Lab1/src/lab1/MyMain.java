package lab1;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map; 
public class MyMain {
	
		public static void main(String[] args)  
		{  
			
		}
	
	
	 public static List<Class<?>> findClasses(File directory, String packageName) throws ClassNotFoundException {
		 
		         List<Class<?>> classes = new ArrayList<>();
		
		         if (!directory.exists()) {
		 
		             return classes;
		 
		         }
		
		         File[] files = directory.listFiles();
		 
		         for (File file : files) {
		 
		             if (file.isDirectory()) {
		 
		                 assert !file.getName().contains(".");
		 
		                 classes.addAll(findClasses(file, packageName + "." + file.getName()));
		 
		             } else if (file.getName().endsWith(".java")) {
		
		                 String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
		
		                 classes.add(Class.forName(className));
		 
		             }
		 
		         }
		 
		         return classes;
		 
		     }

}
