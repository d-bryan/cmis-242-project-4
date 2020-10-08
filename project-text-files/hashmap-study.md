# Hashmap Study

## Input

```java
package cmis242.hashmap.pkg1;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class CMIS242HashMap1 {

    public static void main(String[] args) {

    Scanner input = new Scanner(System.in); 
    int indexCount = 0;
    String idValue;
            
    HashMap<String, java.util.List<String>> employee = new HashMap<String, java.util.List<String>>();
        
    java.util.List<String> staff01 = new ArrayList<String>();
    staff01.add("Joan Smith");
    staff01.add("Worker");
    staff01.add("Level 3");
    
    java.util.List<String> staff02 = new ArrayList<String>();
    staff02.add("Pete Blank");
    staff02.add("Supervisor");
    staff02.add("Level 2");
    
    java.util.List<String> staff03 = new ArrayList<String>();
    staff03.add("Mary Jones");
    staff03.add("Management");
    staff03.add("Level 1");
    
    employee.put("1321", staff01);
    employee.put("8765", staff02);
    employee.put("5634", staff03);
    
    for( Map.Entry<String, java.util.List<String>> entry : employee.entrySet()) {
        
        String key = entry.getKey();
        java.util.List<String> values = entry.getValue();
        
        System.out.print("\nKey = " + key);
        //System.out.println(" , Values = " + values);
        System.out.println("   +++++++++++++++++++ ");
        System.out.println("  Employee Name is " + values.get(0));
        System.out.println("  Position is " + values.get(1));
        System.out.println("  Payroll Code is " + values.get(2));
        
    }//end for( Map.Entry<String, List<String>> entry : employee.entrySet())
          
    }//end main ()
    
}//end class CMIS242HashMap1
```

## Output

IDE Output Window:

run:

Key = 8765   +++++++++++++++++++ <br/>
  Employee Name is Pete Blank<br/>
  Position is Supervisor<br/>
  Payroll Code is Level 2<br/>

Key = 1321   +++++++++++++++++++ <br/> 
  Employee Name is Joan Smith<br/>
  Position is Worker<br/>
  Payroll Code is Level 3<br/>

Key = 5634   +++++++++++++++++++ <br/> 
  Employee Name is Mary Jones<br/>
  Position is Management<br/>
  Payroll Code is Level 1<br/>
BUILD SUCCESSFUL (total time: 0 seconds)
