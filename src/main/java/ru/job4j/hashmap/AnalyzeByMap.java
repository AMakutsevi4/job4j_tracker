package ru.job4j.hashmap;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                entity.put(s.name(), s.score() + entity.getOrDefault(s.name(), 0));
            }
        }
        for (String s : entity.keySet()) {
            labelList.add(new Label(s, (double) entity.get(s) / pupils.size()));
        }

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
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                entity.put(s.name(), s.score() + entity.getOrDefault(s.name(), 0));
            }
            for (String s : entity.keySet()) {
                labelList.add(new Label(s, entity.get(s)));
            }
            labelList.sort(Comparator.naturalOrder());
        }
        return labelList.get(labelList.size() - 1);
    }
}