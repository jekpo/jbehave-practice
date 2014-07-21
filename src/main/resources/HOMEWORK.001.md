
Automate the following stories

### Story Number One (BankAccountDefault) ###

First Scenario

Given I have a Bank Account
And I have a starting balance of $0.00
When I make a $50.00 deposit
Then I will see that my balance is $50.00


### Story Number 2 (BankAccountTransactions) ###

First Scenario

Given I have a Bank Account
And I have a starting balance of $0.00
When I make a $50.00 deposit
Then I will see that my balance is $50.00
Second Scenario

Given I have a Bank Account
And I have a starting balance of $80.00
When I make a $50.00 deposit
Then I will see that my balance is $130.00
And I will see that I am able to make a withdrawal


Third Scenario

Given I have a Bank Account
And I have a starting balance of $-30.00
When I make a $50.00 deposit
Then I will see that my balance is $20.00
And I will see that I am able to make a withdrawal

Fourth Scenario

Given I have a Bank Account
And I have a starting balance of $-80.00
When I make a $50.00 deposit
Then I will see that my balance is $-30.00
And I will see that I am unable to make a withdrawal
And I will see that I am able to make a deposit

