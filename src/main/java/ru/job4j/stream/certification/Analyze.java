package ru.job4j.stream.certification;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    /**
     * Метод averageScore вычисляет общий средний балл
     * по всем переданым ученикам и предметам
     * @param stream
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
     * @param stream
     * @return
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(e -> new Tuple(e.getName(), e.getSubjects().stream()
                        .mapToInt(Subject::getScore)
                        .average()
                        .orElse(0D) ))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return List.of();
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return null;
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return null;
    }
}
