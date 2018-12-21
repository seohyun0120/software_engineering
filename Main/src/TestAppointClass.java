import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.*;

public class TestAppointClass {
   String name = "John";
   String date = "2018-12-25";
   String time = " ";
   String location = "WesternDom";
   

   //AppointInfo appInfo = new AppointInfo(name, date, time, location);
   static AppointManager manager = new AppointManager();


   public static ArrayList<AppointInfo> list;

 


   @Test
   @DisplayName("Appointment Insert TEST if it contains any blank")
   public void testAppointInsert() {
      AppointInfo appoint = new AppointInfo(name,date,time,location);
      int size = manager.list.size();
      int afterInsertResult = manager.insert(appoint);
      int afterSize = manager.list.size();
      if(afterInsertResult == 0) {
    	  //size doesn't change
    	  assertEquals(size, afterSize);
      }
      else {
    	  //size+1
    	  assertEquals(size, afterSize-1);
    	  assertSame(manager.list.get(manager.list.size()-1), appoint);
      }
      
      
   }
   
   @Test
   @DisplayName("Appointment Select TEST")
   public void testAppointSelect() {
	
	   list=manager.select(date);
	   
	   if(list == null) {
		   assertSame(null,list);
	   }
	   else {
		   int size = list.size();
		   for(int i=0; i<size; i++) {
			   AppointInfo app = list.get(i);
			   assertEquals(app.getDate(),date);
		   }
	   }
   }
   
   
   
   
   
}
