//Chase Walker
//Church
//moves like a king, captures by jumping over, converts pieces it captures
import java.util.ArrayList;

//you will need to implement two functions in this file.
public class Church extends Piece {
  protected boolean color;

    public Church(boolean isWhite, String img_file) {
      super(isWhite,img_file);
    }
    
    


    
  
    
    
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
      ArrayList<Square> control = new ArrayList();
      int row = start.getRow(); 
      int col = start.getCol();
      for(int i = -1; i <= 1; i++){
        for(int x = -1; x <= 1; x++){
          if(col + x >= 0 && col + x <= 7 && row + i >= 0 && row + i <= 7){
            control.add (board[row + i ][col + x]);
          }
        }
      }
     return control;
    }
    

    //TO BE IMPLEMENTED!
    //implement the move function here
    //it's up to you how the piece moves, but at the very least the rules should be logical and it should never move off the board!
    //returns an arraylist of squares which are legal to move to
    //please note that your piece must have some sort of logic. Just being able to move to every square on the board is not
    //going to score any points.
    //church: moves like king, but captures by jumping over the captured piece.
    public ArrayList<Square> getLegalMoves(Board b, Square start){
      ArrayList<Square> moves = new ArrayList();
      Square [][] board = b.getSquareArray();
      int row = start.getRow(); 
      int col = start.getCol();
      for(int i = -1; i <= 1; i++){
        for(int x = -1; x <= 1; x++){
          if(col + x >= 0 && col + x <= 7 && row + i >= 0 && row + i <= 7 && !board[row + i][col + x].isOccupied() ){
            moves.add (board[row + i ][col + x]);
          }
          else if(col + x + x   >= 0 && col + x + x  <= 7 && row + i +i   >= 0 && row + i + i  <= 7 && board[row + i][col + x].getOccupyingPiece().getColor()!= color && !board[row +i +i][col + x + x].isOccupied()){
            moves.add (board[row + i + i][col + x + x]);
          }
        }
      }


      


    	return moves;
    }
}