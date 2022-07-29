  @US19 @team87
  Feature: US19_Edit or Delete Staff information by Admin and validate with DB
    Scenario: US19 Admin should validate staff info using DB
      Given Admin connects to DB
      When Admin gets all "id" from DB
      Then Admin verifies Staff exist at DB "138219"
      And Admin closes the DB connection
