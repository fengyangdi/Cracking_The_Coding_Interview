import java.util.*;

public class Subset {
    public ArrayList<ArrayList<Integer>> getSubsets(int[] A, int n) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (A == null || A.length <= 0 || n <= 0) return lists;

        getSubsets(A, lists, 0);

        return lists;
    }

    private void getSubsets(int[] a, ArrayList<ArrayList<Integer>> lists, int i) {
        if (i >= a.length) return;
        ArrayList<ArrayList<Integer>> currAdd = new ArrayList<>();
        for (ArrayList<Integer> arrayList : lists) {
            ArrayList<Integer> list1 = new ArrayList<Integer>(arrayList);
            list1.add(a[i]);
            Collections.sort(list1, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 > o2 ? -1 : (o1 == o2 ? 0 : 1);
                }
            });
            currAdd.add(list1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(a[i]);
        currAdd.add(list);
        lists.addAll(0, currAdd);
        getSubsets(a, lists, i + 1);
    }

    public static void main(String[] args) {
        int[] a = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(new Subset().getSubsets(a, a.length));
    }
}