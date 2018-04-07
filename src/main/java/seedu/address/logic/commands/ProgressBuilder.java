package seedu.address.logic.commands;

//@@author yapni

import seedu.address.model.student.dashboard.Progress;

/**
 * A utility class to help with building Progress objects.
 */
public class ProgressBuilder {

    private int totalTasks;
    private int numCompletedTasks;
    private int progressInPercent;
    private String value;

    public ProgressBuilder(Progress progressToCopy) {
        totalTasks = progressToCopy.getTotalTasks();
        numCompletedTasks = progressToCopy.getNumCompletedTasks();
        progressInPercent = progressToCopy.getProgressInPercent();
        value = progressToCopy.getValue();
    }

    /**
     * Adds 1 to the {@code totalTask} of the {@code Progress} we are building.
     */
    public ProgressBuilder withOneNewIncompletedTaskToTotal() {
        this.totalTasks += 1;
        setProgressPercentAndValue();

        return this;
    }

    /**
     * Subtracts 1 from the {@code totalTask} of the {@code Progress} we are building.
     */
    public ProgressBuilder withOneLessIncompletedTaskFromTotal() {
        this.totalTasks -= 1;
        setProgressPercentAndValue();

        return this;
    }

    /**
     * Subtracts 1 from the {@code totalTask} and {@code numCompletedTask } of the {@code Progress} we are building.
     */
    public ProgressBuilder withOneLessCompletedTaskFromTotal() {
        this.totalTasks -= 1;
        this.numCompletedTasks -= 1;
        setProgressPercentAndValue();

        return this;
    }

    /**
     * Adds 1 to the {@code numCompletedTasks} of the {@code Progress} we are building.
     */
    public ProgressBuilder withOneMoreCompletedTask() {
        this.numCompletedTasks += 1;
        setProgressPercentAndValue();

        return this;
    }

    /**
     * Creates and returns the Progress object with the current attributes.
     */
    public Progress build() {
        return new Progress(value);
    }

    /**
     * Sets the {@code progressInPercent} and {@code value} of the Progress we are building with the current attributes.
     */
    private void setProgressPercentAndValue() {
        this.progressInPercent = (int) (((double) numCompletedTasks / totalTasks) * 100);
        this.value = this.numCompletedTasks + "/" + this.totalTasks;
    }
}
