package org.asmeta.eclipse;

import java.io.File;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Path;

import org.apache.log4j.PatternLayout;
import org.apache.log4j.WriterAppender;
import org.asmeta.simulator.main.Simulator;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * abstract class for action handlers for asmeta actions
 */
abstract public class AsmetaActionHandler extends AbstractHandler {	
	
	protected AsmetaConsole console;
	private Class<? extends AsmetaConsole> consoleClass;
	private String action;
	
	/**
	 * Instantiates a new asmeta action handler.
	 *
	 * @param consoleClass the console class
	 * @param action the action for messages - use gerund like validationg...
	 */
	protected AsmetaActionHandler(Class<? extends AsmetaConsole> consoleClass, String action) {
		this.consoleClass = consoleClass;
		this.action = action;
	}
	

	@Override
	final public Object execute(ExecutionEvent event) throws ExecutionException {
		// get and open the console
		console = AsmetaUtility.findConsole(consoleClass);
		setOutput(console);
		// get the current file
		File path = null;
		try {
			IFile ifile = getModelPath(event, console);
			path = ifile.getRawLocation().makeAbsolute().toFile();
			assert path.exists();
		} catch (Exception e) {
			Display d = Display.getDefault();
			Shell shell = new Shell(d);
			MessageBox message = new MessageBox(shell);
			message.setMessage("Error while parsing " + path + "\n\n" + e.getLocalizedMessage());
			message.open();
			//
			e.printStackTrace();
		}
		// should never happen
		if (path == null) {
			console.writeMessage("path not found");
			return null;
		}
//		mc.writeMessage("PATH " + path);
		setUpLoggers();
		// execute action
		try {
			console.writeMessage( action + " on " + path);			
			executeAction(path);			
		} catch (Throwable t) {
			// show in the console
			console.writeMessage("Error " + t.getLocalizedMessage());
			// show as message
			Display d = Display.getDefault();
			Shell shell = new Shell(d);
			MessageBox message = new MessageBox(shell);
			message.setMessage("Error while executing action on " + path + "\n\n" + t.getLocalizedMessage());
			message.setText("Action error");
			message.open();
			t.printStackTrace();
		}
		return null;
	}

	protected abstract void executeAction(File path) throws Exception;


	/**
	 * get model path and activate console view 
	 *
	 * @param event   the event
	 * @param console the console
	 * @return the string
	 * @throws Exception the exception
	 */
	protected IFile getModelPath(ExecutionEvent event, AsmetaConsole console) throws Exception {
		/*
		 * 		// get the path for the current editor file asmeta
		IWorkbench workbench = PlatformUI.getWorkbench();
		// IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		IWorkbenchWindow window = workbench == null ? null : workbench.getActiveWorkbenchWindow();		
		 */
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		// get the file
		IFile path = AsmetaUtility.getEditorPath(window);
		// open the simulator console
		IConsoleView view = (IConsoleView) window.getActivePage().showView(IConsoleConstants.ID_CONSOLE_VIEW);
		view.display(console);
		return path;
	}

	private WriterAppender outputfromSim;

	// set the right output to the logger
	private void setOutput(AsmetaConsole mc) {
		// SET THE RIGHT OUTPUT
		if (outputfromSim == null) {
			OutputStream out = mc.newOutputStream();
			// redirect std output to this console
			// non è chiaro se serva o meno
			// alcuni plugin assumon che venga fatto altri no!
			PrintStream printOut = new PrintStream(out);
			System.setOut(printOut);
			System.setErr(printOut);
			outputfromSim = new WriterAppender(new PatternLayout("%m%n"), out);
//			Logger.getLogger("org.asmeta.simulator").addAppender(outputfromSim);
//			Simulator.logger.addAppender(outputfromSim);
			Simulator.logger.addAppender(outputfromSim);
		}
	}

	protected abstract void setUpLoggers();

}
