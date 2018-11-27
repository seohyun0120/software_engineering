import java.awt.*;
import java.io.*;
import java.util.*;
import java.io.Serializable;

public class AppointManager implements AppointMenu {
	private static AppointManager instance = null;

	private AppointManager() {
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
	public int update(int index, AppointInfo info) {
		if (index >= 0 && index < list.size()) {
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