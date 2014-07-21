package org.aicer.jbehave.automation.story;

import org.aicer.jbehave.automation.steps.BankAccountSteps;

public class BankAccountBasic extends BaseStory {

    public BankAccountBasic() {
        super();
    }

    @Override
    public void setUp() {
        this.addStep(new BankAccountSteps());
    }
}
