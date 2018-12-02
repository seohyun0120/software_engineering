import java.awt.*;
import java.io.*;
import java.util.*;
import java.io.Serializable;

public class ContactInfoManager implements ContactMenu {
	private static ContactInfoManager instance = null;

	private ContactInfoManager() {
		initDataDir();
		initDataFile();
	}

	public static ContactInfoManager getInstance() {
		if (instance == null) {
			instance = new ContactInfoManager();
		}
		return instance;
	}

	public ArrayList<ContactInfo> list;

	private static final String DATA_DIR = "data";
	private static final String DATA_FILE = "contact.data";

	private File dataDir;
	private File dataFile;

	private void initDataDir() {
		dataDir = new File(DATA_DIR);
		System.out.println("folder path: " + dataDir.getPath());
		System.out.println("folder absolute path: " + dataDir.getAbsolutePath());

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
		System.out.println("file path : " + dataFile.getPath());
		System.out.println("file absolute path: " + dataFile.getAbsolutePath());

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
			list = (ArrayList<ContactInfo>) oin.readObject();
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
	public int insert(ContactInfo info) {
		list.add(info);
		writeDataToFile();
		return 1;
	}

	@Override
	public ArrayList<ContactInfo> select() {
		return list;
	}

	@Override
	public ContactInfo select(int index) {
		if (index >= 0 && index < list.size()) {
			return list.get(index);
		} else {
			return null;
		}
	}

	@Override
	public int update(int index, ContactInfo info) {
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
}