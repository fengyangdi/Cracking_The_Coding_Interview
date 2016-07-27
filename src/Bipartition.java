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
public class Bipartition {
    public double[] getBipartition(Point[] A, Point[] B) {
        //获得中心点
        DPoint midA = getMiddlePoint(A);
        DPoint midB = getMiddlePoint(B);

        //计算斜率
        return CalculateGradient(midA,midB);
    }

    private double[] CalculateGradient(DPoint midA, DPoint midB) {
        //斜率不存在
        if (midA.x == midB.x) return null;
        //找出在前面的点
        if (midA.x > midB.x){
            //交换次序
            exchange(midA,midB);
        }
        //斜率
        double k = (midB.y - midA.y) / (midB.x - midA.x);
        //截距
        double d = midA.y - k * (midA.x - 0);
        return new double[]{k,d};
    }

    private void exchange(DPoint midA, DPoint midB) {
        double t;
        //x
        t = midA.x;
        midA.x = midB.x;
        midB.x = t;
        //y
        t = midA.y;
        midA.y = midB.y;
        midB.y = t;
    }

    private DPoint getMiddlePoint(Point[] a) {
        int x1,x2 = 0,y1,y2 = 0;
        boolean isFindX2 = false;
        boolean isFindY2 = false;
        x1 = a[0].x;
        y1 = a[0].y;
        for (int i = 1; i < a.length; i++){
            if (a[i].x != x1 && !isFindX2) {
                x2 =a[i].x;
                isFindX2 = true;
            }
            if (a[i].y != y1 && !isFindY2) {
                y2 =a[i].y;
                isFindY2 = true;
            }
            if (isFindX2 && isFindY2) break;
        }
        //计算出中心
        double x = (x1 + x2) / 2.0;
        double y = (y1 + y2) / 2.0;
        return  new DPoint(x, y);
    }

    private class DPoint {
        double x;
        double y;

        public  DPoint(){
            this.x = 0.0;
            this.y = 0.0;
        }

        public DPoint(double _x, double _y){
            this.x = _x;
            this.y = _y;
        }
    }
}