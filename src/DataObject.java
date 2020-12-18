import java.util.ArrayList;
import java.util.Iterator;

public class DataObject {
	
	String key;
	ArrayList<DataObject> values;
	
	public DataObject() {
		values = new ArrayList<DataObject>();
	}
	
	public DataObject(String key, DataObject value) {
		this.key = key;
		values = new ArrayList<DataObject>();
		values.add(value);
	}
	
	public void add(Object value) {
		if(!value.toString().equals(",:")) {
			try {
				values.add((DataObject) value);
			}catch(ClassCastException e) {
				values.add(new SimpleDataObject(value.toString()));
			}
		}
	}
	
	public int size() {
		return values.size();
	}
	
	public Iterator<DataObject> iterator() {
		return values.iterator();
	}
	
	public void remove(int index) {
		values.remove(index);
	}
	
	public void clear() {
		values.clear();
	}
	
	public void put(String key, Object value) {
		for(DataObject object : values) {
			if(object.getKey().equals(key)) {
				try {
					values.add(new DataObject(key, (DataObject) value));
				}catch(ClassCastException e) {
					values.add(new SimpleDataObject(value.toString()));
				}
				return;
			}
		}
		try {
			values.add(new DataObject(key, (DataObject) value));
		}catch(ClassCastException e) {
			values.add(new SimpleDataObject(value.toString()));
		}
	}
	
	public void remove(String key) {
		for(int i = 0; i<values.size(); i++) {
			if(values.get(i).getKey().equals(key)) {
				values.remove(i);
				return;
			}
		}
	}
	
	protected boolean isNotClose() {
		return true;
	}
	
	protected String getKey() {
		return key;
	}
	
	protected DataObject getValue() {
		DataObject buffer = new DataObject();
		for(DataObject object : values) {
			buffer.add(object);	
		}
		return buffer;
	}

	
	public DataObject get(int index) {
		return values.get(index).getValue();
	}
	
	public DataObject get(String key) {
		for(int i = 0; i<values.size(); i++) {
			if(values.get(i).getKey().equals(key)) {
				return values.get(i).getValue();
			}
		}
		return null;
	}
	
	private StringBuffer build() {
		StringBuffer result;
		if(key == null || key.length() == 0) {
			result = new StringBuffer("{");
		}else {
			result = new StringBuffer(key + ":{");
		}
		
		boolean start = true;
		for(DataObject json : values) {
			if(start) {
				start = false;
				result.append(json.toString());
			}else {
				result.append("," + json.toString());
			}
		}
		result.append("}");
		return result;
	}
	
	@Override
	public String toString() {
		return this.build().toString();
	}
}
