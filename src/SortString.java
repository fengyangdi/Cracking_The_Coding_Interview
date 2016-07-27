import java.util.*;

/**
 * ��ÿ���ַ��������ڲ����򣬵õ���λ�ʵ�һ����׼������Ϊhash��key��
 * value��������洢��key��Ӧ�ĸ���λ�ʣ��������ٶ��ֳ���x��
 * ��x����б������ҳ�ÿ����С���ַ������д洢�����ArrayList�е��ַ����ٴ����򼴿�
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