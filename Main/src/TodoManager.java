import java.io.*;
import java.util.*;

public class TodoManager implements TodoInterface {
	private static TodoManager instance = null;
	private static final String DATA_DIR = "data";
	private static final String DATA_FILE = "todo.data";

	public TodoManager() {
		initDataDir(DATA_DIR);
		initDataFile(DATA_DIR, DATA_FILE);
	}

	public static TodoManager getInstance() {
		if (instance == null) {
			instance = new TodoManager();
		}
		return instance;
	}

	public ArrayList<TodoInfo> list;

	private File dataDir;
	private File dataFile;

	public int initDataDir(String dir) {
		dataDir = new File(dir);
		System.out.println("Folder path : " + dataDir.getPath());
		System.out.println("Folder absolute path : " + dataDir.getAbsolutePath());

		if (!dataDir.exists()) {  
			if (dataDir.mkdir()) {
				System.out.println("폴더 생성 success");
			} else {
				System.out.println("폴더 생성 fail");
			}
			return 1;
		} else { 
			System.out.println("Folder Already Exists");
			return 0;
		}
	}

	public int initDataFile(String dir, String file) {
		String filePath = dir + File.separator + file;
		dataFile = new File(filePath);
		System.out.println("파일 경로 : " + dataFile.getPath());
		System.out.println("절대 경로 : " + dataFile.getAbsolutePath());

		if (!dataFile.exists()) { 
			System.out.println("New Data File added");
			list = new ArrayList<>();
			return 1;
		} else {
			System.out.println("Already exists");
			readDataFromFile();
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	private void readDataFromFile() {
		InputStream in = null;
		BufferedInputStream bin = null;
		ObjectInputStream oin = null;
		try {
			in = new FileInputStream(dataFile);
			bin = new BufferedInputStream(in);
			oin = new ObjectInputStream(bin);
			list = (ArrayList<TodoInfo>) oin.readObject();
			System.out.println(list);
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
			out = new FileOutputStream("data/todo.data");
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
	public int insert(TodoInfo info) {
		list.add(info);
		writeDataToFile();
		return 1;
	}
	
	@Override
	public ArrayList<TodoInfo> select() {
		return list;
	}
	
	@Override
	public TodoInfo select(int index) {
		if (index >= 0 && index < list.size()) {
			return list.get(index);
		} 
		else {
			return null;
		}
	}
	
	@Override
	public int update(int index, TodoInfo info) {
		if (index >= 0 && index < list.size()) {
			list.set(index, info);
			writeDataToFile();
			return 1;
		} 
		else {
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
	public ArrayList<TodoInfo> select(String date) {
		ArrayList<TodoInfo> searchedList = new ArrayList<>();
		int idx = list.size();
		boolean flag = false;
		for(TodoInfo app : list) {
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
}