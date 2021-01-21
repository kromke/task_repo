package hackerrank.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TheBestAptitudeTest {
    static class Student {
        private final double gap;
        private ArrayList<Double> tests = new ArrayList<>(5);
        private int gapRank;

        public Student(double gap) {
            this.gap = gap;
        }
    }

    public static void main(String[] args) {

        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader(System.in))) {

            //количество тестов
            int test = Integer.parseInt(reader.readLine());

            for (int i = 0; i < test; i++) {
                //количество студентов
                int studentsNumber = Integer.parseInt(reader.readLine());
                ArrayList<Student> students = new ArrayList<>(studentsNumber);
                //годовой средний балл
                String[] gaps = reader.readLine().split(" ");

                System.out.println();
                for (int j = 0; j < studentsNumber; j++) {
                    students.add(new Student(Double.parseDouble(gaps[j])));

                }




                //результаты тестов
                for (int j = 0; j < 5; j++) {
                    String[] tests = reader.readLine().split(" ");

                    for (int k = 0; k < studentsNumber; k++) {
                        students.get(k).tests.add(Double.parseDouble(tests[k]));
                    }
                }

                students.sort(Comparator.comparingDouble(s -> s.gap));

                for (int j = 0; j < studentsNumber; j++) {
                    students.get(j).gapRank = j;
                }

                int testLine = 0;
                int sum = Integer.MAX_VALUE;

                for (int j = 0; j < 5; j++) {
                    int n = j;
                    Collections.reverse(students);
                    students.sort(Comparator.comparingDouble(s -> s.tests.get(n)));
                    int count = 0;

                    for (int k = 0; k < studentsNumber; k++) {
                        count += Math.abs(students.get(k).gapRank - k);
                    }

                    if (count < sum) {
                        testLine = j;
                        sum = count;
                    }
                }

                System.out.println(testLine + 1);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
