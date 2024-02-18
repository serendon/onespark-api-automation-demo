@LifeInsurance @Regression @InstantEstimate

Feature: One Spark - Life Insurance API Instant Estimate

  Scenario Outline: Get Instant Estimate
    Given I have a valid URL
    When a POST request is made to "/api/v1/individual-life/quote/quick" with payload : "<age>" , "<gender>" ,"<qualification>" ,"<occupation>" ,"<amount>" ,"<useOfTobaccoNicotine>"
    Then the response will return status 200
    And Verify the Insurance Premiums is returned <lifeCoverPremium> , <disabilityCoverPremium> , <tempIncomeProtectionPremium> , <illnessCoverPremium>

    Examples:
      | age | gender | qualification | occupation                           | amount | useOfTobaccoNicotine | lifeCoverPremium | disabilityCoverPremium | tempIncomeProtectionPremium | illnessCoverPremium |
      | 65  | female | MATRIC        | 4c79f5d0-12d7-8edb-2982-7d676c1b912d | 15000  | NEVER                | 93346            | 0                      | 0                           | 139484              |
      | 18  | male   | NO_MATRIC     | 4c79f5d0-12d7-8edb-2982-7d676c1b912d | 20000  | DAILY                | 26821            | 11893                  | 12652                       | 8386                |
      | 30  | female | MATRIC        | 4c79f5d0-12d7-8edb-2982-7d676c1b912d | 50000  | WEEKLY               | 10668            | 12846                  | 26824                       | 15482               |
      | 65  | male   | NO_MATRIC     | 4c79f5d0-12d7-8edb-2982-7d676c1b912d | 5000   | NEVER                | 206313           | 0                      | 0                           | 223264              |
      | 18  | female | MATRIC        | 4c79f5d0-12d7-8edb-2982-7d676c1b912d | 1000   | WEEKLY               | 22820            | 13372                  | 437                         | 6175                |

