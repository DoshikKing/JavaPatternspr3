package com.company;

public class Main {
    static volatile MyMap map = new MyMap(10);
    static volatile MySet set = new MySet();
    static void increment() {
//        System.out.println(map.put("key",1));
//        System.out.println(map.put("key1",2));
//        System.out.println(map.put("key2",3));
//        System.out.println(map.remove("key"));
//        System.out.println(map.remove("key1"));
//        System.out.println(map.remove("key2"));
        System.out.println(set.add("key"));
        System.out.println(set.add("key1"));
        System.out.println(set.add("key2"));
    }
    public static void main(String[] args) throws Exception {
// Check
//	System.out.println(map.put("key",1));
//	System.out.println(map.put("key1",2));
//	System.out.println(map.put("key2",3));
//	System.out.println(map.get("key"));
//	System.out.println(map.remove("key1"));
//	System.out.println("Size" + map.size());
//	System.out.println(map.get("key1"));
//	System.out.println(map.put("key3",4));
//	System.out.println(map.get("key3"));
//	System.out.println("Size" + map.size());
//    System.out.println(map.isEmpty());
        Thread one = new Thread(()->{for (int i = 0; i < 5000; i++) {
            increment();
        }});
        Thread two = new Thread(()->{for (int i = 0; i < 5000; i++) {
            increment();
        }});
        one.start();
        two.start();
        Thread.sleep(3000);
        System.out.println(map.size());
    }
}
