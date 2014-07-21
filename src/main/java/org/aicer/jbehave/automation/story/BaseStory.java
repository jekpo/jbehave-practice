package org.aicer.jbehave.automation.story;

import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.HTML;
import static org.jbehave.core.reporters.Format.TXT;
import static org.jbehave.core.reporters.Format.XML;

import java.util.ArrayList;
import java.util.List;

import org.aicer.jbehave.automation.steps.BaseSteps;
import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.testng.annotations.Test;

public abstract class BaseStory extends JUnitStories
{
    private final List<Object> registeredSteps = new ArrayList <Object>()  ;

    public BaseStory()
    {
        super();

        configuredEmbedder().embedderControls()
        .doGenerateViewAfterStories(true)
        .doIgnoreFailureInStories(false)
        .doIgnoreFailureInView(true)
        .doVerboseFailures(true)
        .useThreads(8)
        .useStoryTimeoutInSecs(60);
    }

    public void addStep(BaseSteps steps) {
        registeredSteps.add(steps);
    }

    public List<Object> getRegisteredSteps() {
        return this.registeredSteps;
    }

    @Override
    public Configuration configuration() {

        Class<? extends Embeddable> embeddableClass = this.getClass();

        return new MostUsefulConfiguration().useStoryLoader(new LoadFromClasspath(embeddableClass))
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass))
                                .withDefaultFormats().withFormats(CONSOLE, HTML, TXT, XML).withFailureTrace(true)
                                .withFailureTraceCompression(true));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), getRegisteredSteps());
    }

    @Override
    protected List<String> storyPaths() {

        // This story name will be used if the @Test is run from the IDE (Eclipse)
        final String defaultStoryName = this.getClass().getSimpleName();

        final String storyName = System.getProperty("story.name", defaultStoryName);

        final String storyPrefix = getStoryFileName(storyName);

        final String inclusions = "**/" + storyPrefix + "*.story";

        List<String> storyPaths = new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()), inclusions, "");

        System.out.println("Running Story Paths: " + inclusions + " using prefix : " + storyPrefix);

        for (String storyPath : storyPaths) {
            System.out.println(storyPath);
        }

        return storyPaths;
    }

    protected String getStoryFileName(final String className)
    {
        final StringBuilder sb = new StringBuilder("");

        if (className != null && className.length() > 0) {

            sb.append(className.substring(0, 1).toLowerCase());

            for (int i=1; i < className.length(); i++) {

                final String charAtI = className.substring(i, i+1);

                if (charAtI.matches("[A-Z]")) {
                    sb.append("_" + charAtI.toLowerCase());
                } else {
                    sb.append(charAtI);
                }
            }
        }


        return sb.toString();
    }

    /**
     * This is where the steps are registered using {@link AbstractSmokeTestStory#addStep(SmokeTestSteps)}
     *
     * All Story classes must implement this important method
     */
    public abstract void setUp();

    @Test
    public void run() throws Throwable {

        /* Registers all the steps classes for this story added via {@link BaseStory#addStep(BaseSteps)} */
        this.setUp();

        /* Run the tests via {@link  org.jbehave.core.junit.JUnitStories#run()} */
        super.run();
    }
}
