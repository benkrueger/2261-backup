public class Board {
    char[][] state;
    int rows;
    int cols;
    final int linelen = 4;
    public Board(int r, int c){
        rows = r;
        cols = c;
        state = new char[r][c];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j< cols; j++) {
                state[i][j] = ' ';
            }
        }
    }
    public void dropAtIndex(int i,boolean ry){ //true for red, false for yellow
        int row = 0;
        while(row <rows && state[row][i] != ' ')row++;
        try{
            state[row][i] = (ry)?'R':'Y';
        }catch(ArrayIndexOutOfBoundsException e){
            throw e;
        }
    }
    
    public boolean winState(boolean turn) {
        char turnToken = (turn)?'R':'Y';

        for(int i = 0; i < rows;i++){
            for(int j = 0; j < cols;j++){
                if(state[i][j] == turnToken){
                    if(checkLine(i,j,turnToken,'V') || checkLine(i, j, turnToken, 'H') ||
                       checkLine(i, j,turnToken, 'R') || checkLine(i, j,turnToken,'L'))
                        return true;
                }
            }
        }
        return false;
    }

    public String toString(){
        String outstr = " 0 1 2 3 4 5 6\n";
        for(int i = rows-1; i >= 0; i--){
            for(int j = 0;j < cols;j++){
                outstr += "|"+state[i][j];
            }
            outstr += "|\n";
        }
        return outstr;
    }
    private boolean checkLine(int i,int j,char tt,char direct){
        int n = 0;
        while(i < rows && j < cols && j >= 0 && n < linelen)
        {
            if(tt != state[i][j]) return false;
            n++;
            switch(direct){
                case 'V':
                    i++;
                    break;
                case 'H':
                    j++;
                    break;
                case 'R':
                    i++;
                    j++;
                    break;
                case 'L':
                    i++;
                    j--;
                    break;
            }
            
            if(n == linelen) return true;
        }
        return false;
    }

}
