#include<bits/stdc++.h>
using namespace std;


int main(){
	int N = 3, M = 2;
	//求 A[N][N] 
	//阴	阴	晴	晴	阴	雨	/ 阴	雨	晴	雨	阴	阴 / 雨	雨	晴	晴	阴	阴	阴
	int a[19] = {2, 2, 1, 1, 2 , 3, 2, 3, 1, 3, 2, 2, 3, 3, 1, 1, 2, 2, 2};
	double A[3][3]= {0};
	for(int i=0;i<18;i++){
		//cout << i << " ";
		A[ a[i]-1 ][ a[i+1] - 1 ]++;
	}
	for(int i=0;i<N;i++){
		for(int j=0;j<N;j++){
			printf("A[%d][%d] = %f / 18 ",i+1,j+1,A[i][j]);
			//A[i][j] /= 18; 
		}
		cout << endl;
	}
	cout << endl;
	//求 B[M][N] 
	//打	不	不	打	不	打 / 不	不	不	打	打	不 / 打	打	不	不	不	打	不
	int b[19] = {1, 2, 2, 1, 2, 1, 2, 2, 2, 1, 1, 2, 1, 1, 2, 2, 2, 1, 2};
	double B[2][3]= {0};
	for(int i=0;i<19;i++){
		//cout << i << " ";
		B[ b[i] - 1 ][ a[i]-1 ]++;
	}
	int fb[3] = {0};
	//int N = 3, M = 2;
	for(int i=0;i<N;i++){
		for(int j=0;j<M;j++){
			fb[i] += B[j][i];
		}
		cout << i << ": " << fb[i] << endl;
	}
	for(int i=0;i<M;i++){
		for(int j=0;j<N;j++){
			printf("B[%d][%d] = %f / %d ",i+1,j+1,B[i][j], fb[j]);
			B[i][j] /= fb[j];
			cout << B[i][j] << "!";
		}
		cout << endl;
	}
	cout << endl;
	//求 pi[N] 
	double pi[3] = {0};
	for(int i=0;i<19;i++){
		pi[a[i]-1]++;
	}
	for(int i=0;i<3;i++) pi[i]/=19, cout << pi[i] << " ";
	cout << endl;
	return 0;
}
