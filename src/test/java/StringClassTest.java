import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringClassTest {
    @Test
    public void stringSplitTest() {
        String str = "1, 2";
        String[] strArr = str.split(", ");
        assertThat(strArr[0]).isEqualTo("1");
        assertThat(strArr[1]).isEqualTo("2");
    }

    @Test
    public void stringSplitTestWithOnlyOneNumber() {
        String str = "1";
        String[] strArr = str.split(", ");
        assertThat(strArr[0]).isEqualTo("1");
    }

    @Test
    public void removeBracketTest() {
        String str = "(1, 2)";
        String result = str.substring(1, str.length() - 1);
        assertThat(result).isEqualTo("1, 2");
    }

    @Test
    public void usingCharAtTest() {
        String str = "abc";
        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');
    }

    @Test
    public void whenCharAtOutOfBounds() {
        String str = "abc";
        assertThatThrownBy(() -> {
            char c = str.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .withFailMessage("Index: \\d+, Size: \\d+");
    }
}
