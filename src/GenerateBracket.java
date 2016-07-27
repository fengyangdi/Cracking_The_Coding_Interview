import java.util.ArrayList;
import java.util.List;

/**
 * Created by 46392_000 on 2016/7/9.
 */
public class GenerateBracket {

    public List<String> generateBracketFaster(int num){
        List<String> list = new ArrayList<>();
        if (num <= 0) return list;
        char[] str = new char[num*2];
        generateBracket(list, num, num, str, 0);

        return list;
    }

    private void generateBracket(List<String> list, int left, int right, char[] str, int i) {
        if (left < 0 || right < left) return;  //ÎŞĞ§×´Ì¬
        if (left == 0 && right ==0){
            list.add(new String(str));
            return;
        }else{
            if (left > 0){
                str[i] = '(';
                generateBracket(list,left-1,right,str,i+1);
            }
            if (right > left){
                str[i] = ')';
                generateBracket(list,left,right-1,str,i+1);
            }
        }
    }

    public List<String> generateBracket(int num){
        List<String> list = new ArrayList<>();
        if (num <= 0) return list;
        list.add("()");
        generateBracket(list, num, 1);

        return list;
    }

    private void generateBracket(List<String> list, int num, int i) {
        if (i >= num) return;

        List<String> curr = new ArrayList<>();

        for (String s : list) {
            String str = "(" + s + ")";
            if (!curr.contains(str)) curr.add(str);
        }

        for (String s : list) {
            String str = s + "()";
            if (!curr.contains(str)) curr.add(str);
            str = "()" + s;
            if (!curr.contains(str)) curr.add(str);
        }

        list.clear();
        list.addAll(curr);

        generateBracket(list, num, i + 1);
    }


    public static void main(String[] args) {
        System.out.println(new GenerateBracket().generateBracketFaster(3));
    }

}
