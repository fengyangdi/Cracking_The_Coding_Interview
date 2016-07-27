import java.util.*;

/*
public class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point() {
        this.x = 0;
        this.y = 0;
    }
}*/
public class DenseLine {
    public double[] getLine(Point[] p, int n) {
        //String 表示"k,d"，k为斜率，d为截距；若为平行于y轴的直线，则为y
        //Integer 表示线的条数
        Map<String,Integer> lines = new HashMap<String, Integer>();
        int max = 0; //最多的线条数
        String maxKD = ""; //最多条数的直线的斜率和截距
        double[] kAndD;
        for (int i = 0; i < n - 1; i++){
            for (int j = i + 1; j < n; j++){
                //计算斜率和截距
                kAndD = CalculateGradient(p[i], p[j]);
                String str = "";
                if (kAndD ==  null) {
                    //平行于y轴
                    str = "y";
                }else{
                    str = kAndD[0]+","+kAndD[1];
                }
                int now = 0;
                if (lines.containsKey(str)){
                    now = lines.get(str)+1;
                }else{
                    now = 1;
                }
                lines.put(str, now);
                if (now > max){
                    max = now;
                    maxKD = str;
                }
            }
        }
        String[] values = maxKD.split(",");
        double k = Double.parseDouble(values[0]);
        double d = Double.parseDouble(values[1]);
        return new double[]{k,d};
    }

    private double[] CalculateGradient(Point A, Point B) {
        //斜率不存在
        if (A.x == B.x) return null;
        //找出在前面的点
        if (A.x > B.x){
            //交换次序
            exchange(A,B);
        }
        //斜率
        double k = (B.y - A.y) / (double)(B.x - A.x);
        //截距
        double d = A.y - k * (A.x - 0);
        return new double[]{k,d};
    }

    private void exchange(Point A, Point B) {
        int t;
        //x
        t = A.x;
        A.x = B.x;
        B.x = t;
        //y
        t = A.y;
        A.y = B.y;
        B.y = t;
    }
}