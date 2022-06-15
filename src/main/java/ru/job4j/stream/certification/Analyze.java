package ru.job4j.stream.certification;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    /**
     * Метод averageScore вычисляет общий средний балл
     * по всем переданым ученикам и предметам
     * @param stream of Pupil
     * @return
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMapToInt(pupil -> pupil.getSubjects().stream()
                    .mapToInt(Subject::getScore))
                    .average()
                    .orElse(0D);
    }

    /**
     * Метод вычисляет средний балл по каждому предмету
     * @param stream List of Pupil
     * @return
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(e -> new Tuple(e.getName(), e.getSubjects().stream()
                        .mapToInt(Subject::getScore)
                        .average()
                        .orElse(0D)))
                .collect(Collectors.toList());
    }

    /**
     * Метод вычисляет средний балл по каждому ученику
     * @param stream of Pupil
     * @return List of Tuple
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(s -> new Tuple(s.getKey(), s.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * возвращает лучшего ученика. Лучшим считается
     * ученик с наибольшим баллом по всем предметам.
     * @param stream
     * @return
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(e -> new Tuple(e.getName(), e.getSubjects().stream()
                        .mapToInt(Subject::getScore)
                        .sum()))
                .max(Comparator.comparing(Tuple::getScore)).orElse(null);
    }

    /**
     * возвращает предмет с наибольшим баллом для всех студентов.
     * @param stream
     * @return
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(e -> new Tuple(e.getKey(), e.getValue()))
                .max(Comparator.comparing(Tuple::getScore)).orElse(null);
    }
}
