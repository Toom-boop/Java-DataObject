# Java-DataObject
A simpler form of JSON for Java

# DataObject

***

## Create DataObject

```JAVA
DataObject object = new DataObject();
```

***

## Add Elements
```JAVA
object.put("key", <any object>);
```

***

## Get Elements
```JAVA
object.get("key");
```

***

## Print DataObject
```JAVA
System.out.println(object);
```

***

# DataArray

***

## Create DataArry
```JAVA
DataObject array = new DataObject();
```

***

## Add Elements
```JAVA
array.add(<any object>);
```

***

## Get Element
```JAVA
array.get(0);
```

***

# DataParser

***

## Parse
```JAVA
DataObject object = DataParser.parse("{key:value}");
```
