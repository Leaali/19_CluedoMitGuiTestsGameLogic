package ch.bbw.pr.cluedo.logic;

import ch.bbw.pr.cluedo.model.Crime;
import ch.bbw.pr.cluedo.model.DataService;

import java.util.Random;

/**
 * GameLogic
 * @author Lea
 * @version 05.11.2022
 *
 * @author Peter Rutschmann
 * @version 25.10.2022
 */
public class GameLogic {

   /**
    * Setup randomly the secret of the game.
    * @param service Contains the list for actors, weapons and scenes.
    * @param secret  Randomly generate the secret for actor, weapon and scene.
    */
   public void setupNewGame(DataService service, Crime secret){
      Random random =  new Random();
      secret.setActor(random.nextInt(service.getPersons().size()));
      secret.setWeapon(random.nextInt(service.getWeapons().size()));
      secret.setScene(random.nextInt(service.getRooms().size()));
      System.out.println("GameLogic.setupNewGame " + secret);

      // Random = new Random....
      // testen ob es es eine Zahl im gewünscheten bereich ist (bsp. waffen höchsten 8)
      //To be done
   }

   /**
    * Evaluates the suggestion to find the solution of the game.
    * @param suggestion The suggestion from the player
    * @param secret The game secret.
    * @param numberOfSuggestion Current number of suggestion
    * @param maxNumberOfSuggestions Max number of possible suggestions
    * @return true if games ends, false if another suggestion is allowed
    */
   public boolean evaluateSuggestion(Crime suggestion, Crime secret, int numberOfSuggestion, int maxNumberOfSuggestions){
      String soutPrefix = "GameLogic.evaluateSuggestion ";
      //im Controller wird später bei numberOfSuggestion 1 += gemacht
      /**
       * Umstädliche Variante von Lea
       *          if(suggestion.getActor() == secret.getActor() && suggestion.getWappon() == secret.getWappon() && suggestion.getScene() == secret.getScene()){
       *             suggestion.getHistory().add("WIN, you found the correct answer| actor: " + secret.getActor() + "weapon: " + secret.getWeapon() + "scene: " + secret.getScene());
       *             return true; //Korrekte antworten 3
       *          }
       *          if(suggestion.getActor() == secret.getActor()){
       *             if(suggestion.getScene() == secret.getScene() || suggestion.getWappon() == secret.getWappon()){
       *                suggestion.getHistory().add("Correct: 2 Try again");
       *                return false; //Korrekte antworten "2"
       *             }else{
       *                suggestion.getHistory().add("Correct: 1 Try again");
       *                return false; //Korrekte antworten "1"
       *             }
       *          }
       *          if(suggestion.getScene() == secret.getScene()){
       *             if(suggestion.getWappon() == secret.getWappon()){
       *                suggestion.getHistory().add("Correct: 2 Try again");
       *                return false; //korrekte antworten 2
       *             }else{
       *                suggestion.getHistory().add("Correct: 1 Try again");
       *                return false; //korrekte antworten 1
       *             }
       *          }
       *          if(suggestion.getWappon() == secret.getWappon()){
       *             suggestion.getHistory().add("Correct: 1 Try again");
       *             return false; //korrekte antworten 1
       *          }
       *          if (numberOfSuggestion >= maxNumberOfSuggestions){
       *          suggestion.getHistory().add("Lose, reach may suggestion");
       *              return true; //max anzahl von versuchen erreicht
       *          }
       */
      //Schönere Variante von Herr Rutschmann:
      System.out.println(soutPrefix + suggestion);
      System.out.println(soutPrefix + secret);

      int correctSuggestion= 0;
      if(suggestion.getActor() == secret.getActor()) correctSuggestion++;
      if(suggestion.getWeapon() == secret.getWeapon()) correctSuggestion++;
      if(suggestion.getScene() == secret.getScene()) correctSuggestion++;
      if(correctSuggestion == 3) {
         suggestion.getHistory().add("WIN, you found the correct answer| actor: " + secret.getActor() + "weapon: " + secret.getWeapon() + "scene: " + secret.getScene());
         System.out.println(soutPrefix + "return win");
         return true;
      }else if (numberOfSuggestion >= maxNumberOfSuggestions){
         suggestion.getHistory().add("Failed, no more suggestions available");
         System.out.println(soutPrefix + "no suggestion left");
         return true;
      }
      suggestion.getHistory().add("Correct: " + correctSuggestion + " Try again");
      System.out.println(soutPrefix + "try again");
      System.out.println(soutPrefix + suggestion);
      return false;
   }
}
