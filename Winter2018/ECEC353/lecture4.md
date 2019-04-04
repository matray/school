#Registers
* Went over how registers started with 16 bit support
* This progressed to 32 bit and eventually 64 bit
* Going over threading today
* Not a new process entirely
* Threading creates a second stack and an associated cpu state
* Changing thread swaps cpu registers eas, edx, PC, esp, ebp

```C
int foo(int a, int b)
{
    char c = 7;
    char d = 8;
    return a + b + c + d;
}

int main(int argc, char ** argv[])
{
    foo(4, 5);
}
```

# What happens in the stack?
* So there is a stack pointer and a frame pointer
* The stack pointer keeps moving down to store data

Virtual Address Space
STACK
5
4
ret addr
OLD EBP
7
8
* All local variables when accessed in foo(), is asking compiler to put something in the stack
* Need to take notes on how threading works transition from kernel thread and user thread book is a good source of information
* Changes stack/program counter
* It is possible to have "threads" without the kernel
* Kernel threads are different because you are given an execution context
* The Kernel handles yielding the CPU when run out of time to another thread
* Preempt - save thread state, move it, run something else
* Two implementations of threads
* POSIX threads
* also known as pthreads
* native pthreads library (NPTL) comes with the kernel
* GNU Pth is pthreads compliant (portable, but no kernel support)
* Understand User threads and Kernel threads
* "If you feel saucy over the weekend, try out writing windows threads"
* gcc -pthread v. gcc -lpthread: -pthread works better and gives more functionality somehow
* If you don't join and read completed threads, you will fill up the table and run in to issues
* Creator or thread itself can call pthread_detach() to detach itself. If you try to join with it, the function will return an error
* You can also modify the thread's attributes (which includes if it is detached)
*
