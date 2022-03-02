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

public class Room {
    private final ArrayList<Exit> theExits;
    private final String name;
    private Player currentPlayer;
    private ArrayList<Monster> theMonsters;

    public Room(String name) {
        this.name = name;
        this.theExits = new ArrayList<Exit>();
        this.theMonsters = new ArrayList<Monster>();
        this.currentPlayer = null;
    }

    public void display() {
        System.out.println("Room: " + this.name);
        System.out.print("Also here: ");
        StringBuilder alsoHereOutput = new StringBuilder();
        if (this.currentPlayer != null) {
            alsoHereOutput = new StringBuilder(this.currentPlayer.getName());
        }

        for (Monster monster : theMonsters) {
            alsoHereOutput.append(", ").append(monster.getName());
        }

        System.out.println(alsoHereOutput);
        System.out.print("Obvious Exits: ");
        StringBuilder exitDirections = new StringBuilder();
        for (Exit exit : this.theExits) {
            exitDirections.append(exit.getDirectionStringLeadingAwayFromRoom(this)).append(" ");
        }
        System.out.println(exitDirections);
    }

    public Player getPlayer() {
        return this.currentPlayer;
    }

    public ArrayList<Monster> getMonsterList() {
        return theMonsters;
    }


    public void addPlayer(Player p) {
        this.currentPlayer = p;
        p.setRoom(this);
    }

    public void addMonster(Monster m) {
        this.theMonsters.add(m);
        m.setRoom(this);
    }

    public void removePlayer(Player p) {
        this.currentPlayer = null;
    }

    public void removeMonster(Monster m) {
        this.theMonsters.remove(m);
    }

    public void addExit(Exit e) {
        this.theExits.add(e);
    }

    public boolean hasExit(String direction) {
        for (Exit exit : this.theExits) {
            if (exit.getDirectionStringLeadingAwayFromRoom(this).equals(direction))
                return true;
        }
        return false;
    }

    public void takeExit(String direction) {
        for (Exit exit : this.theExits) {
            if (exit.getDirectionStringLeadingAwayFromRoom(this).equals(direction)) {
                Room r = exit.getRoomInADirection((direction));
                this.currentPlayer.setRoom(r);
                r.addPlayer(this.currentPlayer);
                this.removePlayer(this.currentPlayer);
            }
        }
    }


    public void throwExit(String direction, Monster theMonster) {
        for (Exit exit : this.theExits) {
            if (exit.getDirectionStringLeadingAwayFromRoom(this).equals(direction)) {
                Room r = exit.getRoomInADirection((direction));
                r.addMonster(theMonster);
                this.removeMonster(theMonster);
            }
        }
    }
}
