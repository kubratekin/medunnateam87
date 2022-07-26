
Feature: DB Appointment tests

  Background:  db connection set up
    Given user creates a connection with DB using "jdbc:postgresql://medunna.com:5432/medunna_db" and "medunnadb_user", "Medunnadb_@129"

    @dbtest

    Scenario Outline: db validations

      #Given  user send the to DB  "<query>" and "<columnName>"
    #  And user saves the DB records to correspondent files
      #Then user validates DB data

      Examples: test data
      |query|columnName|
      |Select  * from appointment|status|
