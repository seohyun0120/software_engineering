//import java.awt.*;
import java.io.*;
import java.util.*;
//import java.io.Serializable;

public class TodoInfoManager implements TodoMenu {
	private static TodoInfoManager instance = null;

	private TodoInfoManager() {
		initDataDir();
		initDataFile();
	}

	public static TodoInfoManager getInstance() {
		if (instance == null) {
			instance = new TodoInfoManager();
		}
		return instance;
	}

	public ArrayList<TodoInfo> list;

	private static final String DATA_DIR = "data";
	private static final String DATA_FILE = "contact.data";

	private File dataDir;
	private File dataFile;

	private void initDataDir() {
		dataDir = new File(DATA_DIR);
		System.out.println("폴더 경로 : " + dataDir.getPath());
		System.out.println("절대 경로 : " + dataDir.getAbsolutePath());

		if (!dataDir.exists()) {  
			if (dataDir.mkdir()) {
				System.out.println("폴더 생성 success");
			} else {
				System.out.println("폴더 생성 fail");
			}
		} else { 
			System.out.println("Folder Already Exists");
		}
	}

	private void initDataFile() {
		String filePath = DATA_DIR + File.separator + DATA_FILE;
		dataFile = new File(filePath);
		System.out.println("파일 경로 : " + dataFile.getPath());
		System.out.println("절대 경로 : " + dataFile.getAbsolutePath());

		if (!dataFile.exists()) { 
			System.out.println("New Data File added");
			list = new ArrayList<>();
		} else {
			System.out.println("Already exists");
			readDataFromFile();
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
			out = new FileOutputStream("data/contact.data");
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
<<<<<<< HEAD

=======
>>>>>>> dev-Huikyung
	@Override
	public ArrayList<TodoInfo> select() {
		return list;
	}
<<<<<<< HEAD

=======
>>>>>>> dev-Huikyung
	@Override
	public TodoInfo select(int index) {
		if (index >= 0 && index < list.size()) {
			return list.get(index);
		} else {
			return null;
		}
	}
<<<<<<< HEAD

=======
>>>>>>> dev-Huikyung
	@Override
	public int update(int index, TodoInfo info) {
		if (index >= 0 && index < list.size()) {
			list.set(index, info);
			writeDataToFile();
			return 1;
		} else {
			return 0;
		}
	}
<<<<<<< HEAD
	
=======
>>>>>>> dev-Huikyung
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
}
