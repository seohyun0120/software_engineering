import java.awt.*;
import java.io.*;
import java.util.*;

public interface AppointMenu {
	public abstract int insert(AppointInfo info);
	public abstract ArrayList<AppointInfo> select();
	public abstract AppointInfo select(int index);
	public abstract int update(int index, AppointInfo info);
	public abstract int delete(int index);
}
