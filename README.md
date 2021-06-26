# bingo
USING LIST IN LIST

FIND & ADD RANDOM ELEMENT FROM A SET

The Bingo class in the ...bingo package supports playing number bingo. An object corresponds to a playing card with a square of randomly arranged numbers.
Internally, a bingo card consists of a list of lists of integers, i.e. each line is a list of numbers and the card is a list of such lines.
The board already supports a conversion to a string, the map is filled with values from the passed set Set<Integer> values randomly.

If you pass a number to an object of the Bingo class with the add method, then this number should be deleted from the field. If a row, column or one of the two diagonals is completely crossed out, a BingoException is thrown. The method add has two tasks: Here, first a called number on the game card should be searched for and, if necessary, crossed out ( cross ). Then it is checked whether a row, line or diagonal is crossed out (checkForBingo()).

 I have implemented the method private void cross(Integer drawn), which searches the field (in the instance variable card as a list of lists), and sets the corresponding entry in the array crossed to true to cross out a field.
