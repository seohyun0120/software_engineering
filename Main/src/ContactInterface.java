import java.awt.*;
import java.io.*;
import java.util.*;

public interface ContactMenu {
	public abstract int insert(ContactInfo info);
	public abstract ArrayList<ContactInfo> select();
	public abstract ContactInfo select(int index);
	public abstract int update(int index, ContactInfo info);
	public abstract int delete(int index);
}
