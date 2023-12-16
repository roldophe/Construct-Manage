package dev.radom.constructmanage.api.construction.employee.dto;

import java.util.Set;

public record AddEmployeeDetailsDto(String address,
                                    String emergencyContact,
                                    String qualifications,
                                    Integer experience,
                                    String certifications,
                                    String languageSpoken,
                                    Set<AddBankAccountDetailsDto> bankAccountDetails,
                                    String performanceReviews,
                                    String trainingHistory,
                                    String leaveRecords) {
}
