#include <sys/wait.h>
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <errno.h>
#include <ctype.h>

#define READ_SIDE 0
#define WRITE_SIDE 1
#define ONE_BYTE 1

void
die(char * input)
{
	fprintf(stderr, "error -- %s\n", input);
	exit(EXIT_FAILURE);
}

// Returns true if EOF hit, false otherwise, die() on failure
bool
safe_read_one_byte(int fd, char * [] buffer)
{
	int read_return_code;
	read_return_code = read(fd, buffer, ONE_BYTE);
	if (read_return_code == 0)
	{
		return 1;
	}
	else if (read_return_code > 0)
	{
		return 0;
	}
	else
	{
		die("unable to read()");
	}
}

// Writes a byte to the FD
void
safe_write_one_byte(int fd, char * [] buffer)
{
	int write_return_code;
	write_return_code = write(fd, *buffer, strlen(*buffer)+1);
	if (write_return_code < 0)
	{
		die("unable to write()");
	}
}

// Open pipes and put fd in pointer to int array die() on failure
void
safe_pipe_open(int * [] input)
{
	if (pipe(*input) == -1)
	{
		die("unable to pipe()");
	}
}

// Closes an fd, die() on failure
void
safe_close_fd(int fd)
{
	if (close(fd) == -1)
	{
		die("unable to close fd");
	}
}

int
main(void)
{
	// reusable memory
    int parent_to_child_fd[2];
    int child_to_parent_fd[2];
    pid_t pid;
	char buffer[1];
	safe_pipe_open(&parent_to_child_fd);
	safe_pipe_open(&child_to_parent_fd);
    pid = fork();
    if (pid < 0)
    {
		die("failed to fork");
    }
    if (pid > 0) /* PARENT */
    {
        int child_return_code;
		safe_close_fd(parent_to_child_fd[READ_SIDE]);
		safe_close_fd(child_to_parent_fd[WRITE_SIDE]);
		while(1)
		{
			// Read from stdin
			if (safe_read_one_byte(STDIN_FILENO, &buffer))
			{
				break;
			}
			// Write to child
			safe_write_one_byte(parent_to_child_fd[WRITE_SIDE], &buffer);
			// Read from child
			if (safe_read_one_byte(child_to_parent_fd[READ_SIDE], &buffer))
			{
				break;
			}
			// Write to stdout
			printf("%c", buffer[0]);
		}
		safe_close_fd(parent_to_child_fd[WRITE_SIDE]);
		safe_close_fd(child_to_parent_fd[READ_SIDE]);
		wait(&child_return_code);
		if (child_return_code != 0)
		{
			die("child returned non-zero return code");
		}
	}
	else /* CHILD */
	{
		safe_close_fd(parent_to_child_fd[WRITE_SIDE]);
		safe_close_fd(child_to_parent_fd[READ_SIDE]);
		while(1)
		{
			// Read from parent
			if (safe_read_one_byte(parent_to_child_fd[READ_SIDE], &buffer))
			{
				break;
			}
			// Convert to uppercase
			buffer[0] = toupper(buffer[0]);
			// Write to parent
			safe_write_one_byte(child_to_parent_fd[WRITE_SIDE], &buffer);
		}
		safe_close_fd(parent_to_child_fd[WRITE_SIDE]);
		safe_close_fd(child_to_parent_fd[READ_SIDE]);
	}
    return EXIT_SUCCESS;
}
