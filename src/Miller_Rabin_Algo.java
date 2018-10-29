import java.util.Random;

/**
 * Created by John on 10/29/2018.
 */
public class Miller_Rabin_Algo {

  private int k;
  private int q;
  private int n;
  private boolean foundValidNumbers;

  public Miller_Rabin_Algo(int n){

    this.foundValidNumbers = findNumbers(n);

  }

  public boolean findNumbers(int n){

    this.n = n;
    boolean foundNums = false;
    for(int i = 1; Math.pow(2, i) < (n - 1); i++){

      int potentialQ =  (n-1)/((int) Math.pow(2, i));
      int potentialQRemainder = (n-1)%((int) Math.pow(2, i));

      if(potentialQRemainder == 0 && potentialQ % 2 != 0){

        this.q = potentialQ;
        this.k = i;
        foundNums = true;

      }

    }
    if(foundNums) {
      System.out.println("Setting up the numbers (" + this.n + "-1) = (2^" + this.k + ")*" + this.q);
    }else{
      System.out.println("Found no valid numbers. Potentially Prime Number is probably even.");
    }

    return foundNums;

  }

  public boolean runIsMaybePrimeTest(int a){
    if(!foundValidNumbers){
      return false;
    }
//    System.out.println("Running test on base " + a);

//    int num1 = ((int) Math.pow(a, this.q));
//    int num1Mod = num1 % this.n;
    if(powerWithModulus(a, this.q, this.n) == 1){
      return true;
    }

    for(int j = 0; j <= this.k-1; j++){

      int innerExpNum = (int)Math.pow(2, j) * this.q;
//      int outerExpNum = (int)Math.pow(a, innerExpNum);
//      int outerExpNumMod = outerExpNum % this.n;
      if(powerWithModulus(a, innerExpNum, this.n) == this.n - 1){

        return true;

      }

    }

    return false;

  }

  public boolean runIsMaybePrimeTestRandomA(){

    Random rand = new Random();
    int a = Math.abs((rand.nextInt()) % (n-3)) + 2; //choose a random number from 2 to n-2, inclusive
    return runIsMaybePrimeTest(a);

  }

  public boolean runMultiplePrimeTest(int howManyRuns){

    for(int i = 0; i < howManyRuns; i++){

      if(!runIsMaybePrimeTestRandomA()){
        System.out.println(this.n + " is composite.");
        return false;
      }

    }

    System.out.println(this.n + " is probably prime.");
    return true;

  }

  public int powerWithModulus(int base, int exponent, int modulus){

    if(exponent < 0){
      System.out.println("powerWithModulus only works with positive exponents,");
    }
    long answer = 1;
    for(int i = 0; i < exponent; i++){

      answer = answer * base % modulus;

    }
    return (int)answer;
  }

}
