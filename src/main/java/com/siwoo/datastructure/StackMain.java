package com.siwoo.datastructure;


import com.siwoo.datastructure.linkedlist.LinkedListImpl;
import com.siwoo.datastructure.model.Employee;
import com.siwoo.datastructure.stack.ArrayStack;
import com.siwoo.datastructure.stack.Stack;

import java.util.Deque;
import java.util.LinkedList;

public class StackMain {

    public static void main(String[] args) {
        Stack<Employee> employees = new ArrayStack<>();
        Stack<Employee> linkedEmployees = new LinkedListImpl<>();

        Employee jane = new Employee(123L, "Jane", "Jones");
        Employee jone = new Employee(4567L, "John", "Doe");
        Employee marry = new Employee(22L, "Mary", "Smith");
        Employee mike = new Employee(3245L, "Mike", "Wilson");
        Employee bill = new Employee(78L, "Bill", "End");

        employees.push(jane);
        linkedEmployees.push(jane);
        employees.push(jone);
        linkedEmployees.push(jone);
        employees.push(marry);
        linkedEmployees.push(marry);
        employees.push(mike);
        linkedEmployees.push(mike);
        employees.push(bill);
        linkedEmployees.push(bill);

        System.out.println(linkedEmployees.peek());
        System.out.println(employees.peek());
        System.out.println("====================");
        printEmployeesArray(linkedEmployees.toArray(new Employee[0]));
        printEmployeesArray(employees.toArray(new Employee[0]));

        System.out.println("Popped: " + linkedEmployees.pop());
        System.out.println("Peeked: " + linkedEmployees.peek());
        System.out.println("Popped: " + employees.pop());
        System.out.println("Peeked: " + employees.peek());
        System.out.println("====================");
        printEmployeesArray(linkedEmployees.toArray(new Employee[0]));
        printEmployeesArray(employees.toArray(new Employee[0]));
    }

    private static void printEmployeesArray(Employee[] employees) {
        for (Employee e: employees) {
            if (e != null)
                System.out.println(e);
        }
    }
}
