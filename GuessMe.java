  /*  Remember to import java.util.Random, otherwise you will get errors!  */
import java.util.Random;

public class GuessMe{

  /*  Here you will be creating your instance variables. When making instance variables, we think
   *  about what information we need to store between method calls. The info we will need to store
   *  is: 
   *
   *     1) the word the user is trying to guess. We will need a String instance variable called 'word' for that.
   *     2) the number of guesses the user has left. We will need an int called 'remainingGuesses' for that.
   *     3) we need to know if the word has been found. We will need a boolean called 'wordFound' for that.
   *     4) we need a random number generator. We will need a Random object called 'rand' for that.
   *
   *  Be sure to use the suggested variable names exactly, or you won't pass many of the tests.
   */ 
   
   //Instance variables here:
   String word;
   boolean wordFound;
   int remainingGuesses;
   Random rand;

  /*  This is the first of two constructors. This one is used in the main method. We initialize each
   *  of our instance variables here. The player will start off with 10 guesses, the word obviously
   *  has not been found yet. You will need to initialize 'rand' before you can generate the word, and
   *  you will want to use the generateWord() helper method at the bottom of this file to initialize 
   *  'word' that way you don't have to write the same code a ton of times. 
   */
   public GuessMe(){
      remainingGuesses = 10;
      wordFound = false;
      word = generateWord();
      rand = new Random();      
   }
   
  /*  This is our second constructor. There is only one real difference: in this one we take in an
   *  int which will act as the seed for our Random object. This is used for the tests.
   */
   /*public GuessMe(int seed){
      remainingGuesses = 10;
      wordFound = false;
      word = generateWord();
      rand = new Random(seed);
   }*/
   
  /*  This is our play method. It takes in a String called 'str' and compares it to the word the
   *  player is trying to guess 'word'. It returns an int representing the number of letters which
   *  are in the exact same place in both words. For example, if the word to find were "ABCD" play
   *  would return:
   *  
   *     1 on "AAAA" 
   *     2 on "ABAA" 
   *     2 on "AAAD" 
   *     4 on "ABCD" 
   *     4 on "abcd" 
   *
   *  NOTE these values are ONLY for the example word "ABCD" and will not be the same for your random
   *  word. Looping and using charAt() on the strings would be very useful here. Remember we do not
   *  care about upper/lower case here, so be sure to account for that.
   *
   *  We also want to decrement the user's remaining guesses, and in the event they guess the word
   *  we will also update wordFound to true before returning 4.
   */
   public int play(String str){
      int correctLetter = 0;
      str = str.toUpperCase();
      for (int i = 0; i < 4; i++) {
         if (str.charAt(i) == word.charAt(i)) {
            correctLetter += 1;
         }
      }
      if (correctLetter == 4) {
         wordFound = true;
      }
      remainingGuesses -= 1;
               
      return correctLetter;
   }
   
  /*  isOver simply returns true if the game is over, which is either when the player runs
   *  out of guesses or when they have found the correct word. It returns false otherwise.
   */
   public boolean isOver(){
      if (wordFound == true || remainingGuesses == 0) {
         return true;
      }
      else {
         return false;
      }
   }
   
  /*  isWin returns true if the player has correctly guessed the word and false otherwise.
   */
   public boolean isWin(){
      if (wordFound == true) {
         return true;
      }
      else {
         return false;
      }
   }
   
  /*  getRemainingGuesses returns the number of remaining guesses the player has.
   */
   public int getRemainingGuesses(){
      return remainingGuesses;
   }
   
  /*  reset returns nothing but resets the game. 'remainingGuesses' and 'wordFound' go back to 
   *  their default values and a new word is generated with generateWord().
   */
   public void reset(){
      remainingGuesses = 10;
      wordFound = false;
      word = generateWord();
   }
   
  /*  getWord simply returns the word the user is attempting to guess. It is not tested,
   *  and is only used in the main method. 
   */
   public String getWord(){
      return word;
   }
   
   /**********************************/
   /*         Helper Methods         */
   /**********************************/
   
  /*  A helper method is a private method which cannot be accessed outside of the file. Its
   *  sole purpose is to be used in other constructors/methods and simply 'helps' them do their
   *  job better. In our case, we need to generate a random word occassionally, so we make
   *  a helper method so that we don't have to write the same code repeatedly.
   *
   *  We will go about writing this by using our Random object. We will call nextInt(4) on our
   *  Random object a total of four times to generate four different ints. Specifying 4 in the
   *  method call forces it to generate an int between 0 and 4, including 0 but not including 4.
   *  The ints correspond to a letter to add to our word as such:
   *
   *     0: 'A'
   *     1: 'B'
   *     2: 'C'
   *     3: 'D'
   *
   *  We can build our String by starting with local variable which is an empty String ("") which we can 
   *  call retStr. Using String concatination (+=), we can add letters to our String based on the int 
   *  generated. Once we have done this 4 times, we can return the String. We do not use any instance 
   *  variables in this method. It may be helpful to use a loop here.
   */
   private String generateWord(){
      String newWord = "";
      for (int i = 0; i < 4; i++) {
         String retStr = "";
         int num = rand.nextInt(4);
         if (num == 0) {
            retStr = "A";
         }
         else if (num == 1) {
            retStr = "B";
         }
         else if (num == 2) {
            retStr = "C";
         }
         else if (num == 3) {
            retStr = "D";
         }
         newWord += retStr;     
      }  
      return newWord;
   }
   
}