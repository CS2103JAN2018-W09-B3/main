package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import static java.util.Objects.requireNonNull;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.AddLessonCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.lesson.Day;
import seedu.address.model.lesson.Time;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DAY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_START_TIME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_END_TIME;

/**
 * Parses input arguments and creates a new AddCommandCommand object
 */
public class AddLessonCommandParser implements Parser<AddLessonCommand> {
    static final int NAME_INDEX = 0;
    static final int START_TIME_INDEX = 1;
    static final int END_TIME_INDEX = 2;

    /**
     * Parses the given {@code String} of arguments in the context of the AddLessonCommand
     * and returns an AddLessonCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddLessonCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_START_TIME, PREFIX_END_TIME);

        Index index;
        Day day;
        Time startTime;
        Time endTime;

        try {
            System.out.println("LMAO");

            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (IllegalValueException ive) {
            System.out.println("LMAO2");

            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddLessonCommand.MESSAGE_USAGE));
        }

        try {
            day = ParserUtil.parseDay(argMultimap.getValue(PREFIX_DAY)).get();
            System.out.println("LMAO3: " + day);

            startTime = ParserUtil.parseTime(argMultimap.getValue(PREFIX_START_TIME)).get();
            endTime = ParserUtil.parseTime(argMultimap.getValue(PREFIX_END_TIME)).get();
        } catch (IllegalValueException ive) {
            throw new ParseException(ive.getMessage(), ive);
        }

        return new AddLessonCommand(index, day, startTime, endTime);
    }

}