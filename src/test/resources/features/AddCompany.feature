# new feature
# Tags: optional
Feature: Add company as super admin

  Background:
    Given User is on SquareLogin page "http://192.168.1.192:3000"
    And User enters email as "hamza.ramy.ing@gmail.com" and password as "Aziz@123"
    And user clicks on Enterprise within the menu
    And user clicks on Add Enterprise

  @InvalidValues
  Scenario Outline: fill required field with invalid values
    When user enter "<value>" into "<field>"
    Then the "<field>" validation should be "<error message>"
    Examples:
      | field                   | value  | error message                                      |
        #test the company's name field
      | company_name            |        | Nom est obligatoire                                |
      | company_name            | a      | La longueur minimale requise est de 2 caractères.  |

        #test the company's serial number field
      | company_serial_number   |        | Matricule fiscal est obligatoire                   |
      | company_serial_number   | 1      | La longueur minimale requise est de 8 caractères.  |

            #test the company's email field
      | company_email           |        | Email est obligatoire                              |
      | company_email           | test1. | Veuillez entrer une adresse e-mail valide.         |

            #test the company's phone number field
      | company_phone           |        | Téléphone est obligatoire                          |
      | company_phone           | 1234   | La longueur minimale requise est de 11 caractères. |

            #test the company's country field
      | company_country_empty   |        | Pays est obligatoire                               |
      | company_country_invalid | aaa    | Pas d'options                                      |

            #test the company's city field
      | company_city_empty      |        | Ville est obligatoire                              |
      | company_city_invalid    | aaa    | Pas d'options                                      |

            #test the company's address field
      | company_address         |        | Adresse est obligatoire                            |

            #test the company's postcode field
      | company_postcode        |        | Code postal est obligatoire                        |
      | company_postcode        | a      | La valeur doit etre un nombre                      |
      | company_postcode        | 12     | La longueur minimale requise est de 4 caractères.  |

