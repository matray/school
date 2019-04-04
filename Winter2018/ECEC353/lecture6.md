* detached threads have stack automatically reaped from virtual address space

# Smart way to wait for pids is in 5-sigchld.c
* If a child dies, SIGCHLD is sent to you

# Process Groups
* Normally a singular foreground or background job is built of processes in a process group.
* Whenever run a foreground job in shell, it should have it's own process group
* setpgid(pid, pid) is used to avoid race conditions, check 1-foreground.c
* reference 1-foreground.c for set_fg_pgid()

```C
void set_fg_pgid (pid_t pgid)
{
    void (*old)(int);
    old = signal(SIGTTOU, SIG_IGN);
    tcsetpgrp(STDIN_FILENO, pgid);
    tcsetpgrp(STDOUT_FILENO, pgid);
    signal(SIGTTOU, old);
}
```

* Also look at that file (1-foreground.c) for safe_print() function
* The handler in that file is relevant too, turns out you can get SIGCHLD for a lot of reasons, not just child termination
* Need to pass appropriate bitmasks to waitpid() in order to check if stopped or continued state changes
* Issue in safe_print that the child may try to print to the display while taking control temporarily
* When foreground process terminates, maybe print it then, but it needs to be solved
* Note the importance of stty tostop, it turns on adherence to background printing
