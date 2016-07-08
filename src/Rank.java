public class Rank {
    public int[] getRankOfNumber(int[] A, int n) {
        if (A == null || A.length <= 0 || n <= 0) return null;
        int[] result = new int[n];

        result[0] = 0;

        RankNode root = new RankNode(0,A[0],null,null);

        for (int i = 1; i < n; i++){
            result[i] = root.getRank(A[i]);
            root.insert(A[i]);
        }

        return result;
    }

    private class RankNode{
        int left_count;
        int data;

        RankNode left;
        RankNode right;

        RankNode(int left_count,int data, RankNode left, RankNode right){
            this.left_count = left_count;
            this.data = data;
            this.left = left;
            this.right = right;
        }

        int getRank(int num){
            if (data == num) return left_count;
            else if (data > num){
                if (left == null) return 0;
                else return left.getRank(num);
            }else {
                int left = left_count + 1;
                if (right == null) return left;
                else{
                    return left + right.getRank(num);
                }
            }
        }

        void insert(int num){
            if (num < data){
                left_count ++;
                if (left == null) {
                    left = new RankNode(0,num,null,null);
                }else {
                    left.insert(num);
                }
            }else {
                if (right == null) {
                    right = new RankNode(0, num, null, null);
                }else {
                    right.insert(num);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7};
        int[] rankOfNumber = new Rank().getRankOfNumber(A, A.length);
        for (int i : rankOfNumber) {
            System.out.print(i + " ");
        }
    }

}