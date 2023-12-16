package dev.radom.constructmanage.api.construction.employee.model;

public record EmployeeDetailsDto(String address,
                                 String emergencyContact,
                                 String qualifications,
                                 Integer experience,
                                 String certifications,
                                 String languageSpoken,
                                 String performanceReviews,
                                 String trainingHistory,
                                 String leaveRecords) {
}
