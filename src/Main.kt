fun main() {
    val board = Array(3) { CharArray(3) { ' ' } }
    var currentPlayer = 'X'

    while (true) {
        printBoard(board)
        println("Player $currentPlayer's turn")
        val (row, col) = getPlayerMove(board)
        board[row][col] = currentPlayer

        if (checkWin(board, currentPlayer)) {
            printBoard(board)
            println("Player $currentPlayer wins!")
            break
        } else if (isBoardFull(board)) {
            printBoard(board)
            println("It's a draw!")
            break
        }

        currentPlayer = if (currentPlayer == 'X') 'O' else 'X'
    }
}

fun printBoard(board: Array<CharArray>) {
    for (row in board) {
        for (cell in row) {
            print(" $cell ")
        }
        println()
    }
}

fun getPlayerMove(board: Array<CharArray>): Pair<Int, Int> {
    var row: Int
    var col: Int

    while (true) {
        println("Enter row (0, 1, or 2): ")
        row = readLine()!!.toInt()
        println("Enter col (0, 1, or 2): ")
        col = readLine()!!.toInt()

        if (row in 0..2 && col in 0..2 && board[row][col] == ' ') {
            break
        } else {
            println("Invalid move. Try again.")
        }
    }

    return Pair(row, col)
}

fun checkWin(board: Array<CharArray>, player: Char): Boolean {
    // Check rows and columns
    for (i in 0..2) {
        if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
            (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
            return true
        }
    }

    // Check diagonals
    if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
        (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
        return true
    }

    return false
}

fun isBoardFull(board: Array<CharArray>): Boolean {
    for (row in board) {
        for (cell in row) {
            if (cell == ' ') {
                return false
            }
        }
    }
    return true
}
