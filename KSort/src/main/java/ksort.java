public class ksort {

    String[] items;

    public ksort(){
        items = new String[800];
    }

    public int index(String item) {
        int index = -1;
        if (item.length() == 3) {
            int a = positionChar(item.charAt(0));
            int m = position(item.charAt(1));
            int n = position(item.charAt(2));

            if ((a >= 0) && (m >= 0) && (n >= 0))
                index = a * 100 + m * 10 + n;
        }

        return index;
    }

    public int position(char c) {
        int result = -1;
        int num = Character.digit(c,10);
        if ((num >= 0) && (num < 10))
            result = num;

        return result;
    }

    public int positionChar(char c) {
        int result = -1; int i = 0;
        for (int j = 'a'; j <= 'h'; j++) {
            if (c == j)
                result = i;
            i++;
        }

        return result;
    }

    public boolean add(String item) {

        int index = index(item);
        if (index >= 0)
            items[index] = item;

        return (index >= 0) ;
    }
}
