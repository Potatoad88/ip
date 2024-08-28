package demurebot.command;

import demurebot.task.Task;
import demurebot.task.TaskList;
import demurebot.ui.Ui;

public class MarkCommand extends Command {
    private final String remainder;

    public MarkCommand(String remainder) {
        super(false);
        this.remainder = remainder;
    }

    @Override
    public void execute(TaskList list, Ui ui) {
        try {
            int index = Integer.parseInt(remainder) - 1;
            Task task = list.getTask(index);
            task.markAsDone();
            ui.displayMarkTask(task);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a positive integer after mark.\n");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index: " +
                (Integer.parseInt(remainder)) +
                "\n" +
                "Please enter a number within 1 to number of current tasks.\n"
            );
        }
    }
}
