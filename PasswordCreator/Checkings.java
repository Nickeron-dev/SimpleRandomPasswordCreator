package classes;

import java.util.Random;

public class Checkings {
  Random rand = new Random();

  // all these methods return String which is the password for different cases
  public String allOn(int length) {
    String answer = "";
    point :
    for(int i = 0; i < length; i++) {
      int character = rand.nextInt(126 - 33) + 33;
      if(character == 64) continue point;
      answer += (char)character;
    }
    return answer;
  }

  public String allOFF(int length) {
    String answer = "";
    for(int i = 0; i < length; i++) {
      int character = rand.nextInt(122 - 97) + 97;
      answer += (char)character;
    }
    return answer;
  }

  public String symbolsAndNumbersOn(int length) {
    String answer = "";
    point :
    for(int i = 0; i < length; i++) {
      int characterFirstBound = rand.nextInt(64 - 33) + 33;
      int characterSecondBound = rand.nextInt(126 - 91) + 91;
      if(characterFirstBound == 64 || characterSecondBound == 64) continue point;
      boolean choosingOneFromFirstAndSecond = rand.nextBoolean();
      if(choosingOneFromFirstAndSecond) {
        answer += (char) characterFirstBound;
      } else {
        answer += (char) characterSecondBound;
      }
    }
    return answer;
  }

  public String capitalsAndNumbersOn(int length) {
    String answer = "";
    point :
    for(int i = 0; i < length; i++) {
      int characterFirstBound = rand.nextInt(90 - 65) + 65;
      int characterSecondBound = rand.nextInt(122 - 97) + 97;
      int characterThirdBound = rand.nextInt(57 - 48) + 48;
      int choosingOneFromFirstAndSecondAndThird = rand.nextInt(3);
      if(characterFirstBound == 64 || characterSecondBound == 64 || characterThirdBound == 64) continue point;
      if(choosingOneFromFirstAndSecondAndThird == 0) {
        answer += (char) characterFirstBound;
      } else if(choosingOneFromFirstAndSecondAndThird == 1) {
        answer += (char) characterSecondBound;
      } else if(choosingOneFromFirstAndSecondAndThird == 2) {
        answer += (char) characterThirdBound;
      }
    }
    return answer;
  }

  public String capitalsAndSymbolsOn(int length){
    String answer = "";
    point :
    for(int i = 0; i < length; i++) {
      int characterFirstBound = rand.nextInt(47 - 33) + 33;
      int characterSecondBound = rand.nextInt(126 - 58) + 58;
      boolean choosingOneFromFirstAndSecond = rand.nextBoolean();
      if(characterFirstBound == 64 || characterSecondBound == 64) continue point;
      if(choosingOneFromFirstAndSecond) {
        answer += (char) characterFirstBound;
      } else {
        answer += (char) characterSecondBound;
      }
    }
    return answer;
  }

  public String numbersOn(int length) {
    String answer = "";
    for(int i = 0; i < length; i++) {
      int characterFirstBound = rand.nextInt(57 - 48) + 48;
      int characterSecondBound = rand.nextInt(122 - 97) + 97;
      boolean choosingOneFromFirstAndSecond = rand.nextBoolean();
      if(choosingOneFromFirstAndSecond) {
        answer += (char) characterFirstBound;
      } else {
        answer += (char) characterSecondBound;
      }
    }
    return answer;
  }

  public String capitalsOn(int length) {
    String answer = "";
    point :
    for(int i = 0; i < length; i++) {
      int characterFirstBound = rand.nextInt(90 - 65) + 65;
      int characterSecondBound = rand.nextInt(122 - 97) + 97;
      if(characterFirstBound == 64 || characterSecondBound == 64) continue point;
      boolean choosingOneFromFirstAndSecond = rand.nextBoolean();
      if(choosingOneFromFirstAndSecond) {
        answer += (char) characterFirstBound;
      } else {
        answer += (char) characterSecondBound;
      }
    }
    return answer;
  }

  public String symbolsOn(int length) {
    String answer = "";
    point :
    for(int i = 0; i < length; i++) {
      int characterFirstBound = rand.nextInt(47 - 33) + 33;
      int characterSecondBound = rand.nextInt(126 - 91) + 91;
      int characterThirdBound = rand.nextInt(64 - 58) + 58;
      if(characterFirstBound == 64 || characterSecondBound == 64 || characterThirdBound == 64) continue point;
      int choosingOneFromFirstAndSecondAndThird = rand.nextInt(3);
      if(choosingOneFromFirstAndSecondAndThird == 0) {
        answer += (char) characterFirstBound;
      } else if(choosingOneFromFirstAndSecondAndThird == 1) {
        answer += (char) characterSecondBound;
      } else if(choosingOneFromFirstAndSecondAndThird == 2) {
        answer += (char) characterThirdBound;
      }
    }
    return answer;
  }
}
