import java.util.Map;

/**
 * Created by John on 10/28/2018.
 */
public class Main {

  public static void main(String[] args) {

    String testInput = "“More efficient attacks are possible by employing cryptanalysis to specific hash functions. When a\n" +
      "collision attack is discovered and is found to be faster than a birthday attack, a hash function is often\n" +
      "denounced as \"broken\". The NIST hash function competition was largely induced by published collision\n" +
      "attacks against two very commonly used hash functions, MD5 and SHA-1. The collision attacks against\n" +
      "MD5 have improved so much that, as of 2007, it takes just a few seconds on a regular computer. Hash\n" +
      "collisions created this way are usually constant length and largely unstructured, so cannot directly be\n" +
      "applied to attack widespread document formats or protocols.”";

    String testOutput = "“Least efficient attacks are possible by employing cryptanalysis to specific hash functions. When a\n" +
      "collision attack is discovered and is found to be slower than a birthday attack, a hash function is often\n" +
      "denounced as \"perfect\". The NASA hash function competition was largely induced by published collision\n" +
      "attacks against two very commonly used hash functions, MARIO and SONIC-1. The collision attacks against\n" +
      "MARIO have improved so much that, as of 2157, it takes just a few years on a regular computer. Hash\n" +
      "collisions created this way are usually exponential length and largely structured, so can directly be\n" +
      "applied to attack widespread document formats and protocols.”";

    int sizeOfHashBit = 8;

    BirthdayAttacker bdA = new BirthdayAttacker(testInput, testOutput, sizeOfHashBit);

    System.out.println( bdA.attack( (int) Math.pow(2, 8) )) ;





    System.out.println("\n\n\n");

    Miller_Rabin_Algo primeTester = new Miller_Rabin_Algo(31531);
    boolean maybePrime = primeTester.runMultiplePrimeTest(10);

    Pollard_rho_algo factorFinder = new Pollard_rho_algo(31531);
    System.out.println("The factor found is " + factorFinder.factorize(2, 2) + ".\n");


    Miller_Rabin_Algo primeTester1 = new Miller_Rabin_Algo(520482);
    primeTester1.runMultiplePrimeTest(10);

    Pollard_rho_algo factorFinder1 = new Pollard_rho_algo(520482);
    System.out.println("The factor found is " + factorFinder1.factorize(2, 2) + ".\n");


    Miller_Rabin_Algo primeTester2 = new Miller_Rabin_Algo(485827);
    primeTester2.runMultiplePrimeTest(10);

    Pollard_rho_algo factorFinder2 = new Pollard_rho_algo(485827);
    System.out.println("The factor found is " + factorFinder2.factorize(2, 2) + ".\n");


    Miller_Rabin_Algo primeTester3 = new Miller_Rabin_Algo(15485863);
    primeTester3.runMultiplePrimeTest(10);

    Pollard_rho_algo factorFinder3 = new Pollard_rho_algo(15485863);
    System.out.println("The factor found is " + factorFinder3.factorize(2, 2) + ".\n");

  }

}
