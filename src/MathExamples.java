public class MathExamples {

    public static void main(String[] args) {
        MathExamples mathExamples = new MathExamples();
//        int result1 = overloadingExample.add(1, 2);
//        long result2 = overloadingExample.add(1L, 2L);
//        long result3 = overloadingExample.add(3L);

        float div = mathExamples.divide(10, 5);
        System.out.println(div);

    }

    public int add(int a, int b) {
        return Math.addExact(a,b);
    }

    public long add(long a, long b) {
        return Math.addExact(a,b);
    }

    public long add(long a) {
        return Math.addExact(a,a);
    }

    public float divide(int num, int div) {
        float result = 0;

        try {
            result = Math.floorDiv(num, div);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            result = result*2;
        }
        return result;

    }

}
