import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by John on 10/28/2018.
 */
public class SimpleHash {

  private Toy_DES encrypter;

  public SimpleHash(){

    encrypter = new Toy_DES("1000100101");

  }

  public int hash(List<Integer> input){

    int PrevAnswer = encrypter.encryptAndDecrypt(0, true);
    int answer = 0;

//    System.out.println();
    for(int i = 0; i < input.size(); i++){

//     System.out.print("000" + Integer.toString(input.get(i), 2) + " ");


      encrypter.setKey("000" + Integer.toString(input.get(i)+i, 2));
      encrypter.keySchedule();

      answer = encrypter.encryptAndDecrypt(PrevAnswer, true);
//      System.out.print(answer + " ");
      PrevAnswer = answer;

    }

    return answer;
  }

  public int hash(String input){

    byte[] inputAsBytes = input.getBytes();
    ArrayList<Integer> inputAsInts = new ArrayList<>();


    for(int i = 0; i < inputAsBytes.length; i++){
      inputAsInts.add(Byte.toUnsignedInt(inputAsBytes[i]));
    }


    return hash(inputAsInts);

  }

}
