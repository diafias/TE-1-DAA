class Main {
    public static void main(String args[]) {

        //generate dataset untuk radix sort
        int[] A = GenerateAlgorithm.generateRandomNumbers(1000);
        int[] B = GenerateAlgorithm.generateSortedNumbers(1000);
        int[] C = GenerateAlgorithm.generateReverseSortedNumbers(1000);
        GenerateAlgorithm.saveNumbersToFile(A, ("generateRandomNumbers1000"));
        GenerateAlgorithm.saveNumbersToFile(B, ("generateSortedNumbers1000"));
        GenerateAlgorithm.saveNumbersToFile(C, ("generateReverseSortedNumbers1000"));

        int[] D = GenerateAlgorithm.generateRandomNumbers(10000);
        int[] E = GenerateAlgorithm.generateSortedNumbers(10000);
        int[] F = GenerateAlgorithm.generateReverseSortedNumbers(10000);
        GenerateAlgorithm.saveNumbersToFile(D, ("generateRandomNumbers10000"));
        GenerateAlgorithm.saveNumbersToFile(E, ("generateSortedNumbers10000"));
        GenerateAlgorithm.saveNumbersToFile(F, ("generateReverseSortedNumbers10000"));

        int[] G = GenerateAlgorithm.generateRandomNumbers(100000);
        int[] H = GenerateAlgorithm.generateSortedNumbers(100000);
        int[] I = GenerateAlgorithm.generateReverseSortedNumbers(100000);
        GenerateAlgorithm.saveNumbersToFile(G, ("generateRandomNumbers100000"));
        GenerateAlgorithm.saveNumbersToFile(H, ("generateSortedNumbers100000"));
        GenerateAlgorithm.saveNumbersToFile(I, ("generateReverseSortedNumbers100000"));

        //membaca dataset baru untuk peeksort

        int[] random1000  = GenerateAlgorithm.readNumbersFromFile(("generateRandomNumbers1000"));
        int[] random10000 = GenerateAlgorithm.readNumbersFromFile(("generateRandomNumbers10000"));
        int[] random100000 = GenerateAlgorithm.readNumbersFromFile(("generateRandomNumbers100000"));
        int[] sorted1000 = GenerateAlgorithm.readNumbersFromFile(("generateSortedNumbers1000"));
        int[] sorted10000 = GenerateAlgorithm.readNumbersFromFile(("generateSortedNumbers10000"));
        int[] sorted100000 = GenerateAlgorithm.readNumbersFromFile(("generateSortedNumbers100000"));
        int[] reverseSorted1000 = GenerateAlgorithm.readNumbersFromFile(("generateReverseSortedNumbers1000"));
        int[] reverseSorted10000 = GenerateAlgorithm.readNumbersFromFile(("generateReverseSortedNumbers10000"));
        int[] reverseSorted100000 = GenerateAlgorithm.readNumbersFromFile(("generateReverseSortedNumbers100000"));

        // hitung runtime dan memori, cara memakainya masukkan array dari daftar array diatas satu per satu
        Runtime runtime = Runtime.getRuntime();
        System.gc();
        long beforeUsedMemory = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime();

        RadixSortAlgorithm.radixSort(reverseSorted100000, reverseSorted100000.length);

        long endTime = System.nanoTime();
        long afterUsedMemory = runtime.totalMemory() - runtime.freeMemory();
        long usedMemoryBytes = afterUsedMemory - beforeUsedMemory;
        double usedMemoryKB = (double) usedMemoryBytes / 1024;

        System.out.println("Penggunaan Memori Radix Sort = " + usedMemoryKB);
        System.out.println("Penggunaan Runtime Radix Sort = " + (endTime - startTime));
        System.out.println("");

        GenerateAlgorithm.saveNumbersToFile(reverseSorted100000, "hasilRadixsortReverseSorted100000");

        //membaca dataset baru untuk peeksort
        
        int[] randomPS1000  = GenerateAlgorithm.readNumbersFromFile(("generateRandomNumbers1000"));
        int[] randomPS10000 = GenerateAlgorithm.readNumbersFromFile(("generateRandomNumbers10000"));
        int[] randomPS100000 = GenerateAlgorithm.readNumbersFromFile(("generateRandomNumbers100000"));
        int[] sortedPS1000 = GenerateAlgorithm.readNumbersFromFile(("generateSortedNumbers1000"));
        int[] sortedPS10000 = GenerateAlgorithm.readNumbersFromFile(("generateSortedNumbers10000"));
        int[] sortedPS100000 = GenerateAlgorithm.readNumbersFromFile(("generateSortedNumbers100000"));
        int[] reverseSortedPS1000 = GenerateAlgorithm.readNumbersFromFile(("generateReverseSortedNumbers1000"));
        int[] reverseSortedPS10000 = GenerateAlgorithm.readNumbersFromFile(("generateReverseSortedNumbers10000"));
        int[] reverseSortedPS100000 = GenerateAlgorithm.readNumbersFromFile(("generateReverseSortedNumbers100000"));

        // hitung runtime dan memori, cara memakainya masukkan array dari daftar array diatas satu per satu
        Runtime runtime1 = Runtime.getRuntime();
        System.gc();
        long beforeUsedMemory1 = runtime1.totalMemory() - runtime1.freeMemory();
        long startTime1 = System.nanoTime();

        PeekSortAlgorithm.peekSort(reverseSortedPS100000, 0, reverseSortedPS100000.length-1);

        long endTime1 = System.nanoTime();
        long afterUsedMemory1 = runtime1.totalMemory() - runtime1.freeMemory();
        long usedMemoryBytes1 = afterUsedMemory1 - beforeUsedMemory1;
        double usedMemoryKB1 = (double) usedMemoryBytes1 / 1024;

        System.out.println("Penggunaan Memori Peeksort = " + usedMemoryKB1);
        System.out.println("Penggunaan Runtime Peeksort = " + (endTime1 - startTime1));
        System.out.println("");
        
        GenerateAlgorithm.saveNumbersToFile(reverseSortedPS100000, "hasilPeeksortReverseSorted100000");

    }
  }