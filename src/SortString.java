import java.util.*;

/**
 * 对每个字符串进行内部排序，得到变位词的一个标准排序作为hash的key，
 * value采用链表存储该key对应的各变位词，遍历完后假定分成了x组
 * 对x组进行遍历，找出每组最小的字符串进行存储，最后将ArrayList中的字符串再次排序即可
 *
 */
public class SortString {
    public ArrayList<String> sortStrings(String[] str, int n) {
        ArrayList<String> reList = new ArrayList<>();
        if (str == null || str.length <= 0 || n <= 0) return reList;
        HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
        for (String s : str) {
            String key = sortChars(s);
            if (map.containsKey(key)){
                LinkedList<String> list = map.get(key);
                list.add(s);
            }else {
                LinkedList<String> list = new LinkedList<String>();
                list.add(s);
                map.put(key,list);
            }
        }
        for (String s : map.keySet()) {
            LinkedList<String> list = map.get(s);
            Collections.sort(list);
            reList.add(list.getFirst());
        }
        Collections.sort(reList);
        return reList;
    }

    private String sortChars(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}