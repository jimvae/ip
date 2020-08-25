package duke.commands;

import duke.TaskList;
import duke.Ui;
import duke.Storage;
import duke.exceptions.DukeException;


public interface Command {
    public boolean execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;
}
