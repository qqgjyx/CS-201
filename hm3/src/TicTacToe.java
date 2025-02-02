public class TicTacToe
{
  public static final int X = 1, O = -1;
  public static final int EMPTY = 0;
  private int board[][] = new int[3][3];
  private int player;

  public TicTacToe() { clearBoard(); }


  // Complete the method so that it resets all cells to be empty
  // and set ‘X’ as the first player
  public void clearBoard()
  {
    for (int i=0; i<3; i++){
      for (int j=0; j<3; j++){
        board[i][j]=EMPTY;
      }
    }
    player = X;
  }

  // Puts an X or O mark at position i,j.
  /** Complete the method so that it prints the relevant
   * message when the player tries to put a mark outside the board or an occupied
   * position.
   */
  public void putMark(int i, int j)
  {
    boolean isOutsideBoard = i<0||i>=3||j<0||j>=3;
    boolean isOccupiedPosition = board[i][j] != EMPTY;
    try {
      if (isOutsideBoard){throw new IllegalArgumentException("isOutsideBoard");}
      if (isOccupiedPosition){throw new IllegalArgumentException("isOccupiedPosition");}
    } catch (IllegalArgumentException e1) {
      System.out.println("Exception thrown: " + e1);
      return;
    }
    board[i][j] = player;       // place the mark for the current player
    player = - player;          // switch players (uses fact that O = - X)
  }

  // Checks whether the board configuration is a win for the given player.
  public boolean isWin(int mark)
  {
    return ((board[0][0] + board[0][1] + board[0][2] == mark*3)      // row 0
            || (board[1][0] + board[1][1] + board[1][2] == mark*3)   // row 1
            || (board[2][0] + board[2][1] + board[2][2] == mark*3)   // row 2
            || (board[0][0] + board[1][0] + board[2][0] == mark*3)   // column 0
            || (board[0][1] + board[1][1] + board[2][1] == mark*3)   // column 1
            || (board[0][2] + board[1][2] + board[2][2] == mark*3)   // column 2
            || (board[0][0] + board[1][1] + board[2][2] == mark*3)   // diagonal
            || (board[2][0] + board[1][1] + board[0][2] == mark*3)); // rev diag
  }

  // Returns the winning player's code, or 0 to indicate a tie (or unfinished game).
  public int winner()
  {
    if (isWin(X))
      return(X);
    else if (isWin(O))
      return(O);
    else
      return(0);
  }

  // Complete the method so that it returns a string representing/showing the current board
  // Hint: you may use the class StringBuilder to fulfil the task
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    for (int i=0; i<3; i++) {
      for (int j=0; j<3; j++) {
        if (board[i][j] == X) {sb.append("X");}
        else if (board[i][j] == O) {sb.append("O");}
        else {sb.append(" ");}
        if (j<2) {sb.append("|");}
      }
      if (i<2) {sb.append("\n-----\n");}
    }
    return sb.toString();
  }


  public static void main(String[] args)
  {
    TicTacToe game = new TicTacToe();

    /* X moves: */                    /* O moves: */
    game.putMark(1,1);          game.putMark(0,2);
    game.putMark(2,2);          game.putMark(0,0);
    game.putMark(0,1);          game.putMark(2,1);
    game.putMark(1,2);          game.putMark(1,0);
    game.putMark(2,0);

    System.out.println(game);
    int winningPlayer = game.winner();
    String[] outcome = {"O wins", "Tie", "X wins"};  // rely on ordering
    System.out.println(outcome[1 + winningPlayer]);
  }
}

