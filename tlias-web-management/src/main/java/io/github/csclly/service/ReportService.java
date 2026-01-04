package io.github.csclly.service;

import io.github.csclly.poji.ClazzOption;
import io.github.csclly.poji.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption getEmpJobData();

    List<Map<String, Object>> getEmpGenderData();

    ClazzOption getStudentCountData();

    List<Map<String, Object>> getStudentDegreeData();
}
