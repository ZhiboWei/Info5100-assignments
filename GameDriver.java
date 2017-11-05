package project2;

import java.util.Random;

class GroupOfCards {
    private Card[] cards;
    private int currentSize;
    public GroupOfCards(int num) {
        super();
        cards = new Card[num];
        currentSize = 0;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public Card getCard(int i) {
        return cards[i];
    }

    public void addCard(Card card) {
        if(cards.length == currentSize){
            System.out.println("The cards are full");
            return;
        }
        cards[currentSize] = card;
        currentSize = currentSize + 1;
    }

    public Card removeCard(int index) {
        if(index >= currentSize){
            System.out.println("wrong index");
            return null;
        }
        Card temp = cards[index];
        currentSize = currentSize - 1;
        cards[index] = null;
        if(currentSize >0) {
            for (int i = index; i < currentSize; i++) {
                cards[i] = cards[i + 1];
            }
            cards[currentSize] = null;
        }
        return temp;
    }

    public void display() {
        System.out.println("current size: "+ currentSize);
        for(int i = 0; i < currentSize; i++){
            cards[i].display();
        }
    }
}

class Card {
    private int num;
    private int suit;

    public Card(int num, int suit) {
        super();
        this.num = num;
        this.suit = suit;
    }

    public int getNum() {
        return num;
    }

    public int getSuit() {
        return suit;
    }

    public void display() {
        String suits = new String();
        switch(num){
            case 11:
                System.out.print("J");
                break;
            case 12:
                System.out.print("Q");
                break;
            case 13:
                System.out.print("K");
                break;
            case 14:
                System.out.print("A");
                break;
            default:
                System.out.print(num);
        }
        switch(suit){
            case 0:
                suits = " of clubs";
                break;
            case 1:
                suits = " of diamonds";
                break;
            case 2:
                suits = " of hearts";
                break;
            case 3:
                suits = " of spades";
                break;
        }
        System.out.println(suits);
        }
    }

class Deck extends GroupOfCards{
    public final int TOTAL_CARDS = 52;
    public Deck(){
        super(52);
        for(int i = 2; i <= 14; i++){
            for(int j = 0; j <= 3; j++){
                this.addCard(new Card(i,j));
            }
        }
    }

    public void shuffle() {
        for (int unshuffled = this.getCurrentSize() ; unshuffled > 0; unshuffled--) {
            Random r = new Random();
            Card card = this.removeCard(r.nextInt(unshuffled));
            this.addCard(card);
        }
    }

    public Card dealCard() {
        return this.removeCard(0);
    }
}

class Trick extends GroupOfCards{
    private int winner;
    private Card winningCard;
    private boolean hearts;
    private boolean queen;

    public Trick(int players){
        super(2*players - 1);
        hearts = false;
        queen = false;
        winningCard = null;
    }

    public int getWinner(){
        return winner;
    }
    public Card getWinningCard(){
        return winningCard;
    }
    public boolean getHearts(){
        return hearts;
    }
    public boolean getQueen(){
        return queen;
    }

    private boolean isWinner(Card c){
      if(winningCard !=null){
          if(c.getSuit() != winningCard.getSuit() || c.getNum() < winningCard.getNum()){
              return false;
          }
      }
      return true;
    }

    public void update(int playerNum, Card card){
       this.addCard(card);
       if(this.isWinner(card)){
           winner = playerNum;
           winningCard = card;
           if(card.getSuit() == 2){
               hearts = true;
           }
           if(card.getSuit() == 3 && card.getNum() == 12){
               queen = true;
           }
       }

    }

}

class Hand extends GroupOfCards{
    public final int NUM;
    private int shortest;

    public Hand(int playerNum, int numberOfcards) {
        super(numberOfcards);
        NUM = playerNum;
    }

    public void sort(){
       for(int unsorted = this.getCurrentSize(); unsorted > 0; unsorted--){
           int maxIndex = unsorted - 1;
           for(int i = 0;i < unsorted; i++){
               int currentValue = this.getCard(i).getSuit() * 13 + this.getCard(i).getNum();
               int maxValue = this.getCard(maxIndex).getSuit() * 13 +this.getCard(maxIndex).getNum();
               if(currentValue > maxValue){
                   maxIndex = i;
               }
               Card max = this.removeCard(maxIndex);
               this.addCard(max);
           }
       }
    }

    public void setShortest(){
        shortest = 0;
        if(this.findCount(1) <= this.findCount(0)){
            shortest = 1;
        }
        if(this.find(12,3) == -1 && this.find(13,3) == -1 && this.find(14,3) == -1){
            if(this.findCount(3) <= Math.min(this.findCount(0),this.findCount(1)) ){
                shortest = 3;
            }
        }
    }
    public int getShortest(){
        return shortest;
    }
    public Card playACard(Game game, Trick trick){
        int index = 0;
        if((trick.getCurrentSize() == 0) && (this.findCount(shortest) != 0)
                && (index = this.findHighest(shortest)) >= 0 ){
            ;
        }
        else if((trick.getCurrentSize() == 0) && (this.findCount(shortest) == 0)
                && (index = this.findLowest(game)) >= 0){
            ;
        }
        else if((trick.getCurrentSize() == game.PLAYERS - 1) && !trick.getHearts() && !trick.getQueen()
                && (index = findLastHigh(trick.getWinningCard().getSuit())) >= 0){
            ;
        }
        else if((index = findHighestBelow(trick.getWinningCard())) >= 0){
            ;
        }
        else if((index = findMiddleHigh(game,trick.getWinningCard().getSuit())) >= 0){
            ;
        }
        else if((index = find(12,3)) >= 0){
            ; // Queen of spades
        }
        else if((index = find(13,3)) >= 0){
            ; // King  of spades
        }
        else if((index = find(14,3)) >= 0){
            ; // Ace of spades
        }
        else if((index = findHighest(2)) >= 0){
            ; // hearts
        }
        else{
            index = findHighest();
        }
        Card  card = this.removeCard(index);
        trick.update(NUM,card);
        game.updateHeartsAndQueen(card);
        return card;
    }
    public int findLowest(int suit){
        int lowest = -1;
        int lowestNum = 15;
        for(int i = 0; i < getCurrentSize(); i++){
            if(getCard(i).getSuit() == suit && getCard(i).getNum() <= lowestNum){
                lowest = i;
                lowestNum = this.getCard(i).getNum();
            }
        }
        return lowest;
    }
    private int findCount(int suit){
        int count = 0;
        for(int i = 0; i < this.getCurrentSize(); i++){
            if(this.getCard(i).getSuit() == suit){
                count++;
            }
        }
        return count;
    }
    private int find(int num,int suit){
        for(int i = 0; i < this.getCurrentSize(); i++){
            if(this.getCard(i).getNum() == num && this.getCard(i).getSuit() == suit){
                return i;
            }
        }
        return -1;
    }
    private int findHighest(int suit){
       int highest = -1;
       int highestNum = 1;
       for(int i = 0; i < getCurrentSize(); i++){
           if(getCard(i).getSuit() == suit && getCard(i).getNum() > highestNum){
               highest = i;
               highestNum = getCard(i).getNum();

           }
       }
       return highest;
    }
    private int findLowest(Game game){
        int lowest = -1;
        int lowestNum = 15;
        if(game.getHearts() == false && findCount(2) == getCurrentSize()){
            return lowest;
        }
        if(game.getHearts() == true){
            for(int i = 0; i < getCurrentSize(); i++){
                if(getCard(i).getNum() < lowestNum){
                    lowestNum = getCard(i).getNum();
                    lowest = i;
                }
            }
        }
        else{
            for(int i = 0; i < getCurrentSize(); i++){
                if(getCard(i).getNum() < lowestNum && getCard(i).getSuit() != 2){
                    lowestNum = getCard(i).getNum();
                    lowest = i;
                }
            }
        }
        return lowest;
    }
    private int findLastHigh(int suit){
       if(suit != 3){
           return findHighest(suit);
       }
       else{
           int highest = 1;
           int highestNum = 1;
           for(int i = 0; i < this.getCurrentSize(); i++){
               if(getCard(i).getSuit() == suit){
                   if(getCard(i).getNum() > highestNum && getCard(i).getNum() < 12){
                       highest = i;
                       highestNum = getCard(i).getNum();

                   }
               }
           }
           return highest;
       }
    }
    private int findHighestBelow(Card winningCard){
      for(int i = 0; i < getCurrentSize(); i++){
          if(getCard(i).getSuit() == winningCard.getSuit()){
              if(getCard(i).getNum() < winningCard.getNum()){
                  if(i != getCurrentSize()-1){
                      if(getCard(i+1).getSuit() != winningCard.getSuit()){
                          break;
                      }
                  }
                  return i;
              }
          }
      }
      return -1;
    }
    private int findMiddleHigh(Game game,int suit){
        if(suit == 3 && game.getqueenOfSpades() == false){
            for(int i = 0; i < getCurrentSize(); i++){
                if(getCard(i).getNum() <= 11){
                    return i;
                }
            }
        }
        return findHighest(suit);
    }
    private int findHighest(){
       int index = 0;
       int max = 1;
       for(int i = 0; i < getCurrentSize(); i++){
           if(getCard(i).getNum() > max){
               max = getCard(i).getNum();
               index = i;
           }
       }
       return index;
    }
}

class Game{

    public final int PLAYERS;
    private Deck deck;
    private Hand[] players;
    private Trick[] tricks;
    private int numberOfTricks;
    private boolean hearts = false;
    private boolean queenOfSpades = false;

    public Game(int numberOfPlayers){
        super();
        PLAYERS = numberOfPlayers;
        players = new Hand[numberOfPlayers];
        for(int i=0;i<players.length;i++){
            players[i] = new Hand(i,52/PLAYERS);
        }
        tricks = new Trick[52/PLAYERS];
        numberOfTricks = 0;
    }
    public int getNumberOfTricks(){
        return numberOfTricks;
    }
    public boolean getHearts(){return hearts;}
    public boolean getqueenOfSpades(){return queenOfSpades;}
    public void palyAGame(){

        deck =new Deck();

        int cardsLeft = 52 % PLAYERS;
        deck.shuffle();
        for(int i = 0; i < tricks.length; i++){
            for(int j = 0; j < PLAYERS; j++){
                players[j].addCard(deck.dealCard());
            }
        }
        int playNum = 0;
        int tempNum = 15;
        for(int i = 0; i < PLAYERS; i++){
            players[i].setShortest();
            players[i].sort();
            System.out.println("player "+i+" shortest="+players[i].getShortest());
            players[i].display();
            if(players[i].getCard(tricks.length-1).getSuit() == 0
                    && players[i].getCard(tricks.length-1).getNum() < tempNum ){
                tempNum =  players[i].getCard(tricks.length-1).getNum();
                playNum = i;
            }
        }

        for(int i = 0; i < tricks.length; i++){
            tricks[i] = new Trick(PLAYERS);
            numberOfTricks++;
            Card card;
            if(i==0){
                int index = players[playNum].getCurrentSize()-1;
                card = players[playNum].removeCard(index);
                tricks[i].update(playNum,card);
            }else{
                card = players[playNum].playACard(this,tricks[i]);
            }
            System.out.println("player" + playNum + "  ");
            card.display();
            for(int j = 1; j < PLAYERS; j++){
                playNum = (playNum + j)% PLAYERS;
                card = players[playNum].playACard(this,tricks[i]);
                System.out.println("player" + playNum + "  ");
                card.display();
            }
            playNum = tricks[i].getWinner();
            if(i == 0){
                for(int j = 0; j < cardsLeft; j++){
                    Card left = deck.dealCard();
                    System.out.println("undelt card ");
                    left.display();
                }
            }
        }
        for(int i = 0; i < PLAYERS; i++){
            System.out.println("player" + i +" score = " + computePoints(i));
        }
    }
    public void updateHeartsAndQueen(Card card){
        if(card.getSuit()==2 && hearts==false){
            System.out.println("Hearts is now broken");
            hearts = true;
        }
        if(card.getSuit()==3 && card.getNum()==12){
            queenOfSpades = true;
        }
    }
    private int computePoints(int playerNum){
       int point = 0;
       for(int i = 0; i < numberOfTricks; i++){
           if(tricks[i].getWinner() == playerNum){
               for(int j = 0; j < PLAYERS; j++){
                   if(tricks[i].getCard(j).getSuit() == 2){
                       point++;
                   }
                   if(tricks[i].getCard(j).getSuit() == 3 && tricks[i].getCard(j).getNum() == 12){
                       point = point + 13;
                   }
               }
           }
       }
       return point;
    }


}

public class GameDriver {
    public static void main(String[] args){
        Game game = new Game(4);
        game.palyAGame();
    }
}
