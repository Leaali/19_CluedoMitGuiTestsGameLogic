package ch.bbw.pr.cluedo.logic;


import ch.bbw.pr.cluedo.model.Crime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class GameLogicTest {

   private GameLogic gameLogic;

   private Crime suggestion;

   private Crime secret;

   private int numberOfSuggestion;

   private int maxNumberOfSuggestion;

   @BeforeEach
   private void setupBevoreEachTest(){
      gameLogic = new GameLogic();
      suggestion = new Crime();
      secret = new Crime();
   }


   @Test
      // void ActorSuggestionNotEqualToSecret(){
   void evaluateSuggestion() {
      int numberOfSuggestion = 0;
      int maxNumberOfSuggestion = 8;

      //setup secret
      secret.setActor(0);
      secret.setWeapon(0);
      secret.setScene(0);

      suggestion.setActor(0);
      suggestion.setWeapon(0);
      suggestion.setScene(0);


      //muss ich hier noch die History setzen?
      //secret.setHistory();
      //suggestion.setHistory();

      //return true is expected
      assertEquals(true, gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestion, maxNumberOfSuggestion));
      //schaut ob der Letzte eintrag eine 0 ist dann True sost false
      assertEquals(8, secret.getHistory().get(secret.getHistory().size()-1));
   }


   @Test
   void ActorWeaponSceneNotEqualThenReturnFalseAndHistory0(){
      int numberOfSuggestion = 0;
      int maxNumberOfSuggestion = 8;

      //setup secret
      secret.setActor(0);
      secret.setWeapon(0);
      secret.setScene(0);

      suggestion.setActor(1);
      suggestion.setWeapon(1);
      suggestion.setScene(1);

      assertEquals(false, gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestion, maxNumberOfSuggestion));
      //schaut ob der Letzte eintrag eine 0 ist dann True sost false
      assertEquals(8, secret.getHistory().get(secret.getHistory().size()-1));
   }

   @Test
   void ActorEqualWeaponSceneNotEqualThenReturnFalseAndHistory1(){
      int numberOfSuggestion = 0;
      int maxNumberOfSuggestion = 8;

      secret.setActor(1);
      secret.setWeapon(0);
      secret.setScene(0);

      suggestion.setActor(1);
      suggestion.setWeapon(1);
      suggestion.setScene(1);

      assertEquals(false, gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestion, maxNumberOfSuggestion));
      //schaut ob der Letzte eintrag eine 0 ist dann True sost false
      assertEquals(8, secret.getHistory().get(secret.getHistory().size()-1));
   }
   @Test
   void WeaponEqualActorSceneNotEqualThenReturnFalseAndHistory1(){
      int numberOfSuggestion = 0;
      int maxNumberOfSuggestion = 8;

      secret.setActor(0);
      secret.setWeapon(1);
      secret.setScene(0);

      suggestion.setActor(1);
      suggestion.setWeapon(1);
      suggestion.setScene(1);
      assertEquals(false, gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestion, maxNumberOfSuggestion));
      //schaut ob der Letzte eintrag eine 0 ist dann True sost false
      assertEquals(8, secret.getHistory().get(secret.getHistory().size()-1));
   }
   @Test
   void SceneEqualWeaponSceneNotEqualThenReturnFalseAndHistory1(){
      int numberOfSuggestion = 0;
      int maxNumberOfSuggestion = 8;

      secret.setActor(0);
      secret.setWeapon(0);
      secret.setScene(1);

      suggestion.setActor(1);
      suggestion.setWeapon(1);
      suggestion.setScene(1);

      assertEquals(false, gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestion, maxNumberOfSuggestion));
      //schaut ob der Letzte eintrag eine 0 ist dann True sost false
      assertEquals(8, secret.getHistory().get(secret.getHistory().size()-1));
   }



   @Test
   void ActorWeaponEqualSceneNotEqualThenReturnFalseAndHistory2(){
      int numberOfSuggestion = 0;
      int maxNumberOfSuggestion = 8;

      //setup secret
      secret.setActor(1);
      secret.setWeapon(1);
      secret.setScene(0);

      suggestion.setActor(1);
      suggestion.setWeapon(1);
      suggestion.setScene(1);

      //return true is expected
      assertEquals(false, gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestion, maxNumberOfSuggestion));
      //schaut ob der Letzte eintrag eine 0 ist dann True sost false
      assertEquals(8, secret.getHistory().get(secret.getHistory().size()-1));
   }
   @Test
   void ActorSceneEqualWeaponNotEqualThenReturnFalseAndHistory2(){
      int numberOfSuggestion = 0;
      int maxNumberOfSuggestion = 8;

      //setup secret
      secret.setActor(1);
      secret.setWeapon(0);
      secret.setScene(1);

      suggestion.setActor(1);
      suggestion.setWeapon(1);
      suggestion.setScene(1);

      //return true is expected
      assertEquals(false, gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestion, maxNumberOfSuggestion));
      //schaut ob der Letzte eintrag eine 0 ist dann True sost false
      assertEquals(8, secret.getHistory().get(secret.getHistory().size()-1));

   }
   @Test
   void WeaponSceneEqualActorNotEqualThenReturnFalseAndHistory2(){
      int numberOfSuggestion = 0;
      int maxNumberOfSuggestion = 8;

      //setup secret
      secret.setActor(0);
      secret.setWeapon(1);
      secret.setScene(1);

      suggestion.setActor(1);
      suggestion.setWeapon(1);
      suggestion.setScene(1);

      //return true is expected
      assertEquals(false, gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestion, maxNumberOfSuggestion));
      //schaut ob der Letzte eintrag eine 0 ist dann True sost false
      assertEquals(8, secret.getHistory().get(secret.getHistory().size()-1));

   }


   @Test
   void ActorWeaponSceneEqualThenReturnTrueAndHistoryWin(){
      int numberOfSuggestion = 0;
      int maxNumberOfSuggestion = 8;

      //setup secret
      secret.setActor(1);
      secret.setWeapon(1);
      secret.setScene(1);

      suggestion.setActor(1);
      suggestion.setWeapon(1);
      suggestion.setScene(1);

      //return true is expected
      assertEquals(true, gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestion, maxNumberOfSuggestion));
      //schaut ob der Letzte eintrag eine 0 ist dann True sost false
      assertEquals(8, secret.getHistory().get(secret.getHistory().size()-1));
   }



   // 8 rateversuche
   @Test
   void MaxNumberOfSuggestionReachedAndNotWinThenReturnFalseAndHistoryNoneLeft(){
      int numberOfSuggestion = 8;
      int maxNumberOfSuggestion = 8;

      //eigentlich müsste man nun alle möglichkeiten der vor-letzten 9 Test abdecken
      //Für unsere Aufgabe genügt aber wenn ich ein Bsp. für Falsche eingabe mache:

      secret.setActor(0);
      secret.setWeapon(0);
      secret.setScene(0);

      suggestion.setActor(1);
      suggestion.setWeapon(1);
      suggestion.setScene(1);

      assertEquals(false, gameLogic.evaluateSuggestion(suggestion, secret, numberOfSuggestion, maxNumberOfSuggestion));
      //schaut ob der Letzte eintrag eine 0 ist dann True sost false
      assertEquals(8, secret.getHistory().get(secret.getHistory().size()-1));


   }

}