package com.demoqa.shop.util;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.List;

public class CreateReport {


    public void generateReportForJsonFiles(File reportOutputDirectory, List<String> jsonFiles) {
        String buildNumber = "1";
        String projectName = "Final Task";
        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.setParallelTesting(false);
        configuration.setBuildNumber(buildNumber);
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}
