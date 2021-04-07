package local.bando.linkedlist.problems;

import local.bando.linkedlist.details.ListNode;

import java.util.Objects;

public final class AddTwoNumbers {
    public static ListNode<Integer> addTwoNumbers(ListNode<Integer> number1, ListNode<Integer> number2) {
        ListNode<Integer> result = new ListNode<>();
        int carry = 0;

        ListNode<Integer> current = result;

        do {
            int sum = carry;
            if(Objects.nonNull(number1)) {
                sum += number1.value;
                number1 = number1.next;
            }
            if(Objects.nonNull(number2)) {
                sum += number2.value;
                number2 = number2.next;
            }
            carry = sum / 10;
            current.next = new ListNode<>(sum % 10);
            current = current.next;
        } while(Objects.nonNull(number1) || Objects.nonNull(number2) || (carry > 0));

        return result.next;
    }

}
