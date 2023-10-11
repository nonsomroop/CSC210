import java.util.Stack;

public class TowerOfHanoi {
    Stack<Integer> pegA;
    Stack<Integer> pegB;
    Stack<Integer> pegC;
    int amountOfDisk;
    int ithMove;

    public TowerOfHanoi (int disks) {
        pegA = new Stack<Integer>();
        pegB = new Stack<Integer>();
        pegC = new Stack<Integer>();
        amountOfDisk = disks;
        for (int i = amountOfDisk; i > 0; i--){
            pegA.push(i);
        }
    }

    public void play() {
        for (int i = amountOfDisk - 1; i >= 0; i--){
            System.out.println(pegA.elementAt(i));
        }
        move(amountOfDisk, pegA, pegC, pegB);
    }

    public void showTowerOfHanoi(){
        int maxLine;
        if (pegA.size() >= pegB.size() && pegA.size() >= pegC.size()) {
            maxLine = pegA.size() - 1;
        } else if (pegB.size() >= pegA.size() && pegB.size() >= pegC.size() ){
            maxLine = pegB.size() - 1;
        } else {
            maxLine = pegC.size() - 1;
        }
        for (int i = maxLine; i >= 0; i--){
            if (pegA.size() - 1 >= i) {
                System.out.print(pegA.elementAt(i) + "    ");
            } else {
                System.out.print("     ");
            }
            if (pegB.size() - 1 >= i){
                System.out.print(pegB.elementAt(i)+ "    ");
            } else {
                System.out.print("     ");
            }
            if (pegC.size() - 1 >= i){
                System.out.print(pegC.elementAt(i) + "    ");
            } else {
                System.out.print("      ");
            }
            System.out.println();
        }
        ithMove++;
        System.out.println("Move " + ithMove + "-------");
    }

    public void move(int n, Stack fromPeg, Stack toPeg, Stack availablePeg){
        if (n == 1){
            toPeg.push(fromPeg.pop());
            showTowerOfHanoi();
            return;
        }
        move(n-1,fromPeg, availablePeg, toPeg);
        move(1, fromPeg, toPeg, availablePeg);
        move(n-1, availablePeg, toPeg, fromPeg);
    }
}

