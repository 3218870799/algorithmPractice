package com.xqc.function;

public class LineSieve {
	
	public static int maxn = 1000;
	/**
	 * 素数筛：在O(1)的复杂度筛出1~N所有的素数
	 * @param n
	 * f(x) x为素数时f(x) = true
	 *      否则f(x) = false
	 */
	private static void primeSieve(int n) {
		// TODO Auto-generated method stub
		boolean[] vis = new boolean[maxn];
		int[] prime = new int[maxn];
		int cnt=0;
		for(int i=2;i<maxn;i++){
			//如果这个数没有被任何数标记过，则这个数是素数
			//将该数放入prime中
			if(!vis[i]) prime[cnt++]=i;
			//筛i的倍数一定不是素数
			//for(int j=2*i;j<maxn;j+=i)vis[j]=true
			//筛i的素数倍，因为非素数倍一定也会被其他的筛
			for(int j=0;j<cnt&&i*prime[j]<maxn;j++){
				//把其倍数标记为true
				vis[i*prime[j]]=true;
				//其最小素因子不是了，不再筛了，因为他一定会被别的筛
			    if(i%prime[j]==0)break;
			}
			
		}
		for (int j : prime) {
			System.out.println(prime[j]);
			
		}
	}
	
	
	/**
	 * 欧拉函数：提供1到N中与N互质的数
	 */
	private static void eulerEqua() {
		// TODO Auto-generated method stub
		int[] phi = new int[maxn];
		
		boolean[] vis = new boolean[maxn];
		int[] prime = new int[maxn];
		int cnt=0;
		
		for(int i=2;i<=maxn;i++){
			if(!vis[i]){
				prime[cnt++]=i;
				phi[i]=i-1;
			}
			for(int j=0;j<cnt&&i*prime[j]<=maxn;j++){
				vis[i*prime[j]]=true;
				if(i%prime[j]==0){
					phi[i*prime[j]]=phi[i]*prime[j];
					break;
				}else{
					
				}
			}
		}
		
		
	}
	
	/**
	 * 莫比乌斯函数
	 * 素因子当中有一个数的指数大于1则f(x)=0,否则f(x)=(-1)^n其中有n个素因子
	 * 唯一分解定理
	 * x=p1^k1*p2^k2……*pn^kn
	 */
	public static void main(String[] args) {
		int n =10;
		primeSieve(n);
		eulerEqua();
	}

	/**
	 * 狄利克雷卷积
	 * id f(x) =x
	 * I  f(x) =1
	 * e  f(x) = x==1 ?1:0  莫比乌斯反演
	 */




}
