import static org.junit.Assert.*;

public class ksortTest {

    @org.junit.Test
    public void index() {
        ksort sort = new ksort();
        assertEquals(-1,sort.index("a000"));
        assertEquals(-1,sort.index("a0"));
        assertEquals(-1,sort.index("000"));
        assertEquals(0,sort.index("a00"));
        assertEquals(1,sort.index("a01"));
        assertEquals(0,sort.index("a00"));
        assertEquals(201,sort.index("b01"));
        assertEquals(700,sort.index("h00"));
        assertEquals(99,sort.index("a99"));

    }

    @org.junit.Test
    public void position() {
        ksort sort = new ksort();
        assertEquals(-1,sort.position('b'));
        assertEquals(1,sort.position('1'));
        assertEquals(0,sort.position('0'));
        assertEquals(9,sort.position('9'));
        assertEquals(5,sort.position('5'));

    }

    @org.junit.Test
    public void positionChar() {
        ksort sort = new ksort();
        assertEquals(0,sort.positionChar('a'));
        assertEquals(7,sort.positionChar('h'));
        assertEquals(5,sort.positionChar('f'));
        assertEquals(-1,sort.positionChar('u'));
        assertEquals(-1,sort.positionChar('2'));
    }

    @org.junit.Test
    public void add() {
        ksort sort = new ksort();
        assertFalse(sort.add("00"));
        assertFalse(sort.add("a000"));
        assertFalse(sort.add("add"));

        assertTrue(sort.add("a00"));
        assertTrue(sort.add("a01"));
        assertTrue(sort.add("a02"));
        assertTrue(sort.add("a03"));
        assertTrue(sort.add("h99"));

        for (String x: sort.items) {
            if (x != null)
                System.out.print(x + " ");
        }

    }
}