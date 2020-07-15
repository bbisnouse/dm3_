package test3_1.bjfu.hyc.dm;

import java.io.BufferedReader;
import java.util.*;

public class Test {
	
	final static int N = 3;//����״̬����
	final static int M = 2;//�۲�״̬����
	static int len;//��������
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String status = "������";
		String name = "��";
		int a[] = {2, 2, 1, 1, 2, 3, 2, 3, 1, 3, 2, 2, 3, 3, 1, 1, 2, 2, 2};//����״̬����
		int b[] = {1, 2, 2, 1, 2, 1, 2, 2, 2, 1, 1, 2, 1, 1, 2, 2, 2, 1, 2};//�۲�״̬����
		double A[][]= new double[N][N];//Ĭ�ϳ�ʼ��Ϊ0
		for(int i=0;i<18;i++){
			A[ a[i]-1 ][ a[i+1] - 1 ]++;
		}
		for(int i=0;i<N;i++){
			int sum=0;
			for(int j=0;j<N;j++) {
				sum += A[i][j];
			}
			for(int j=0;j<N;j++){
				//System.out.printf("A[%d][%d] = %f / %d ",i+1,j+1,A[i][j],sum);
				A[i][j] /= sum; 
			}
			//System.out.println();
		}
		//System.out.println();
		double B[][]= new double[M][N];
		for(int i=0;i<19;i++){
			//cout << i << " ";
			B[ b[i] - 1 ][ a[i]-1 ]++;
		}
		int fb[] = new int[N];
		//int N = 3, M = 2;
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				fb[i] += B[j][i];
			}
		}
		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				//System.out.printf("B[%d][%d] = %f / %d ",i+1,j+1,B[i][j], fb[j]);
				B[i][j] /= fb[j];
			}
			//System.out.println();
		}
		//System.out.println();
		//�� Pi[N] 
		double Pi[] = new double[N];
		for(int i=0;i<19;i++){
			Pi[a[i]-1]++;
		}
		for(int i=0;i<N;i++) {
			Pi[i]/=19;
			//System.out.print(Pi[i]+" ");
		}
		//ͨ��ģ�͵������㣬�õ�״̬��ʼ����ֵ������״̬ת�Ʒ���״̬���۲�ֵ֮��ĸ��ʾ���
		System.out.println("ͨ��ģ�͵������㣬�õ�״̬��ʼ����ֵ������");
		for(int i=0;i<N;i++)System.out.print(Pi[i]+" ");
		System.out.println();
		System.out.println("״̬ת�Ʒ���A��");
		Matrix.printMatrix(A);
		System.out.println("״̬���۲�ֵ֮��ĸ��ʾ���");
		Matrix.printMatrix(Matrix.transpose(B));
		//���롰��-������
		while(true) {
			System.out.println("����һ������-���������磺�����򲻡��� ");
			Scanner sc = new Scanner(System.in); 
			String str = sc.nextLine();
			if(str.equals("quit")) {
				break;
			}
			//System.out.println(str);
			//�������봮Ϊ����
			len = str.length();
			//String name = "��";
			int O[] = new int[len];
			int ok=0;
			for(int i=0;i<str.length();i++) {
				//System.out.print(str.charAt(i)+" ");
				ok=0;
				for(int j=0; j<name.length(); j++) {
					if(str.charAt(i) == name.charAt(j)) {
						ok=1;
						O[i] = j+1;
						//System.out.println("O = "+(j+1));
						break;
					}
				}
				if(ok==0) {
					System.out.println("�������������ַ���");
					break;
				}
			}
			if(ok==0)continue;
			//for(int i=0;i<O.length;i++)System.out.print(O[i]+" ");
			double Alpha[][] = new double[N][len];
			double Beta[][] = new double[N][len];
			double Lambda[][] = new double[N][len];
			double Delta[][] = new double[N][len];
			
			double Al[][] = new double[N][1];
			for(int i=0;i<N;i++) {
				Alpha[i][0] = B[O[0]-1][i]*Pi[i];
				Al[i][0] = Alpha[i][0];
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<len;j++)
					Delta[i][j]=Alpha[i][j];
			}
			for(int i=1;i<len;i++) {
				double Bo[][] = new double[1][N];
				for(int j=0;j<N;j++) {
					Bo[0][j] = B[O[i]-1][j];
				}
				Al = Matrix.dotmult((Matrix.mult(Matrix.transpose(A), Al)), Matrix.transpose(Bo));
				for(int j=0;j<N;j++) {
					Alpha[j][i] = Al[j][0];
				}
			}
			//Matrix.printMatrix(Alpha);
			double Q1_1=0;
			for(int i=0;i<N;i++) {
				Q1_1 += Alpha[i][len-1];
			}
			//�ô����ֵĸ���
			System.out.println("�ô����ֵĸ��ʣ�");
			System.out.println("��ǰ����Q1_1="+Q1_1);
			//Beta(:,LEN)=ones(N,1);
			double Be[][] = new double[N][1];
			
			
			for(int i=0;i<N;i++) {
				Beta[i][len-1]=1;
				Be[i][0]=1;
			}
			for(int i=len-1;i>0;i--) {
				double Bo[][] = new double[1][N];
				for(int j=0;j<N;j++) {
					Bo[0][j] = B[O[i]-1][j];
				}
				double AA[][] = new double[N][N];
				for(int x=0;x<N;x++) {
					for(int y=0;y<N;y++) {
						AA[x][y] = A[x][y] * Bo[0][y];
					}
				}
				Be = Matrix.mult(AA, Be);
				for(int j=0;j<N;j++) {
					Beta[j][i-1]=Be[j][0];
				}
			}
			//System.out.println("Beta");
			//Matrix.printMatrix(Beta);
			double Q1_2=0;
			for(int i=0;i<N;i++) {
				Q1_2 += Pi[i]*B[0][i]*Beta[i][0];
				//System.out.println(Pi[i]+" - "+B[0][i]+" - "+Beta[i][0]);
			}
			System.out.println("������Q1_2="+Q1_2);
			int Q2[] = new int[len];
			
			//double De[][] = new double[N][len];
			for(int i=1;i<len;i++) {
				double Dt[][] = new double[N][1];
				for(int j=0;j<N;j++) {
					Dt[j][0] = Delta[j][i-1];
				}
				double AA[][] = new double[1][N];
				for(int x=0;x<N;x++) {
					for(int y=0;y<N;y++) {
						if(A[x][y] * Dt[x][0] > AA[0][y]) {
							AA[0][y] = A[x][y] * Dt[x][0];
							Lambda[y][i] = x+1;
						}
						//AA[0][y] = Math.max(AA[0][y] , A[x][y] * Dt[x][0]);
					}
				}
				for(int j=0;j<N;j++) {
					//System.out.println(i+j+":"+AA[0][j]+" + "+B[O[i]-1][j]);
					Delta[j][i] = AA[0][j]*B[O[i]-1][j];
				}
			}
			
			//Matrix.printMatrix(Lambda);
			double num=0;
			for(int i=0;i<N;i++) {
				if(Delta[i][len-1] > num) {
					num = Delta[i][len-1];
					Q2[len-1] = i+1;
				}
			}
			//System.out.println(Q2[len-1]);
			for(int i=len-1;i>0;i--) {
				Q2[i-1] = (int)Lambda[Q2[i]-1][i];
				//System.out.println(Q2[i-1]);
			}
			//�۲�ֵ�����״̬����
			System.out.println("�۲�ֵ�����״̬���У�");
			for(int i=0;i<len;i++)System.out.print(status.charAt(Q2[i]-1)+" ");
			System.out.println();
		}

	}

}
