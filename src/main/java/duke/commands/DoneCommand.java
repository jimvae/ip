package duke.commands;

import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.exceptions.DukeAlreadyDoneException;
import duke.exceptions.DukeException;
import duke.exceptions.DukeInvalidIndexException;
import duke.task.Task;

public class DoneCommand implements Command {
    public Integer index;

    public DoneCommand(Integer index) {
        this.index = index;
    }
    public boolean execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (index >= tasks.getSize() || index < 0) {
            throw new DukeInvalidIndexException();
        }
        Task currentTask = tasks.getTask(index);

        if (currentTask.isDone) {
            throw new DukeAlreadyDoneException();
        }
        tasks.markAsDone(index);
        ui.doneMessage(currentTask);
        storage.save(tasks.getPlanner());
        return false;
    }
}
