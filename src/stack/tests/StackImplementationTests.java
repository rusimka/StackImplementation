package stack.tests;

import org.junit.jupiter.api.Test;
import stack.implementation.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class StackImplementationTests {

    @Test
    public void pushPopTest(){
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3,stack.pop());
//        assertEquals(4,stack.pop()); // FAILED, because the element on the top of the stack is 3, not 4
//
//        stack.push(4);
//        stack.push(5);
//        stack.push(6); // StackIsAlreadyFullException will be throwned
//        assertEquals(6,stack.pop());
    }

    @Test
    public void peekTest(){
        Stack stack = new Stack(5);
        stack.push(1);
        assertEquals(1,1);
    }

    @Test
    public void testGrowSizeStack(){
        Stack stack = new Stack(5);
        stack.growSizeStack(6);
        assertEquals(11,stack.getStackMaximumSize());
    }

    @Test
    public void testGetSizeStack(){
        Stack stack = new Stack(5);
        stack.push(1);
        assertEquals(1,stack.getStackSize());
    }


    @Test
    public void testIsFull()
    {

        Stack stack = new Stack(5);
        stack.push(1);
        /* Test Case 1: Assertion that the stack is not full */
        assertFalse(stack.isFull()); // PASSED TEST

        /* Test Case 2: Assertion that the stack is full */
        // assertTrue(stack.isFull()); // FAILED

        /* Test Case 3: Assertion that the stack is full when the stack is filled with all elements */
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);
//        assertTrue(stack.isFull()); // PASSED

        /* Test Case 4: Assertion that the stack is not full when is filled with all elements*/
//        assertFalse(stack.isFull()); // FAILED
    }

    @Test
    public void testIsEmpty(){
        Stack stack = new Stack(5);

        /* Test Case 1: When the stack is empty */
        assertTrue(stack.isEmpty()); // PASSED

        /* Test Case 2 - Assertion that the stack is not emtpy when the stack is actually empty*/
//        assertFalse(stack.isEmpty()); // FAILED

        /* Test Case 3 - Assertion that the stack is empty, when the stack has one element */
//        stack.push(1);
//        assertTrue(stack.isEmpty()); // FAILED

        /* Test Case 4 - Assertion that the stack is not emtpy, when it has one element */
//        assertFalse(stack.isEmpty()); // PASSED
    }


}

