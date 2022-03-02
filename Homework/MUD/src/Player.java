/*
 * Copyright (c) 2022 https://github.com/umadbroskye/
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Inhabitant {

    public Player(String name) {
        super(name);
    }

    public void play() {
        this.lookAround();
        Scanner input = new Scanner(System.in);
        String line;
        while (true) {
            System.out.print("What would you like to do? \n> ");
            line = input.nextLine();
            if (line.equals("look")) {
                this.lookAround();
            } else if (line.equals("throw")) {
                System.out.print("Who do you want to throw? ");
                String who = input.nextLine();
                System.out.print("Where do you want to throw " + who + "? ");
                String where = input.nextLine();
                System.out.println("About to throw...." + who + " through the exit to the: " + where + "!!!");
                ArrayList<Monster> theMonsters = currentRoom.getMonsterList();
                Monster theMonster = null;
                for (Monster m: theMonsters) {
                    if (m.getName().equals(who)){
                        theMonster = m;
                    }
                }
                currentRoom.throwExit(where, theMonster);
            } else if (line.equals("exit")) {
                System.out.println("Goodbye!!!");
                return;
            } else {
                if (currentRoom.hasExit(line)) {
                    currentRoom.takeExit(line);

                } else {
                    System.out.println("Exit Not Found!!!");
                    this.lookAround();
                }
            }
        }
    }


    public void lookAround() {
        this.currentRoom.display();
    }

}
