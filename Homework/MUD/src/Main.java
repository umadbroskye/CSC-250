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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        boolean test = false; //Set to true if you want to test
        Map<String, Room> roomMap = new HashMap<String, Room>(); //Assignment asks to store this in an ArrayList. I decided to use a HashMap instead since it is more efficient and easier to read.
        ArrayList<Exit> exitList = new ArrayList<Exit>();
        buildRoom(roomMap, exitList);
        Room theEntrance = roomMap.get("entrance");
        Player thePlayer = new Player("Mike");
        theEntrance.addPlayer(thePlayer);
        thePlayer.lookAround();
        if (test) {
            for (Room room : roomMap.values()) {
                room.display();
            }
        }
        thePlayer.play();
    }

    private static void buildRoom(Map<String, Room> roomMap, ArrayList<Exit> exitList) throws FileNotFoundException {
        FileInputStream fin = new FileInputStream("resources/map.txt");
        Scanner input = new Scanner(fin);
        String currentMode = "No Mode";
        if (input.hasNext()) {
            do {
                String line = input.nextLine();
                if (line.equals("ROOMS") || line.equals("EXIT")) {
                    currentMode = "ROOMS";
                } else if (line.equals("EXITS")) {
                    currentMode = "EXITS";
                } else if (!line.equals("")) {
                    if (currentMode.equals("ROOMS")) {
                        roomMap.put(line, new Room(line));
                    } else if (currentMode.equals("EXITS")) {
                        String[] eP = line.split(","); //This replaces parseExit. I believe that the parseExit method was created in order to teach the class how to create it manually. For me, using the split method is better than doing it manually
                        exitList.add(new Exit(roomMap.get(eP[0]), eP[1], roomMap.get(eP[2]), eP[3]));
                    }
                }
            } while (input.hasNext());
        }
    }
}
