public class Main {
    public static void main(String[] args) {
        int i, j, temp, n = 10;
        int[] arr = new int[n];
        double a;
        for(i = 0; i < n; i++) {
            a = Math.random() * 100;
            arr[i] = (int) a;
        }
        for(i = n-1; i > 0; i--)
            for(j = 0; j < i; j++)
                if(arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
        System.out.print("arranged array is: ");
        for(i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}

