Scenario: Bank Account Basic Setup

Given I have a Bank Account
And I have a starting balance of $0.00
When I make a $50.00 deposit
Then I will see that my balance is $50.00
