package ru.skillbench.tasks.thirdTask.SQLProgramme;

import java.util.Scanner;

public class SQLProgramme {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a group of students: ");
        String group = in.next();
        System.out.print("Enter the critical number of debts: ");
        String dolgCount = in.next();
        System.out.println("\nSQL query: ");
        System.out.printf("INSERT INTO \n\tT_GroupSelected(id_Student, firstName, lastName, id_Group)\n" +
                "VALUES (SELECT id_Student, firstName, lastName, id_Group \n\t\tFROM T_Student\n\t\t" +
                "WHERE id_Group = '%s' AND dolgCount > %s)", group, dolgCount);

    }
}
