package gan.homeworks.Collection.PhoneBook;

import java.util.*;

public class PhoneBook {
    private final HashMap<String, ArrayList<String>> phoneBookMap;

    public PhoneBook(){
        phoneBookMap = new HashMap<>();
    }

    public void add(String name, String phone){
        if (phoneBookMap.containsKey(name)){//Проверяем существует ли ключ
            phoneBookMap.get(name).add(phone);
        }else{
            phoneBookMap.put(name, new ArrayList<>(Arrays.asList(phone)));
        }
    }

    public String get(String name){
        if (phoneBookMap.get(name) != null){
            return String.valueOf(phoneBookMap.get(name));
        }else{
            return "В справочнике не существует такой фамилии";
        }

    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "phoneBookMap=" + phoneBookMap +
                '}';
    }

}
