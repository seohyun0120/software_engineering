import java.awt.*;
import java.io.*;
import java.util.*;
import java.io.Serializable;

public class AppointManager implements AppointInterface {
	private static AppointManager instance = null;

	public AppointManager() {
		initDataDir();
		initDataFile();
	}

	public static AppointManager getInstance() {
		if (instance == null) {
			instance = new AppointManager();
		}
		return instance;
	}

	public ArrayList<AppointInfo> list;

	private static final String DATA_DIR = "data";
	private static final String DATA_FILE = "appoint.data";

	private File dataDir;
	private File dataFile;

	private void initDataDir() {
		dataDir = new File(DATA_DIR);
		System.out.println("folder path : " + dataDir.getPath());
		System.out.println("absolute path : " + dataDir.getAbsolutePath());

		if (!dataDir.exists()) {  
			if (dataDir.mkdir()) {
				System.out.println("folder create success");
			} else {
				System.out.println("folder create fail");
			}
			
		} else { 
			System.out.println("Folder Already Exists");
			
		}
	}

	private void initDataFile() {
		String filePath = DATA_DIR + File.separator + DATA_FILE;
		dataFile = new File(filePath);
		System.out.println("file path : " + dataFile.getPath());
		System.out.println("absoulte path : " + dataFile.getAbsolutePath());

		if (!dataFile.exists()) { 
			System.out.println("New Data File added");
			list = new ArrayList<>();
		} else {
			System.out.println("Already exists");
			readDataFromFile();
		}
	}

	private void readDataFromFile() {
		InputStream in = null;
		BufferedInputStream bin = null;
		ObjectInputStream oin = null;
		try {
			in = new FileInputStream(dataFile);
			bin = new BufferedInputStream(in);
			oin = new ObjectInputStream(bin);
			list = (ArrayList<AppointInfo>) oin.readObject();
			System.out.println("Print File success");
			
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oin.close();
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void writeDataToFile() {
		OutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;
		
		try {
			out = new FileOutputStream("data/appoint.data");
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);
			oout.writeObject(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public int insert(AppointInfo info) {
		
		if(info.getName().trim().length()<=0) {
			return 0;
		}
		if(info.getDate().trim().length()<=0) {
			return 0;
		}
		if(info.getTime().trim().length()<=0) {
			return 0;
		}
		if(info.getLocation().trim().length()<=0) {
			return 0;
		}
		list.add(info);
		writeDataToFile();
		return 1;
	}



	@Override
	public AppointInfo select(int index) {
		if (index >= 0 && index < list.size()) {
			return list.get(index);
		} else {
			return null;
		}
	}
	
	@Override
	public ArrayList<AppointInfo> select(String date) {
		ArrayList<AppointInfo> searchedList=new ArrayList<>();
		int idx = list.size();
		boolean flag = false;
		for(AppointInfo app : list) {
			if(app.getDate().equals(date)) {
				searchedList.add(app);
				flag = true;
			}
		}
		if(flag == true)
			return searchedList;
		else
			return null;
	}
	
	@Override
	public int update(int index, AppointInfo info) {
		if (index >= 0 && index < list.size()) {
			if(info.getName().trim().length()<=0) {
				return -1;
			}
			if(info.getDate().trim().length()<=0) {
				return -1;
			}
			if(info.getTime().trim().length()<=0) {
				return -1;
			}
			if(info.getLocation().trim().length()<=0) {
				return -1;
			}
			list.set(index, info);
			writeDataToFile();
			return 1;
		} else {
			return 0;
		}
	}
	
	@Override
	public int delete(int index) {
		if (index >= 0 && index < list.size()) {
			list.remove(index);
			writeDataToFile();
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public ArrayList<AppointInfo> select() {
		// TODO Auto-generated method stub
		return list;
	}
}