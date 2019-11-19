
/**
 * Write a description of class HangmanGame here.
 *
 * @author Isabel Hsieh
 * @version 2019-11-18
 */
public class HangmanGame
{
    private String secretWord;
    private String gameStatus;
    private String guessedLetters;

    /**
     * Constructor for objects of class HangmanGame
     */
    public HangmanGame(String word)
    {
        this.secretWord = word.toUpperCase();
        this.gameStatus = "";
        for (int k = 0; k < word.length(); k++)
        {
            if (Character.isLetter(word.charAt(k)))
            {
                gameStatus += "-";
            }
            else
            {
                gameStatus += word.charAt(k);
            }
        }
        this.guessedLetters = "";
    }
    
    /**
     * Returns all letters that have been tried
     * @return all letters that have been tried
     */
    public String getTried()
    {
        return guessedLetters;
    }
    
    /**
     * Returns the status of your game string
     * @return the status of your game string
     */
    public String getGuessed()
    {
        return gameStatus;
    }
    
    /**
     * Looks for character in guessed string and secret word
     * @param letter the letter inputted by the user
     * @param a if/where the guessed letter is in the string of previously guessed letters
     * @param b if/where the guessed letter is in the string of the secret word
     * @return 0 if letter was already tried; -1 if letter is not in secret word; 1 if letter is in secret word
     */
    public int tryLetter(char letter)
    {
        letter = Character.toUpperCase(letter);
        int a = guessedLetters.indexOf(letter);
        guessedLetters = guessedLetters + letter;
        int b = secretWord.indexOf(letter);
        
        if (a != -1)
        {
            return 0;
        }
        else if (b == -1)
        {
            return -1;
        }
        else
        {
            for (int i = 0; i < secretWord.length(); i++)
            {
               if (letter == secretWord.charAt(i))
               {
                   gameStatus = gameStatus.substring(0, i) + letter +  gameStatus.substring(i + 1);
               }
            }
            return 1;
        }
    }
}
