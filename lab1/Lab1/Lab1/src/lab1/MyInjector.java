package lab1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.*;

public class MyInjector {
	
	
	//new Reflections("lab1.package").getTypesAnnotatedWith(MyAutowired.class);
	
	
	private Map<Class,Object> container = new HashMap<>();
	
	
	public void scanForBeans() throws ClassNotFoundException, IOException {
		
		//search
	container.put(MyInjector.getClasses("lab1"),new Object());
		// put your map
	}
	
	public void scanForAutowired() {
		// to search autowired class
	}
	
	public static  Class[] getClasses(String packageName) throws ClassNotFoundException, IOException {
		
		        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		
		        assert classLoader != null;
		
		        String path = packageName.replace('.', '/');
		
		        List<File> dirs = new ArrayList<>();
		      
		        List<Class<?>> classes = new ArrayList<>();	
		       
		      
                for (File directory : dirs) {
       
                    classes.addAll(findClasses(directory, packageName));
      
                }
		        return classes.toArray(new Class[classes.size()]);
		
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

	     } else if (file.getName().endsWith(".class")) {
	
	         String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
	
	         classes.add(Class.forName(className));
	
	     }

         }
		 
		 return classes;
		 
  }

}
