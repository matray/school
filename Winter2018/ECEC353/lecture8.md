# Project 2 Notes
* Foreground really just means "has the display and keyboard"
* A child process group created by the shell will be in the foreground if it is launched without an ending & on the command line, otherwise the shill will keep the foreground
* If a foreground child process group is suspended via CTRL-Z, then the shell will receive SIGCHLD
* It is the responsibility of the shell to take back control of the foreground
* IF the shell is in the foreground and a background child process group is brought to the foreground via fg, then the shell must give the background process group the foreground before continuing the process group, if necessary
* The children could be in the background and stopped at the time the fg targeting them was issued
* Having the foreground or the background is not intrinsically tied to the run state of a process.
* A process can be:
    * foreground + stopped (should never happen, implies shell is not in the foreground)
    * foreground + running
    * background + stopped
    * background + running
* If a foreground process is stopped, it should be moved to the background
* IT is the shell's job to prevent foreground + stopped from happening
* The shell will be informed via a SIGCHLD signal when the one of its children becomes stopped
* Shell should reclaim foreground
* The shell is the sole manager of foreground/background management
* The shell is not the sole manager of it's child processes's run states
* Child process run state may change due to a signal from:
    * Another process - who knows while child processes were programmed to do?
    * The controlling terminal - due to CTRL-C/Z/\
    * The kernel - using too many resources
    * Your shell - job management
* Fortunately, it doesn't matter who changed the state for one of the shell's child processes. Regardless, the shell will receive a SIGCHLD when the state change occurs.
* As long as the shell always properly reacts to the state change, it doesn't matter how, why, or by whom the state was changed
* The shell should not be installing signal handlers into it's child processes
* Note that installing signal handlers in the shell will be inherited by the child processes so be careful!
* IF you do that, it shouldn't break the shell, but maybe the child processes
* The only signals caught and handled by the shell are signals sent to the shell
* The shell should only install signal handlers into itself
* Furthermore, it is impossible for process A to catch signals sent to process B.
* Recommend that right before you exec, within the fork'ed child, you default them all
* You can always reset a signal handler for a child process back to its default handler using signal(sig, SIG_DFL) after a fork() if necessary
* Not doing this may cause child processes to act strangely, but it shouldn't break your shell
* Possibly exec() will reset the signal table, should check that
* If the shell receives a SIGTTOU or SIGTTIN, that means it was trying to print something (the prompt) or a job status change message to the display when some other job had the foreground
* The only way the shell will get the foreground back is if it receives a signal indicating that the foreground process should be removed from the foreground (e.g. the foreground process group is suspended or terminated)
* Consequently, the shell should pause() -- i.e. wait for another signal -- until it gets the foreground back - know how it returns!
* What happens when in SIGTTOU handler with pause() when SIGCHLD is called - when do you return from this? Well, if in signal handler and get different signal, you will service other signal first, then pause() with give back control. So, inside SIGTTOU handler, you should check to see if you have the foreground, then you will pause then leave when you get it (loop this - while not in foreground pause())
* Simply returning from the pause() doesn't mean the shell has the foreground back.
* It just means the shell received a signal
* The shell should check if it has the foreground before returning from the handler - if it doesn't, it should continue to pause().

# Semaphore
* You can do three things with them, they can be confusing
* The three things are context dependent
* Can count
* Waiting on a semaphore decreases the count
* If it is zero, the semaphore blocks until it can take a value from it
* You can post to a semaphore which increments the count
* All counting (de/increment) is atomic
* You either down a semaphore or post/up a semaphore
* A binary semaphore is a semaphore which has a value of 1
* A binary semaphore effectively works like a mutex
* Now when at a critical section, you wait on the semaphore, when exiting the section, you post to the semaphore
* You can also use semaphore's as signals - similar to condition variables
* You initialize the semaphore to zero - so posting increments and unwaits another thread
* You wait on the signaling semaphore and it will block
* If you have finite resources, you can use a semaphore to throttle everything
