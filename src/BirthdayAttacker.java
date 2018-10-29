import java.util.*;

public class BirthdayAttacker {

    private static SimpleHash hasher;
    private String inputMessage;
    private String outputMessage;
    private TreeMap inputHashes;

    public BirthdayAttacker(String inputMessage, String outputMessage, int hashSize){
        this.inputMessage = inputMessage;
        this.outputMessage = outputMessage;
        this.hasher = new SimpleHash();
        this.inputHashes = generateHashes((int) Math.pow(2,(hashSize/2)));

    }

    public TreeMap<Integer, String> generateHashes(int quantity){

        String input = inputMessage;

        TreeMap<Integer, String> answer = new TreeMap<>();
        int numberLeft = quantity;
        String currentInput = input;

        while(numberLeft > answer.size()){

            ArrayList<Integer> spaces = findSpaces(currentInput);

            String finalVariant = "";
            for(int i = 0; i < spaces.size(); i++){

 //               System.out.println(spaces.get(i));
                String variant = currentInput.substring(0, spaces.get(i)) + " \b" + currentInput.substring(spaces.get(i));
                int hash = hasher.hash(variant);
//                System.out.println(hash + " " + variant);
                answer.put(hash, variant);
                finalVariant = variant;

            }

//            System.out.println(finalVariant);
            currentInput = finalVariant;

        }

        return answer;

    }

    public ArrayList<Integer> findSpaces(String input){

        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0; i < input.length(); i++){

            if(input.charAt(i) == ' '){
                answer.add(i);
            }

        }

        return answer;
    }

    public Map attack(int maximumAttempts){

        String input = outputMessage;
        int answerHash = 0;
        Map<Integer, String> answer = new TreeMap<>();
        int numberLeft = 0;
        String currentInput = input;

        while(answer.size() < 1 && numberLeft < maximumAttempts){

            ArrayList<Integer> spaces = findSpaces(currentInput);

            String finalVariant = "";
            for(int i = 0; i < spaces.size() && answer.size()<1; i++){

//                System.out.println(spaces.get(i));
                String variant = currentInput.substring(0, spaces.get(i)) + " \b" + currentInput.substring(spaces.get(i));
                int hash = hasher.hash(variant);
//                System.out.println(hash + " " + variant);
                if(inputHashes.containsKey(hash)) {
                    answer.put(hash, variant);
                    answerHash = hash;
                }
                finalVariant = variant;
                numberLeft++;

            }
//            System.out.println(finalVariant);
            currentInput = finalVariant;


        }

        System.out.println("The attack took " + numberLeft + " attempts out of a potential " + maximumAttempts + ".");
        System.out.println(inputHashes.get(answerHash));
        return answer;

    }

}
