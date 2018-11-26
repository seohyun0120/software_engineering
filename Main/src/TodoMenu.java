//import java.awt.*;
//import java.io.*;
import java.util.*;

public interface TodoMenu {
	public abstract int insert(TodoInfo info);
	public abstract ArrayList<TodoInfo> select();
	public abstract TodoInfo select(int index);
	public abstract int update(int index, TodoInfo info);
	public abstract int delete(int index);
}
