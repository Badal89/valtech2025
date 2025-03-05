package hibernate1.dao;

import java.util.List;
import hibernate1.LineItem;


public interface LineItemDAO {
	void addLineItem(LineItem lineitem);
	LineItem getLineItem(int id);
	List<LineItem> getAll();
	void updateLineItem(LineItem lineitem);
	void deleteLineItem(int id);
}