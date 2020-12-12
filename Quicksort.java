package Quicksort;

//Schnell
// Rekursiv
// Sortieralgorithmus


/** 
*Author: @himiko
*
*/

public class Quicksort {

    public int teilung(int liste[], final int erstes, final int letztes){
        /**
         * Median (Element in der Mitte) des Arrays
         *  Setzt sich zusammen aus dem Index des ersten Elements und
         *  index  des letzten Elements, geteilt durch 2
         *  Angenommen Indizes ergebnen 9, dann ist das Pivo-element
         *  nicht 4,5 sondern es wird abgerundet und es befindet sich am Index 4
        */
        int pivo = liste[(erstes + letztes) / 2];

        /**
         * Zeigt auf das letzte Element der Liste.
         * Wird auch ggfs. später dekrementiert.
         * */
        int positionLinks = erstes;
        int positionRechts = letztes;

        while( positionLinks <=  positionRechts){

            /**
             * Solange die Elemente auf der Linken Seite
             * kleiner als das Pivo-Element sind, erhöre die Position
             */

            while(liste[positionLinks] < pivo){
                positionLinks++;

            }
            /**
             * Solange die Elemente auf der rechten Seite
             * größer als das Pivot-Elment sind, verringere die Position
             */
            while(liste[positionRechts] > pivo){
                positionRechts--;
            }

            /**
             * Tausche Elemente:
             * 1. tmp hält den Wert von der linken seite fest.
             * 2.Dann wird der Wert an der Position der linken Seite
             *   auf den Wert der recheten Seite geändert.
             *   3. Dann wird der Wert an der Positiob der rechten Seite
             *   auf den Wert tmp (Wert der linken Seite) geändert.
             *   4.Auf der linken Seite um  eins weitergehen (positionLinks++)
             *   5. Auf der Rechten seite um eins runtergehen (positionRechts--)
             */
            if(positionLinks <= positionRechts){
                int tmp = liste[positionLinks]; // wir merken uns die 8 zb
                liste[positionLinks] = liste[positionRechts];
                liste[positionRechts] = tmp;
                positionLinks++;
                positionRechts--;
            }
        }
        return positionLinks;
    }

    public void quickSort(int liste[], final int erstes, final int letztes){

        //7 2 4 8 6 1 3 5 9

        //5 2 4 3 1 6 8 7 9
        //0 1 2 3 4 5 6 7 8
        /**
         * Aufteiluing des Arrays in die zwei Seiten
         * Linke Seite kleiner als Pivot - rechte Seite größer als Pivot
         */
        int index = teilung(liste, erstes, letztes);

        /**
         * repräsentiert die linke Seite vom Pivot-Element.
         */
        if(erstes < index - 1){
            quickSort(liste, erstes, index-1);
        }

        /**
         * repräsentiert die Rechte Seite vom Pivot-Element.
         */

        if(index < letztes){
            quickSort(liste, index, letztes);
        }
    }
}
