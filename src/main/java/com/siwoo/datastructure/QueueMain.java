package com.siwoo.datastructure;

import com.siwoo.datastructure.model.Employee;
import com.siwoo.datastructure.queue.ArrayQueue;

import java.util.Queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class QueueMain {

    public static void main(String[] args) {
        Queue<Employee> employees = new ArrayQueue<>(5);
        Employee jane = new Employee(123L, "Jane", "Jones");
        Employee jone = new Employee(4567L, "John", "Doe");
        Employee marry = new Employee(22L, "Mary", "Smith");
        Employee mike = new Employee(3245L, "Mike", "Wilson");
        Employee bill = new Employee(78L, "Bill", "End");

        employees.add(jane);
        employees.add(jone);
        employees.add(marry);
        employees.add(mike);
        employees.add(bill);

        printEmployeeArray(employees.toArray(new Employee[0]));

        assertEquals(employees.remove(), jane);
        assertEquals(employees.remove(), jone);
        assertEquals(employees.size(), 3);
        printEmployeeArray(employees.toArray(new Employee[0]));

        assertEquals(employees.peek(), marry);
        assertEquals(employees.size(), 3);

        assertEquals(employees.remove(), marry);
        assertEquals(employees.remove(), mike);
        assertEquals(employees.remove(), bill);
        assertTrue(employees.isEmpty());
        printEmployeeArray(employees.toArray(new Employee[0]));

        employees = new ArrayQueue<>(5);
        employees.add(jane);
        employees.add(jone);
        assertEquals(jane, employees.remove());
        assertEquals(((ArrayQueue<Employee>) employees).getCapacity(), 5);
        assertEquals(employees.size(), 1);

        employees.add(marry);
        assertEquals(jone, employees.remove());
        assertEquals(((ArrayQueue<Employee>) employees).getCapacity(), 5);
        assertEquals(employees.size(), 1);

        employees.add(mike);
        assertEquals(marry, employees.remove());
        assertEquals(((ArrayQueue<Employee>) employees).getCapacity(), 5);
        assertEquals(employees.size(), 1);

        employees.add(bill);
        assertEquals(mike, employees.remove());
        assertEquals(((ArrayQueue<Employee>) employees).getCapacity(), 5);
        assertEquals(employees.size(), 1);

        employees.add(jane);
        assertEquals(bill, employees.remove());
        assertEquals(((ArrayQueue<Employee>) employees).getCapacity(), 5);
        assertEquals(employees.size(), 1);
        employees.remove();
    }

    private static void printEmployeeArray(Employee[] employees) {
        for (Employee e: employees)
            System.out.println(e);
        System.out.println("====================================");
    }
}
