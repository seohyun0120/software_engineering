import java.awt.*;
import java.io.*;
import java.util.*;

public interface AppointInterface {
	public abstract int insert(AppointInfo info);
	public abstract ArrayList<AppointInfo> select();
	public abstract AppointInfo select(int index);
	public abstract ArrayList<AppointInfo> select(String date);
	public abstract int update(int index, AppointInfo info);
	public abstract int delete(int index);
}
