package test3_1.bjfu.hyc.dm;

public class Matrix {
    //向量点乘
    public static double dot(double[] x,double[] y) {
        int lengthX=x.length;
        int lengthY=y.length;
        if(lengthX!=lengthY){
            System.out.println("Cannot Dot Product!");
            return 0.0;
        }
        double answer=0.0;
        for(int i=0;i<lengthX;i++){
            answer+=x[i]*y[i];
        }
        return answer;
    }

    //矩阵和向量之积
    public static double[] mult(double[][] a,double[] x){
        int rowA=a.length;
        int columnA=a[0].length;
        int rowX=x.length;
        if(columnA!=rowX){
            System.out.println("Cannot multiply them!");
            return x;
        }
        double[] answer=new double[rowA];
        for(int i=0;i<rowA;i++){
            for(int j=0;j<columnA;j++){
                answer[i]+=a[i][j]*x[j];
            }
        }
        return answer;
    }

    //向量和矩阵之积
    public static double[] mult(double[] y,double[][] a){
        int rowA=a.length;
        int columnA=a[0].length;
        int columnY=y.length;
        if(columnY!=rowA){
            System.out.println("Cannot multiply them!");
            return y;
        }
        double[] answer=new double[rowA];
        for(int i=0;i<columnA;i++){
            for(int j=0;j<columnY;j++){
                answer[i]+=y[j]*a[j][i];
            }
        }
        return answer;
    }

    //矩阵和矩阵之积
    public static double[][] mult(double[][] a,double[][] b){
        int rowA=a.length;
        int rowB=b.length;
        int columnA=a[0].length;
        int columnB=b[0].length;
        if(columnA!=rowB){
            System.out.println("Cannot multiply them!");
            return a;
        }
        double[][] c=new double[rowA][columnB];
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < columnB; j++) {
                for (int k = 0; k < columnA; k++)
                    c[i][j] += a[i][k] * b[k][j];
            }
        }
        return c;
    }
    
  //矩阵和矩阵点乘
    public static double[][] dotmult(double[][] a,double[][] b){
        int rowA=a.length;
        int rowB=b.length;
        int columnA=a[0].length;
        int columnB=b[0].length;
        if(rowA!=rowB || columnA!=columnB){
            System.out.println("Cannot dot multiply them!");
            return a;
        }
        double[][] c=new double[rowA][columnB];
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < columnB; j++) {
            	c[i][j] += a[i][j] * b[i][j];
            }
        }
        return c;
    }

    //转置矩阵
    public static double[][] transpose(double[][] a){
        int row=a.length;
        int column=a[0].length;
        /*if(row!=column){
            System.out.println("Cannot transpose it!");
            return a;
        }*/
        double[][] b=new double[column][row];
        for(int i=0;i<column;i++){
            for(int j=0;j<row;j++){
                b[i][j]=a[j][i];
            }
        }
        return b;
    }

    //打印向量
    public static void printVector(double[] a){
        for(double i:a){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    //打印矩阵
    public static void printMatrix(double[][] a){
        for(double[] row:a){
            for(double i:row)
                System.out.print(i+" ");
            System.out.println();
        }
    }
}