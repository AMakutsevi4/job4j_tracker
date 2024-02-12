package ru.job4j.hashmap;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;
import java.util.function.BiFunction;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int index = 0;
        double scoreAll = 0.0;
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                scoreAll += s.score();
                index++;
            }
        }
        return scoreAll / index;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labelList = new ArrayList<>();
        for (Pupil p : pupils) {
            labelList.add(new Label(p.name(), p.subjects().stream().mapToDouble(Subject::score).sum()
                    / p.subjects().stream().mapToInt(Subject::score).count()));
        }
        return labelList;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> entity = new LinkedHashMap<>();
        List<Label> labelList = new ArrayList<>();
        BiFunction<Integer, Integer, Integer> function = (oldValue, newValue) -> oldValue + newValue;

        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                entity.merge(s.name(), s.score(), function);
            }
        }
        entity.forEach((key, value) -> labelList.add(new Label(key, (double) value / pupils.size())));

        return labelList;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        Map<String, Integer> entity = new LinkedHashMap<>();
        List<Label> labelList = new ArrayList<>();
        for (Pupil p : pupils) {
            entity.put(p.name(), p.subjects().stream().mapToInt(Subject::score).sum());
        }
        for (String s : entity.keySet()) {
            labelList.add(new Label(s, entity.get(s)));
        }
        labelList.sort(Comparator.naturalOrder());
        return labelList.get(labelList.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> entity = new LinkedHashMap<>();
        List<Label> labelList = new ArrayList<>();
        int index = 0;
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                entity.merge(s.name(), s.score(), (oldValue, newValue) -> oldValue + newValue);
            }
            entity.forEach((key, value) -> labelList.add(new Label(key, value)));

            for (Label label : labelList) {
                if (label.score() > labelList.get(index).score()) {
                    index++;
                }
            }
        }
        return labelList.get(index);
    }
}