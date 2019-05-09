#Author: praveen9319@gmail.com


Feature: I want to test chatBot bubble task and it's functionality.


  Scenario Outline: Chat Bot Bubble function 
		Given I am on Haptik HomePage
    When I click on chat bubble
    Then I validate the menu    
    When I select "<task1>" from TaskBar
    Then I get various bots
    When I choose "<bot>"
    Then I receive three options
    When I click on "<selectedBotChoice1>"
    Then I get two options to choose from
    When I click on "<selectedBotChoice2>"
    Then I get few instruction
    When I click Menu
    And  I select "<task2>" from TaskBar
    Then I recieve AboutBot instruction
    Then I verify bot title
    And I verify bot tag
    And I verify AboutBot message
    And I close chat bubble

    Examples: 
      | task1 				| bot 				|selectedBotChoice1  |selectedBotChoice2|task2								|
			|Haptik Products|Concierge Bot|See an example			 |Not my problem		|Learn About Chatbots	|