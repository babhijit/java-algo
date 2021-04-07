package local.bando.linkedlist.problems;

import local.bando.linkedlist.details.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class AddTwoNumbersTest {
    private static boolean areNumbersSame(ListNode<Integer> number1, ListNode<Integer> number2) {
        while(Objects.nonNull(number1) && Objects.nonNull(number2)) {
            if(!Objects.equals(number1.value, number2.value))
                return false;
            number1 = number1.next;
            number2 = number2.next;
        }

        return Objects.isNull(number1) && Objects.isNull(number2);
    }

    @Test
    void addZeroNumbers() {
        ListNode<Integer> number1 = new ListNode<>(0);
        ListNode<Integer> number2 = new ListNode<>(0);
        ListNode<Integer> sum = AddTwoNumbers.addTwoNumbers(number1, number2);

        assertEquals(0, sum.value);
    }

    @Test
    void addSingleDigitNumbersWithSumLessThan10() {
        ListNode<Integer> number1 = new ListNode<>(5);
        ListNode<Integer> number2 = new ListNode<>(4);
        ListNode<Integer> sum = AddTwoNumbers.addTwoNumbers(number1, number2);

        assertEquals(9, sum.value);
    }

    @Test
    void addSingleDigitNumbersWithSumLessEquals10() {
        ListNode<Integer> number1 = new ListNode<>(5);
        ListNode<Integer> number2 = new ListNode<>(5);
        ListNode<Integer> sum = AddTwoNumbers.addTwoNumbers(number1, number2);

        ListNode<Integer> expected = new ListNode<>(0, new ListNode<>(1));
        assertTrue(areNumbersSame(expected, sum));
    }

    @Test
    void addSingleDigitNumbersWithSumGreaterThan10() {
        ListNode<Integer> number1 = new ListNode<>(5);
        ListNode<Integer> number2 = new ListNode<>(6);
        ListNode<Integer> sum = AddTwoNumbers.addTwoNumbers(number1, number2);

        ListNode<Integer> expected = new ListNode<>(1, new ListNode<>(1));
        assertTrue(areNumbersSame(expected, sum));
    }

    @Test
    void addDoubleDigitNumbersWithoutCarry() {
        ListNode<Integer> number1 = new ListNode<>(5, new ListNode<>(5));
        ListNode<Integer> number2 = new ListNode<>(4, new ListNode<>(4));
        ListNode<Integer> sum = AddTwoNumbers.addTwoNumbers(number1, number2);

        ListNode<Integer> expected = new ListNode<>(9, new ListNode<>(9));
        assertTrue(areNumbersSame(expected, sum));
    }

    @Test
    void addDoubleDigitNumbersWithCarry() {
        ListNode<Integer> number1 = new ListNode<>(5, new ListNode<>(5));
        ListNode<Integer> number2 = new ListNode<>(5, new ListNode<>(5));
        ListNode<Integer> sum = AddTwoNumbers.addTwoNumbers(number1, number2);

        ListNode<Integer> expected = new ListNode<>(0, new ListNode<>(1, new ListNode<>(1)));
        assertTrue(areNumbersSame(expected, sum));
    }

    @Test
    void addUnequalDigitNumbersWithCarry() {
        ListNode<Integer> number1 = new ListNode<>(5, new ListNode<>(5));
        ListNode<Integer> number2 = new ListNode<>(5, new ListNode<>(5, new ListNode<>(1)));
        ListNode<Integer> sum = AddTwoNumbers.addTwoNumbers(number1, number2);

        ListNode<Integer> expected = new ListNode<>(0, new ListNode<>(1, new ListNode<>(2)));
        assertTrue(areNumbersSame(expected, sum));
    }

    @Test
    void addUnequalDigitNumbers() {
        ListNode<Integer> number1 = new ListNode<>(5);
        ListNode<Integer> number2 = new ListNode<>(5, new ListNode<>(5, new ListNode<>(9)));
        ListNode<Integer> sum = AddTwoNumbers.addTwoNumbers(number1, number2);

        ListNode<Integer> expected = new ListNode<>(0, new ListNode<>(6, new ListNode<>(9)));
        assertTrue(areNumbersSame(expected, sum));
    }

    @Test
    void addUnequalDigitNumbersToCreateHigherDigitNumber() {
        ListNode<Integer> number1 = new ListNode<>(5, new ListNode<>(5));
        ListNode<Integer> number2 = new ListNode<>(5, new ListNode<>(5, new ListNode<>(9)));
        ListNode<Integer> sum = AddTwoNumbers.addTwoNumbers(number1, number2);

        ListNode<Integer> expected = new ListNode<>(0, new ListNode<>(1, new ListNode<>(0, new ListNode<>(1))));
        assertTrue(areNumbersSame(expected, sum));
    }

}