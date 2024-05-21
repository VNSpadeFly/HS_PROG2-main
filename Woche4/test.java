class test {

    public static void main(String[] args) {
        int[] x = {1, 3, 5};
        int[] y = x;
        int[] z = {0, 2, 4};
        z = y;
        System.out.println((x == z) ? "gleich" : "ungleich");
    }
  }