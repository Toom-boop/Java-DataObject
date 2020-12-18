public class SimpleDataObject extends DataObject {
	public String key;
	public String value;
	
	public SimpleDataObject(String value) {
		this.key = "";
		this.value = value;
	}
	
	public SimpleDataObject(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public SimpleDataObject(char c) {
		this.key = "" + c;
		this.value = "";
	}
	
	public void put(String key, String value) {
		this.value = value;
	}
	
	@Override
	public boolean isNotClose() {
		return key.charAt(0) != '}';
	}
	
	@Override
	protected String getKey() {
		return key;
	}

	@Override
	public DataObject get(String key) {
		return null;
	}
	
	@Override
	public String toString() {
		if(key == null || key.length() == 0) {
			return value;
		}
		return key + ":" + value;
	}

	@Override
	protected DataObject getValue() {
		return new SimpleDataObject(value);
	}

	@Override
	public DataObject get(int index) {
		// TODO Auto-generated method stub
		return null;
	}
}
