package com.siwoo.datastructure;

import com.siwoo.datastructure.linkedlist.LinkedList;
import com.siwoo.datastructure.linkedlist.LinkedListImpl;
import com.siwoo.datastructure.model.Employee;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.matchers.JUnitMatchers;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class LinkedListMain {

    public static void main(String[] args) {
        Employee jane = new Employee(123L, "Jane", "Jones");
        Employee jone = new Employee(4567L, "John", "Doe");
        Employee marry = new Employee(22L, "Mary", "Smith");
        Employee mike = new Employee(3245L, "Mike", "Wilson");
        Employee bill = new Employee(78L, "Bill", "End");


        LinkedList<Employee> employees = new LinkedListImpl<>();
        assertTrue(employees.isEmpty());
        employees.addLast(jane);
        employees.addLast(jone);
        employees.addLast(marry);
        employees.addLast(mike);
        assertEquals(employees.size(), 4);
        printEmployees(employees.toArray(new Employee[5]));

        new java.util.LinkedList<>().iterator();
        employees.removeLast();
        assertEquals(employees.size(), 3);
        assertThat(Arrays.asList(employees.toArray(new Employee[0])), not(hasItem(mike)));
        System.out.println("===================");
        printEmployees(employees.toArray(new Employee[0]));

        employees.removeLast();
        assertEquals(employees.size(), 2);
        assertThat(Arrays.asList(employees.toArray(new Employee[0])), not(hasItems(mike, marry)));
        System.out.println("===================");
        printEmployees(employees.toArray(new Employee[0]));

        employees.addFirst(bill);
        assertEquals(employees.toArray()[employees.size() - 1], bill);
        System.out.println("===================");
        printEmployees(employees.toArray(new Employee[0]));

        employees.addLast(mike);
        System.out.println("===================");
        assertEquals(employees.toArray(new Employee[0])[0], mike);
        printEmployees(employees.toArray(new Employee[0]));

        employees.removeFirst();
        assertEquals(employees.size(), 3);
        assertThat(employees, hasItems(mike, jane, jane));
        assertThat(employees, not(hasItem(bill)));
        System.out.println("===================");
        printEmployees(employees.toArray(new Employee[0]));

        employees.removeLast();
        assertEquals(employees.size(), 2);
        assertThat(employees, hasItems(jane, jane));
        assertThat(employees, not(hasItem(mike)));
        System.out.println("===================");
        printEmployees(employees.toArray(new Employee[0]));

        employees.removeLast();
        assertEquals(employees.size(), 1);
        assertThat(employees, hasItems(jane));
        assertThat(employees, not(hasItem(jone)));
        System.out.println("===================");
        printEmployees(employees.toArray(new Employee[0]));

        employees.removeLast();
        assertEquals(employees.size(), 0);
        assertTrue(employees.isEmpty());
        assertThat(employees, not(hasItems(mike, jane, jane)));
        System.out.println("===================");
        printEmployees(employees.toArray(new Employee[0]));
    }

    private static void printEmployees(Object[] employees) {
        for (Object o: employees) {
            if (o instanceof Employee)
                System.out.println(o);
        }
    }

}
