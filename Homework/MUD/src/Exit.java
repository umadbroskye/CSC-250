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

public class Exit {
    private final Room destination1;
    private final Room destination2;
    private final String directionLeadingToDest1;
    private final String directionLeadingToDest2;

    public Exit(Room destination1, String directionLeadingToDest1, Room destination2, String directionLeadingToDest2) {
        this.destination1 = destination1;
        this.destination2 = destination2;
        this.directionLeadingToDest1 = directionLeadingToDest1;
        this.directionLeadingToDest2 = directionLeadingToDest2;
    }

    public String getDirectionStringLeadingAwayFromRoom(Room r) {
        return this.destination1 == r ? this.directionLeadingToDest2 : this.directionLeadingToDest1;
    }
}
