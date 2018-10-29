/**
 * Created by John on 10/29/2018.
 */
public class Pollard_rho_algo {

  private int n;

  public Pollard_rho_algo(int n){
    this.n = n;
  }

  public void setN(int n){
    this.n = n;
  }

  public long gFunction1(long x){
    return ((x*x) + 1) % this.n;
  }


  public int gcd(int a, int b){
    if(b == 0){return a;}
    return gcd(b, a % b);
  }

  public long factorize(int x, int y){

    long xVal = x;
    long yVal = y;
    long dVal = 1;

    while(dVal == 1){

      xVal = gFunction1(xVal);
      yVal = gFunction1(gFunction1(yVal));
      dVal = gcd(Math.abs((int)(xVal-yVal)), this.n);

    }

    if(dVal == this.n){
      System.out.println("Failed to factorize " + this.n);
      return 0;
    }else{
      return dVal;
    }

  }

}
