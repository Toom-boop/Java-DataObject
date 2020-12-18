public class Example {
  public static void main(String[] args){
    DataObject object = new DataObject();
    
    object.put("key1", "value1");
    object.put("key2", 2);
    object.put("key3", true);
    
    Dataobject object2 = new DataObject();
    object2.put("key", "value");
    
    object.put("key4", value);
    
    DataObject array = new DataObject();
    array.add("value1");
    array.add("value2");
    
    object.put("key5", array);
    
    System.out.println(object);
    
    DataObject parse = DataParser("{key:value}");
    System.out.println(parse.get("key"));
  }
}
