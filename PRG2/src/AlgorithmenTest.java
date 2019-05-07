import java.util.Arrays;

public class AlgorithmenTest {

   public static void main(String args[]) {
      
   }

   static int binarySearch(int iArr[], int s) {
      int low = 0;
      int high = iArr.length - 1; // untere-obere Grenzen
      return binarySearch(iArr, low, high, s);
   }

   static int binarySearch(int iArr[], int low, int high, int s) {
      if (low < 0 || low > high || high >= iArr.length)
         return -1;
      while (low <= high) {
         System.out.println("l/u: " + low + "/" + high);
         int m = (high + low) / 2; // mittlerer Eintrag
         if (iArr[m] == s)
            return m; // gefunden!
         if (iArr[m] > s)
            high = m - 1;
         else
            low = m + 1;
      }
      return -1; // nichts gefunden
   }

   static int binarySearchR(int iArr[], int s) {
      return binarySearchR(iArr, 0, iArr.length - 1, s);
   }

   static int binarySearchR(int iArr[], int low, int high, int s) {
      if (low < 0 || low > high || high >= iArr.length)
         return -1;
      if (low <= high) {
         int m = (high + low) / 2; // mittlerer Eintrag
         if (iArr[m] == s)
            return m; // gefunden!
         if (iArr[m] > s)
            return binarySearchR(iArr, low, m - 1, s);
         else
            return binarySearchR(iArr, m + 1, high, s);
      }
      return -1; // nichts gefunden
   }

   static void insertionSort(int[] iArr) {
      for (int i = 1; i < iArr.length; i++) {
         int m = iArr[i];
         int j = i;
         while (j > 0 && iArr[j - 1] > m) {
            iArr[j] = iArr[j - 1];
            j--;
         }
         iArr[j] = m;
      }
   }

   static void insertionSortR(int[] iArr) {
      insertionSortR(iArr, 1);
   }

   static void insertionSortR(int[] iArr, int pos) {
      if (pos >= iArr.length)
         return;
      int m = iArr[pos];
      int j = pos;
      while (j > 0 && iArr[j - 1] > m) {
         iArr[j] = iArr[j - 1];
         j--;
      }
      iArr[j] = m;
      insertionSortR(iArr, pos + 1);
   }

   static void selectionSort(int[] ia) {
      for (int last = ia.length - 1; last > 0; last--) {
         int max_pos = 0;
         for (int i = 1; i <= last; i++)
            // Suche max_pos zwischen 1 und last
            if (ia[i] > ia[max_pos])
               max_pos = i;
         if (max_pos != last)
            swap(ia, max_pos, last);
      }
   }
   static void selectionSortR( int[] ia){
      selectionSortR( ia, ia.length-1 );
   }  
   static void selectionSortR( int[] ia, int last){
      if( last==0 )  //Basisfall 
         return;
      int max_pos = 0;
      for( int i=1; i<=last; i++ )
         if (ia[i] > ia[max_pos])
            max_pos = i;
      if( max_pos != last )
         swap( ia, max_pos, last );
      
      selectionSortR( ia, last-1 );
   }
   static int get_max_pos( int[] ia, int start ){
      if( ia.length==0 || start>=ia.length ) return -1; //Sonderfall
      if( start==ia.length-1 ) //Basisfall
         return start;
      //Rekursionsfall
      int m = get_max_pos( ia, start + 1 );  //Maximum des Rests
      return ia[start]>ia[m] ? start : m;
   }
   static void bubbleSort(int[] ia) {
      boolean swap;
      do {
         swap = false;
         for (int i = 0; i < ia.length - 1; i++)
            if (ia[i] > ia[i + 1]) {
               swap = true;
               swap(ia, i, i + 1);
            }
      } while (swap);
   }

   static void bubbleSortR(int[] ia) {
      boolean swap = false;
      for (int i = 0; i < ia.length - 1; i++)
         if (ia[i] > ia[i + 1]) {
            swap(ia, i, i + 1);
            swap = true;
         }
      if (swap)
         bubbleSortR(ia); // falls getauscht wurde -> nochmal
   }

   static void bubbleSortRR(int[] ia) { // ohne irgendeine Schleife
      boolean swap = swap_through(ia, 0, ia.length - 1); // einmal
      // durch-swappen
      if (swap)
         bubbleSortRR(ia); // falls getauscht wurde -> nochmal
   }

   private static boolean swap_through(int[] ia, int first, int last) {
      boolean swap = false;

      if (first >= last)
         return false;

      if (ia[first] > ia[first + 1]) {
         swap(ia, first, first + 1);
         swap = true;
      }

      boolean rc = swap_through(ia, first + 1, last);

      return rc || swap;
   }

   static void mergeSort(int[] ia) { // Sortieren eines ganzen Feldes
      mergeSort(ia, 0, ia.length - 1);
   }

   static void mergeSort(int[] ia, int l, int r) { // Sortieren eines
      // Feldbereichs
      if (l < r) {
         int m = (l + r) / 2; // Teilen

         mergeSort(ia, l, m); // Sortieren der beiden Teile
         mergeSort(ia, m + 1, r);

         merge(ia, l, m, r); // Mischen
      }
   }

   private static void merge(int[] ia, int l, int m, int r) {
      // Hilfsfelder
      int[] h1 = new int[m - l + 1]; // Hilfsfeld für ersten Teil
      for (int i = l; i <= m; i++)
         // ersten Teil füllen
         h1[i - l] = ia[i];

      int[] h2 = new int[r - m]; // Hilfsfeld für zweiten Teil
      for (int i = m + 1; i <= r; i++)
         // zweiten Teil füllen
         h2[i - m - 1] = ia[i];

      for (int k = l, i = 0, j = 0; k <= r; k++)
         // mischen
         if (i >= h1.length) // erster Teil 'verbraucht' ->
            ia[k] = h2[j++]; // ... aus zweiten nehmen
         else if (j >= h2.length) // zweiter Teil 'verbraucht' ->
            ia[k] = h1[i++]; // ... aus erstem nehmen
         else if (h1[i] < h2[j]) // Normalfall: Vergleichen und kleineres
            // nehmen
            ia[k] = h1[i++];
         else
            ia[k] = h2[j++];
   }

   private static void saakesmerge(int[] ia, int l, int m, int r) {
      // Hilfsfeld
      int[] b = new int[ia.length]; // Hilfsfeld
      for (int k = l; k <= m; k++)
         b[k] = ia[k];
      for (int k = m; k < r; k++)
         b[r + m - k] = ia[k + 1];
      int i = l, j = r;
      for (int k = l; k <= r; k++)
         if (b[i] < b[j])
            ia[k] = b[i++];
         else
            ia[k] = b[j--];
   }

   private static void swap(int[] arr, int p1, int p2) { // Hilfsmethode
      int tmp = arr[p1];
      arr[p1] = arr[p2];
      arr[p2] = tmp;
   }

   static void quickSort(int[] ia) { // Sortieren eines ganzen Feldes
      quickSort(ia, 0, ia.length - 1);
   }

   // Sortieren eines Feldbereichs
   static void quickSort(int[] ia, int l, int r) {
      if (l < r) {
         int p = ia[(l + r) / 2]; // Pivot-Element
         int li = l;
         int ri = r;
         while (li <= ri) {
            while (li < r && ia[li] < p)
               li++; // Element a[li]>=p
            while (ri > l && ia[ri] > p)
               ri--; // Element a[ri]<=p
            if (li <= ri) {
               swap(ia, li, ri);
               li++;
               ri--;
            }
         }
         if (l < ri)
            quickSort(ia, l, ri);
         if (li < r)
            quickSort(ia, li, r);
      }
   }

}