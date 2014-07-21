package org.aicer.jbehave.automation.story;

import org.aicer.jbehave.automation.steps.CustomerSteps;

public class CustomerStory extends BaseStory {

    @Override
    public void setUp() {
        this.addStep(new CustomerSteps());
    }
}
