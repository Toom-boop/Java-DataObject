package wfe.data;

public class DataParser {
	
	private static Stack<DataObject> stack;
	
	private static boolean alphaNumeric(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
	}
	
	public static void init() {
		stack = new Stack<DataObject>();
	}
	
	public static DataObject parse(String s) {
		DataParser.init();
		
		return DataParser.parseInternal(s);
	}
	
	private static DataObject parseInternal(String s) {
		DataObject result;
		for(int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			
			if(c == '}') {
				stack.add(new SimpleDataObject(c));
			}else if(c == ',') {
				stack.add(new SimpleDataObject(c));
			}else if(alphaNumeric(c)) {
				StringBuffer value = new StringBuffer();
				for(; i >= 0 && alphaNumeric(c = s.charAt(i)); i--) {
					value.insert(0, c);
				}
				StringBuffer key = new StringBuffer();
				if(c == ':') {
					i--;
					for(; i >= 0 && alphaNumeric(c = s.charAt(i)); i--) {
						key.insert(0, c);
					}
				}
				i++;
				stack.add(new SimpleDataObject(key.toString(), value.toString()));
			}else if(c == '{') {
				DataObject object = stack.godown();
				
				while(i > 0 && s.charAt(i--) != ':') {
					
				}
				
				StringBuffer key = new StringBuffer();
				for(; i >= 0 && alphaNumeric(c = s.charAt(i)); i--) {
					key.insert(0, c);
				}
				result = new DataObject(key.toString(), object);
				while(stack.getPosition() > 0 && stack.godown().isNotClose()) {
					DataObject element = stack.getCurrent();
					result.add(element);
				}
				if(stack.getPosition() > 0) {
					i++;
				}
				stack.add(result);
			}
		}
		
		return stack.pack();
	}
}